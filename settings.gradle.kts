rootProject.name = "lux-esdl"

include(
    "core",
)

// Composite build: Gradle compiles the LUX Engine and Loader from source and hands them to core.
// When a project includes lux-esdl, that project brings its own LUX, and it is the one to use.
if (gradle.parent == null) {
    includeBuild("../lux2/backend") {
        dependencySubstitution {
            substitute(module("energy.lux:Engine")).using(project(":Engine"))
            substitute(module("energy.lux:Loader")).using(project(":Loader"))
        }
    }
}

pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

plugins {
    // To download JDK versions if the developer does not have the right version installed
    id("org.gradle.toolchains.foojay-resolver-convention").version("1.0.0")
}

dependencyResolutionManagement {
    // Import the version catalog of the main LUX project.
    // This way we sync the Java version.
    versionCatalogs {
        create("libs") {
            from(files("../lux2/backend/gradle/libs.versions.toml"))
        }
    }
}
