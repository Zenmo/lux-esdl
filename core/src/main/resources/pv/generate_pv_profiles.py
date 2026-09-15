"""Generate a normalized PV production profile per orientation, with pvlib.

Called by energy.lux.esdl.core.loader.pv.PVProfileGenerator as

    python generate_pv_profiles.py <request file> <response file>

The request holds the irradiance of the ESDL and the orientations that occur in it. The
response holds one column per orientation, in the order the first line names them, with one
line per moment in time. Values are a fraction of installed power, which is the unit LUX calls
NORMALIZEDPOWER.

The model parameters mirror data_Generic/WeatherAndEPEX-data/PVLIB_data/BSRN_Cabouw_irradiance_data.py,
the script that produced the two profiles LUX shipped with, so that a generated profile stays
comparable with those. Setting pdc0 to 1 is what makes the result a fraction rather than a power.
"""

import sys
from datetime import datetime

import numpy as np
import pandas as pd
import pvlib
from pvlib import location, modelchain, pvsystem

# PVWatts default loss percentages, which are also pvlib's defaults. Stated here so that a
# change to either is visible rather than silent.
LOSSES_PARAMETERS = {
    "soiling": 2,
    "shading": 3,
    "snow": 0,
    "mismatch": 2,
    "wiring": 2,
    "connections": 0.5,
    "lid": 1.5,
    "nameplate_rating": 1,
    "age": 0,
    "availability": 3,
}

MODULE_PARAMETERS = {"pdc0": 1.0, "gamma_pdc": -0.004}

# SAPM cell temperature model, glass/polymer module on a close roof mount.
TEMPERATURE_MODEL_PARAMETERS = {"a": -3.56, "b": -0.075, "deltaT": 3}

INVERTER_PARAMETERS = {"pdc0": 1.0, "pac0": 0.96, "eta_inv_nom": 0.95}


def read_request(path):
    """Read the request.

    A line is either a single setting, "<key> <value>", or the header of a block of values,
    "values <key> <count>", which the next <count> non-empty lines hold one per line.
    """
    request = {}

    # utf-8-sig so that a byte order mark, which some editors add, does not end up in the
    # first key.
    with open(path, "r", encoding="utf-8-sig") as request_file:
        for line in request_file:
            line = line.rstrip("\n")
            if not line:
                continue

            key, _, rest = line.partition(" ")
            if key == "values":
                name, _, count = rest.partition(" ")
                request[name] = read_values(request_file, name, int(count))
            else:
                request[key] = rest

    request["orientations"] = [
        parse_orientation(key) for key in request["orientations"].split(" ") if key
    ]
    return request


def read_values(request_file, name, count):
    values = []
    for line in request_file:
        line = line.strip()
        if not line:
            continue
        values.append(float(line))
        if len(values) == count:
            return np.array(values)

    raise ValueError("Expected %d values for %s but read %d" % (count, name, len(values)))


def parse_orientation(key):
    tilt, _, azimuth = key.partition(":")
    return key, float(tilt), float(azimuth)


def parse_start(raw, time_zone):
    """Java writes an ISO-8601 instant. Older Python cannot read the trailing Z itself."""
    normalized = raw.strip()
    if normalized.endswith("Z"):
        normalized = normalized[:-1] + "+00:00"

    start = datetime.fromisoformat(normalized)
    timestamp = pd.Timestamp(start)

    if timestamp.tzinfo is None:
        # A profile without an offset is stamped in the zone LUX runs in.
        return timestamp.tz_localize(time_zone)
    return timestamp


def build_weather(request, site):
    """Turn the single irradiance series of the ESDL into the three components pvlib wants.

    The ESDL carries only global horizontal irradiance, while the transposition to the plane
    of the panels needs the direct and diffuse parts separately. Erbs derives them from the
    clearness index; it is the decomposition pvlib documents for exactly this case.
    """
    time_zone = request["time_zone"]
    start = parse_start(request["start"], time_zone)
    step = pd.Timedelta(seconds=int(request["step_seconds"]))

    ghi_values = request["global_horizontal_irradiance_w_per_m2"]

    times = pd.date_range(start=start, periods=len(ghi_values), freq=step)
    times = times.tz_convert(time_zone)

    ghi = pd.Series(ghi_values, index=times)

    solar_position = site.get_solarposition(times)
    decomposed = pvlib.irradiance.erbs(ghi, solar_position["zenith"], times)

    weather = pd.DataFrame(
        {
            "ghi": ghi,
            "dni": decomposed["dni"].fillna(0.0),
            "dhi": decomposed["dhi"].fillna(0.0),
            "temp_air": ambient_temperature(request, len(times)),
            "wind_speed": float(request["wind_speed_m_per_s"]),
        },
        index=times,
    )
    return weather


def ambient_temperature(request, steps):
    """The measured outside temperature when the ESDL states one, otherwise a fixed value.

    The reader sends a block of values in the first case and a single number in the second,
    so which of the two arrived decides what pvlib is given.
    """
    temperature = request["ambient_temperature_deg_c"]
    if not isinstance(temperature, np.ndarray):
        return float(temperature)

    if len(temperature) != steps:
        raise ValueError(
            "Got %d ambient temperatures for %d timesteps" % (len(temperature), steps)
        )
    return temperature


def run_orientation(site, weather, tilt_degrees, azimuth_degrees):
    array = pvsystem.Array(
        mount=pvsystem.FixedMount(
            surface_tilt=tilt_degrees,
            surface_azimuth=azimuth_degrees,
        ),
        module_parameters=MODULE_PARAMETERS,
        temperature_model_parameters=TEMPERATURE_MODEL_PARAMETERS,
    )

    system = pvsystem.PVSystem(
        arrays=[array],
        inverter_parameters=INVERTER_PARAMETERS,
        losses_parameters=LOSSES_PARAMETERS,
    )

    model_chain = modelchain.ModelChain(
        system,
        site,
        aoi_model="physical",
        spectral_model="no_loss",
        temperature_model="sapm",
        losses_model="pvwatts",
    )
    model_chain.run_model(weather)

    # The inverter model draws a little power at night, which is not production.
    return model_chain.results.ac.fillna(0.0).clip(lower=0.0)


def write_response(path, orientations, profiles):
    with open(path, "w", encoding="utf-8") as response_file:
        response_file.write(" ".join(key for key, _, _ in orientations) + "\n")

        columns = np.column_stack([profiles[key] for key, _, _ in orientations])
        for row in columns:
            response_file.write(" ".join("%.6g" % value for value in row) + "\n")


def main():
    if len(sys.argv) != 3:
        raise SystemExit("Usage: generate_pv_profiles.py <request file> <response file>")

    request_path, response_path = sys.argv[1], sys.argv[2]

    request = read_request(request_path)
    site = location.Location(
        float(request["latitude"]),
        float(request["longitude"]),
        request["time_zone"],
    )

    weather = build_weather(request, site)
    print("Modelling %d orientation(s) over %d timesteps" % (len(request["orientations"]), len(weather)))

    profiles = {}
    for key, tilt_degrees, azimuth_degrees in request["orientations"]:
        production = run_orientation(site, weather, tilt_degrees, azimuth_degrees)
        profiles[key] = production.to_numpy()

        full_load_hours = production.sum() * int(request["step_seconds"]) / 3600.0
        print("tilt %g azimuth %g: %.0f full load hours" % (tilt_degrees, azimuth_degrees, full_load_hours))

    write_response(response_path, request["orientations"], profiles)


if __name__ == "__main__":
    main()
