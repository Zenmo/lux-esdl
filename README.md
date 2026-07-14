LUX ESDL
===

Library to make [LUX Energy Twin](https://lux.energy)
interoperable with [ESDL](https://github.com/EnergyTransition/ESDL).

Uses [LUX Engine](https://github.com/zenmo/zero_engine) 
and [LUX Loader](https://github.com/Zenmo/zero_Interface-Loader)
and the ESDL Java library.

Currently only supports loading and ESDL file into a simulation model. 
Does not support writing model output to an ESDL file.

Repository structure
---

- [core](./core): the library
    - [core.iterator](./core/src/main/java/energy/lux/esdl/core/iterator): iterates over ESDL elements.
    - [core.loader](./core/src/main/java/energy/lux/esdl/core/loader): creates LUX domain classes from ESDL elements.
    - [core/build/libs](./core/build/libs): Output location of the compiled Jar file for use in AnyLogic.
- [esdl-app](./esdl-app) AnyLogic simulation model which uses ESDL as input.
- [luxdeps](./luxdeps) generated Java classes from the LUX model.
- [buildSrc](./buildSrc) Gradle plugin which adds dependencies to luxdeps and core.
