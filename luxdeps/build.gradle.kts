
plugins {
    `java-library`
    id("anylogic-dependencies")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("org.projectlombok:lombok:1.18.34")
    annotationProcessor("org.projectlombok:lombok:1.18.34")
}

/**
 * Where AnyLogic puts the Java it generates for the three models that luxdeps is built from.
 * Set anyLogicWorkspaceDir in gradle.properties when the workspace is not in the default place.
 */
val anyLogicWorkspaceDir = providers.gradleProperty("anyLogicWorkspaceDir")
    .orElse(providers.systemProperty("user.home").map { "$it/.AnyLogicPLE/Workspace8.8" })

val generatedSourceModels = listOf(
    "Zero_engine_BUILD",
    "Zero_Interface-Loader_BUILD",
    "results_UI_BUILD",
)

/**
 * Does what copy-generated-java.sh does, without needing rsync, so that it also runs on Windows
 * and from the IDE. The shell script stays as it is for anyone who prefers it.
 * <p>
 * Like the script, this only adds and overwrites. It never deletes, because a generated file
 * that AnyLogic no longer produces is not necessarily one that luxdeps no longer needs.
 */
tasks.register<Copy>("copyGeneratedJava") {
    group = "build"
    description = "Copy the Java that AnyLogic generated into luxdeps/src/main/java."

    val sourceDirectories = generatedSourceModels.map { model ->
        "${anyLogicWorkspaceDir.get()}/$model/src.generated"
    }

    sourceDirectories.forEach { sourceDirectory ->
        from(sourceDirectory) {
            include("**/*.java")
        }
    }

    into(layout.projectDirectory.dir("src/main/java"))

    // The three models generate into separate packages, so nothing collides today. If that ever
    // changes, take the last one, which is what rsync would have done.
    duplicatesStrategy = DuplicatesStrategy.INCLUDE

    // A missing workspace would otherwise copy nothing at all and report success.
    doFirst {
        sourceDirectories.forEach { sourceDirectory ->
            if (!File(sourceDirectory).isDirectory) {
                throw GradleException(
                    "No AnyLogic generated sources at $sourceDirectory."
                            + " Build the models in AnyLogic first,"
                            + " or set anyLogicWorkspaceDir in gradle.properties."
                )
            }
        }
    }
}
