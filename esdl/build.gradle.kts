
plugins {
    `java-library`
    application
    id("anylogic-dependencies")
}

version = "dev"

application {
    mainClass.set("energy.lux.esdl.Main")
}

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

dependencies {
    implementation(project(":luxdeps"))

    implementation("nl.tno.esdl:esdl:2.26.3")
    implementation("org.eclipse.emf:org.eclipse.emf.common:2.45.0")
    implementation("org.eclipse.emf:org.eclipse.emf.ecore:2.42.0")
    implementation("org.eclipse.emf:org.eclipse.emf.ecore.xmi:2.40.0")

    testImplementation(platform("org.junit:junit-bom:6.0.3"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.junit.platform:junit-platform-launcher")
}
