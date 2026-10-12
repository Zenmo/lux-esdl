LUX ESDL
===

Library to make [LUX Energy Twin](https://lux.energy)
interoperable with [ESDL](https://github.com/EnergyTransition/ESDL).

Uses [LUX Engine](https://github.com/zenmo/zero_engine) 
and [LUX Loader](https://github.com/Zenmo/zero_Interface-Loader)
and the ESDL Java library.

Currently only supports loading ESDL files, not writing them.

## Normalizing an ESDL

The loader expects an electricity demand that states its yearly total in its name ("Total: 3958.0 kwh")
to hold a profile that integrates to 1. Some generators write a profile in kW instead. Convert such a file with

    ./gradlew normalizeEsdl -PesdlIn=<input.esdl> -PesdlOut=<output.esdl>

Only those profiles are changed; the rest of the file is copied as it is.
