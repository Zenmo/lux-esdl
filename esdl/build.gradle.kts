
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

dependencies {
    implementation(project(":luxdeps"))

    implementation("nl.tno.esdl:esdl:2.26.3")
    implementation("org.eclipse.emf:org.eclipse.emf.common:2.45.0")
    implementation("org.eclipse.emf:org.eclipse.emf.ecore:2.42.0")
    implementation("org.eclipse.emf:org.eclipse.emf.ecore.xmi:2.40.0")

    implementation("org.slf4j:slf4j-api:2.0.13")
    implementation("ch.qos.logback:logback-classic:1.5.6")

    //testImplementation(platform("org.junit:junit-bom:6.0.3"))
    testImplementation("org.junit.jupiter:junit-jupiter:6.0.3")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}
