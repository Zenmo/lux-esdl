
plugins {
    `java-library`
    id("anylogic-dependencies")
}

version = "dev"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
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
}

val anylogicJarDependencies by configurations.creating {
    isCanBeConsumed = false
    isCanBeResolved = true
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

dependencies {
    implementation(project(":luxdeps"))
    implementation("org.slf4j:slf4j-api:2.0.18")
    // Only for running exportScenario from Gradle. The anylogicJar bundles
    // anylogicJarDependencies rather than the runtime classpath, so it stays out of it.
    runtimeOnly("ch.qos.logback:logback-classic:1.5.6")

    implementation("nl.tno.esdl:esdl:2.26.5")
    implementation("org.eclipse.emf:org.eclipse.emf.common:2.45.0")
    implementation("org.eclipse.emf:org.eclipse.emf.ecore:2.42.0")
    implementation("org.eclipse.emf:org.eclipse.emf.ecore.xmi:2.40.0")
    implementation("com.zenmo:timeseries:0.0.1")

    anylogicJarDependencies("nl.tno.esdl:esdl:2.26.5")
    anylogicJarDependencies("org.eclipse.emf:org.eclipse.emf.common:2.45.0")
    anylogicJarDependencies("org.eclipse.emf:org.eclipse.emf.ecore:2.42.0")
    anylogicJarDependencies("org.eclipse.emf:org.eclipse.emf.ecore.xmi:2.40.0")
    anylogicJarDependencies("com.zenmo:timeseries:0.0.1")

    //testImplementation(platform("org.junit:junit-bom:6.0.3"))
    testImplementation("org.junit.jupiter:junit-jupiter:6.0.3")
    testImplementation("org.assertj:assertj-core:3.27.7")
    testImplementation("ch.qos.logback:logback-classic:1.5.6")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    compileOnly("org.projectlombok:lombok:1.18.34")
    annotationProcessor("org.projectlombok:lombok:1.18.34")
}

// TODO: this Jar seems too big. It add unncessary transitive dependencies.
tasks.register<Jar>("anylogicJar") {
    group = "build"
    description = "Creates a JAR for use in AnyLogic, containing only the ESDL loader and minimum dependencies."

    archiveClassifier.set("anylogic")

    duplicatesStrategy = DuplicatesStrategy.EXCLUDE

    from(sourceSets.main.get().output)

    from({
        anylogicJarDependencies
            .filter { it.name.endsWith(".jar") }
            .map { zipTree(it) }
    })

    exclude(
        "META-INF/*.SF",
        "META-INF/*.DSA",
        "META-INF/*.RSA"
    )
}

// Runs one scenario headlessly and writes the two Excel exports, replacing the manual
// export from the AnyLogic results UI. Pick the scenario in ScenarioExport.
tasks.register<JavaExec>("exportScenario") {
    group = "application"
    description = "Run a scenario end to end and export its electricity profiles to Excel."
    mainClass.set("energy.lux.esdl.core.export.ScenarioExport")
    classpath = sourceSets.main.get().runtimeClasspath
    maxHeapSize = "8g"
    systemProperty("scenario", (project.findProperty("scenario") ?: "") as String)
    luxPythonExecutable.orNull?.let { systemProperty("lux.pythonExecutable", it) }
}

tasks.test {
    useJUnitPlatform()
    // The decorated congestion ESDL files are ~68 MB of XML and do not fit in 2g once EMF has parsed them.
    maxHeapSize = "8g"
    // Loading an ESDL that describes PV generates its production profiles with pvlib.
    luxPythonExecutable.orNull?.let { systemProperty("lux.pythonExecutable", it) }
    testLogging {
        events("passed", "skipped", "failed")
        showStandardStreams = true
    }
}
