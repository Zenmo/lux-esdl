
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
}

val anylogicJarDependencies by configurations.creating {
    isCanBeConsumed = false
    isCanBeResolved = true
}

dependencies {
    implementation(project(":luxdeps"))
    implementation("org.slf4j:slf4j-api:2.0.18")

    implementation("nl.tno.esdl:esdl:2.26.5")
    implementation("org.eclipse.emf:org.eclipse.emf.common:2.45.0")
    implementation("org.eclipse.emf:org.eclipse.emf.ecore:2.42.0")
    implementation("org.eclipse.emf:org.eclipse.emf.ecore.xmi:2.40.0")

    anylogicJarDependencies("nl.tno.esdl:esdl:2.26.5")
    anylogicJarDependencies("org.eclipse.emf:org.eclipse.emf.common:2.45.0")
    anylogicJarDependencies("org.eclipse.emf:org.eclipse.emf.ecore:2.42.0")
    anylogicJarDependencies("org.eclipse.emf:org.eclipse.emf.ecore.xmi:2.40.0")

    //testImplementation(platform("org.junit:junit-bom:6.0.3"))
    testImplementation("org.junit.jupiter:junit-jupiter:6.0.3")
    testImplementation("org.assertj:assertj-core:3.27.7")
    testImplementation("ch.qos.logback:logback-classic:1.5.6")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    compileOnly("org.projectlombok:lombok:1.18.34")
    annotationProcessor("org.projectlombok:lombok:1.18.34")
}

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

tasks.test {
    useJUnitPlatform()
    maxHeapSize = "2g"
    testLogging {
        events("passed", "skipped", "failed")
        showStandardStreams = true
    }
}
