
plugins {
    `java-library`
}

group = "energy.lux.esdl"
version = "dev"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(libs.versions.java.get())
    }
}

repositories {
    mavenCentral()
    maven {
        url = uri("https://ci.hesi.energy/artifactory/libs-release-local")
    }
    maven {
        url = uri("https://maven.pkg.github.com/zenmo/timeseries")
        credentials {
            username = "erikvv"
            // token with no special privileges, just to read a public package
            password = listOf(
                "github",
                "pat",
                "11AANKZZI03L0gJOmv0NFP",
                "Zg6LweIfRMLJv7pYkNg1a70F1DHchMLvlftrxpqDp1AB3FULMDL0JvJcZyK",
            ).joinToString("_")
        }
    }

    // The LUX Loader brings these: com.zenmo:bag and vallum, and the geotools that bag needs.
    maven {
        url = uri("https://maven.pkg.github.com/zenmo/lux-data-portal")
        content { includeGroup("com.zenmo") }
        credentials {
            username = "erikvv"
            // token with no special privileges, just to read a public package
            password = listOf(
                "github",
                "pat",
                "11AANKZZI03L0gJOmv0NFP",
                "Zg6LweIfRMLJv7pYkNg1a70F1DHchMLvlftrxpqDp1AB3FULMDL0JvJcZyK",
            ).joinToString("_")
        }
    }
    exclusiveContent {
        forRepository { maven("https://repo.osgeo.org/repository/release/") }
        filter {
            includeGroupAndSubgroups("org.geotools")
            includeGroupAndSubgroups("it.geosolutions")
            includeGroup("javax.media")
        }
    }
}

/**
 * The interpreter that generate_pv_profiles.py runs in, which has to have pvlib installed.
 * See core/src/main/resources/pv/requirements.txt.
 *
 * Set luxPythonExecutable in gradle.properties. Without it the loader falls back to `python`
 * on the PATH, which on Windows is usually the Microsoft Store stub rather than a real
 * interpreter. Forwarded explicitly because Gradle runs tests and applications in a forked JVM,
 * which does not inherit the system properties of the Gradle daemon.
 */
val luxPythonExecutable = providers.gradleProperty("luxPythonExecutable")

// The LUX Loader finds its default profiles and averages relative to the working directory,
// so the tests and the export run from the lux2 checkout.
val lux2Directory = rootDir.resolve("../lux2")

dependencies {
    implementation("energy.lux:Engine:local")
    implementation("energy.lux:Loader:local")
    implementation("org.slf4j:slf4j-api:2.0.18")
    // Only for running exportScenario from Gradle.
    runtimeOnly("ch.qos.logback:logback-classic:1.5.6")

    // Used to come in with the AnyLogic jars; the LUX Loader does not export them.
    implementation("org.apache.poi:poi-ooxml:5.2.5")
    implementation("org.apache.commons:commons-math3:3.6.1")
    implementation("com.google.code.findbugs:jsr305:3.0.2")

    implementation("nl.tno.esdl:esdl:2.26.5")
    implementation("org.eclipse.emf:org.eclipse.emf.common:2.45.0")
    implementation("org.eclipse.emf:org.eclipse.emf.ecore:2.42.0")
    implementation("org.eclipse.emf:org.eclipse.emf.ecore.xmi:2.40.0")
    implementation("com.zenmo:timeseries:0.0.1")


    //testImplementation(platform("org.junit:junit-bom:6.0.3"))
    testImplementation("org.junit.jupiter:junit-jupiter:6.0.3")
    testImplementation("org.assertj:assertj-core:3.27.7")
    testImplementation("ch.qos.logback:logback-classic:1.5.6")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    compileOnly("org.projectlombok:lombok:1.18.42")
    annotationProcessor("org.projectlombok:lombok:1.18.42")
}

// Runs one scenario headlessly and writes the two Excel exports, replacing the manual
// export from the AnyLogic results UI. Pick the scenario in ScenarioExport.
tasks.register<JavaExec>("exportScenario") {
    group = "application"
    description = "Run a scenario end to end and export its electricity profiles to Excel."
    mainClass.set("energy.lux.esdl.core.export.ScenarioExport")
    classpath = sourceSets.main.get().runtimeClasspath
    maxHeapSize = "8g"
    workingDir = lux2Directory
    systemProperty("lux.esdlDirectory", rootDir.resolve("esdl-app/data_ProjectTemplate").canonicalPath)
    systemProperty("lux.exportDirectory", layout.buildDirectory.dir("exports").get().asFile.path)
    systemProperty("scenario", (project.findProperty("scenario") ?: "") as String)
    luxPythonExecutable.orNull?.let { systemProperty("lux.pythonExecutable", it) }
}

tasks.test {
    useJUnitPlatform()
    workingDir = lux2Directory
    // The decorated congestion ESDL files are ~68 MB of XML and do not fit in 2g once EMF has parsed them.
    maxHeapSize = "8g"
    // Loading an ESDL that describes PV generates its production profiles with pvlib.
    luxPythonExecutable.orNull?.let { systemProperty("lux.pythonExecutable", it) }
    testLogging {
        events("passed", "skipped", "failed")
        showStandardStreams = true
    }
}
