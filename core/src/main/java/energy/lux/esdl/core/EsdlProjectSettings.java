package energy.lux.esdl.core;

import energy.lux.loader.LoaderProjectSettings;

/**
 * The settings for a LUX loader that is only used to prepare an energy model for an ESDL.
 * A project that has its own settings class passes that to its loader instead.
 */
@lombok.experimental.SuperBuilder(toBuilder = true)
public class EsdlProjectSettings extends LoaderProjectSettings {
}
