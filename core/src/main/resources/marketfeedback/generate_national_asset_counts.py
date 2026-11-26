"""Generate national_asset_counts.csv: per pocket and neighbourhood archetype, how many households and
flex assets the country has in it.

Run by hand when the archetype data changes, as

    python generate_national_asset_counts.py <pockets_to_archetypes.xlsx> <national_asset_counts.csv>

The workbook comes from ISIE/Pockets_to_archetypes, which divides the national ETM scenarios over the
TenneT pockets and the GO-e archetypes. It has one row per scenario, pocket and sub-archetype. An ESDL
stands for one sub-archetype in one pocket; NationalAssetCounts sums the pockets for an ESDL that stands
for its sub-archetype in the whole country.

Of the 32 scenarios only the stock family (the part of scen_key before the adoption level) changes what
households own: adoptieniveau_prijsprikkels and congestieprikkel are price signal settings. So the table
has one row per stock family, pocket and sub-archetype, taken from the first scenario of each family.

Left out on purpose:
- electric boilers: the aggregator only plans heat pumps;
- large-scale batteries: they are part of the PyPSA run that made the day-ahead price, and are not
  modelled in the neighbourhoods.
"""

import sys

import pandas as pd

SHEET = "share_heat_method_ESDL"
ADOPTION_LEVELS = ("_laag_", "_hoog_")


def stock_family(scenario_key):
    for adoption_level in ADOPTION_LEVELS:
        if adoption_level in scenario_key:
            return scenario_key.split(adoption_level)[0]
    raise ValueError(f"Scenario key {scenario_key} names no adoption level")


def first_scenario_of_each_family(table):
    first_keys = table.groupby("stock_family")["scen_key"].first()
    return table[table["scen_key"].isin(first_keys)]


def asset_counts_per_cell(table):
    households = table["Totaal woningen"]
    evs = households * table["EV_avgPerHousehold"]
    return pd.DataFrame({
        "stock_family": table["stock_family"],
        "pocket": table["pocket"],
        "sub_archetype": table["sub_archetype"],
        "households": households,
        "heat_pumps": households * (table["Lucht WP"] + table["Bodem WP"]),
        "hybrid_heat_pumps": households * table["Hybride WP"],
        "evs": evs,
        "v2g_evs": evs * table["V2G_share_cars"],
        "batteries": households * table["home_battery_share"],
    })


def main(workbook, output_file):
    table = pd.read_excel(workbook, SHEET)
    table["stock_family"] = table["scen_key"].map(stock_family)
    cells = asset_counts_per_cell(first_scenario_of_each_family(table))
    counts = cells.sort_values(["stock_family", "pocket", "sub_archetype"])
    if counts.duplicated(["stock_family", "pocket", "sub_archetype"]).any():
        raise ValueError("The workbook has several rows for the same stock family, pocket and sub-archetype")
    counts.to_csv(output_file, index=False, float_format="%.3f", lineterminator="\n")


if __name__ == "__main__":
    main(sys.argv[1], sys.argv[2])
