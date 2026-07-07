import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.w3c.dom.NodeList
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.xpath.XPathConstants
import javax.xml.xpath.XPathFactory

plugins {
    `java-library`
}

dependencies {
    // The dependencies have been found by inspecting the arguments of a running model
    // using `ps aux | grep -i <modelpackage>`
    addLuxDependencies()
    addAnyLogicDependencies()
}

fun DependencyHandlerScope.addLuxDependencies() {
    val alpxFiles = providers.gradlePropertiesPrefixedBy("luxAnyLogicAlpxFiles.")
        .map { properties ->
            properties.toSortedMap().values.toList()
        }
        .get()
        .map { file(it) }

    if (alpxFiles.size != 3) {
        error("Expected 3 paths to alpx files under gradle prefix 'luxAnyLogicAlpxFiles.*', found ${alpxFiles.size}")
    }

    val parsedAlpxFiles = alpxFiles.map { alpx ->
        DocumentBuilderFactory.newInstance()
            .newDocumentBuilder()
            .parse(alpx)
    }

    val xpath = XPathFactory.newInstance().newXPath()

    val jarFiles = parsedAlpxFiles.flatMapIndexed { i, alpxFile ->
        val jarNodes = xpath.evaluate(
            "//AnyLogicWorkspace/Model/ClassPathEntry/ResourceReference/ClassName/text()",
            alpxFile,
            XPathConstants.NODESET
        ) as NodeList

        val dependencyJarNames = (0 until jarNodes.length).map { i -> jarNodes.item(i).nodeValue }
        val dependencyJarFiles = dependencyJarNames.map { alpxFiles[i].parentFile.resolve(it) }

        return@flatMapIndexed dependencyJarFiles
    }

    jarFiles.forEach { jarFile ->
        implementation(files(jarFile))
    }
}

fun DependencyHandlerScope.addAnyLogicDependencies() {
    val pluginsDir = providers.gradleProperty("anyLogicPluginsDir").orNull
        ?: error("Missing 'anyLogicPluginsDir' Gradle property")

    // In AnyLogic 8.9.9 the Linux and Windows build numbers are the same
//    val osName = System.getProperty("os.name").lowercase()
//    val build = if (osName.contains("linux")) "202606170507" else "202606170507"

    var version = "8.9.9.202606170507"

    // this list was found by inspecting the arguments of a running moddel
    // with `ps x | grep -i <project>`
    listOf(
        "com.anylogic.core8_$version/com.anylogic.ms.jar",
        "com.anylogic.engine.database_$version/com.anylogic.engine.database.jar",
        "com.anylogic.engine.datautil_$version/com.anylogic.engine.datautil.jar",
        "com.anylogic.engine.editorapi_$version/com.anylogic.engine.editorapi.jar",
        "com.anylogic.engine.gis_$version/com.anylogic.engine.gis.jar",
        "com.anylogic.engine.sa_$version/com.anylogic.engine.sa.jar",
        "com.anylogic.engine.sa_$version/lib/al-spark-core-2.9.4-with-jetty-9.4.57.jar",
        "com.anylogic.engine.sa_$version/lib/jackson-annotations-2.16.2.jar",
        "com.anylogic.engine.sa_$version/lib/jackson-core-2.16.2.jar",
        "com.anylogic.engine.sa_$version/lib/jackson-databind-2.16.2.jar",
        "com.anylogic.engine.sa_$version/lib/javax.servlet-api-3.1.0.jar",
        "com.anylogic.engine.sa_$version/lib/jetty-client-9.4.57.v20241219.jar",
        "com.anylogic.engine.sa_$version/lib/jetty-continuation-9.4.57.v20241219.jar",
        "com.anylogic.engine.sa_$version/lib/jetty-http-9.4.57.v20241219.jar",
        "com.anylogic.engine.sa_$version/lib/jetty-io-9.4.57.v20241219.jar",
        "com.anylogic.engine.sa_$version/lib/jetty-security-9.4.57.v20241219.jar",
        "com.anylogic.engine.sa_$version/lib/jetty-server-9.4.57.v20241219.jar",
        "com.anylogic.engine.sa_$version/lib/jetty-servlet-9.4.57.v20241219.jar",
        "com.anylogic.engine.sa_$version/lib/jetty-servlets-9.4.57.v20241219.jar",
        "com.anylogic.engine.sa_$version/lib/jetty-util-9.4.57.v20241219.jar",
        "com.anylogic.engine.sa_$version/lib/jetty-util-ajax-9.4.57.v20241219.jar",
        "com.anylogic.engine.sa_$version/lib/jetty-webapp-9.4.57.v20241219.jar",
        "com.anylogic.engine.sa_$version/lib/jetty-xml-9.4.57.v20241219.jar",
        "com.anylogic.engine.sa_$version/lib/sa/com.anylogic.engine.sa.web.jar",
        "com.anylogic.engine.sa_$version/lib/sa/executor-basic-8.3.jar",
        "com.anylogic.engine.sa_$version/lib/sa/ioutil-8.3.jar",
        "com.anylogic.engine.sa_$version/lib/sa/util-8.3.jar",
        "com.anylogic.engine.sa_$version/lib/slf4j-api-1.7.25.jar",
        "com.anylogic.engine.sa_$version/lib/websocket-api-9.4.57.v20241219.jar",
        "com.anylogic.engine.sa_$version/lib/websocket-client-9.4.57.v20241219.jar",
        "com.anylogic.engine.sa_$version/lib/websocket-common-9.4.57.v20241219.jar",
        "com.anylogic.engine.sa_$version/lib/websocket-server-9.4.57.v20241219.jar",
        "com.anylogic.engine.sa_$version/lib/websocket-servlet-9.4.57.v20241219.jar",
        "com.anylogic.engine_$version/com.anylogic.engine.jar",
        "com.anylogic.libraries.modules_$version/lib/MarkupDescriptors/MarkupDescriptors.jar",
        "com.anylogic.optimizer_$version/lib/OptQuest.jar",
        "com.anylogic.optimizer_$version/lib/jmetal_5.10_d76b1367d1640b9ebf1a2f6958e952573f12183a.jar",
        "com.anylogic.third_party_libraries_$version/lib/GeographicLib-Java-1.49.jar",
        "com.anylogic.third_party_libraries_$version/lib/SparseBitSet-1.3.jar",
        "com.anylogic.third_party_libraries_$version/lib/ac2shp-202009171739.jar",
        "com.anylogic.third_party_libraries_$version/lib/al-ecj-4.27.jar",
        "com.anylogic.third_party_libraries_$version/lib/al-profiler-converter-3.0-ea-53b8a8ad.jar",
        "com.anylogic.third_party_libraries_$version/lib/al-sqlsheet-7.2-2c2d836_poi_5.4.1.jar",
        "com.anylogic.third_party_libraries_$version/lib/al-ucanaccess-5.0.1.jar",
        "com.anylogic.third_party_libraries_$version/lib/annotations-13.0.jar",
        "com.anylogic.third_party_libraries_$version/lib/apiguardian-api-1.1.2.jar",
        "com.anylogic.third_party_libraries_$version/lib/bcprov-jdk18on-1.83.jar",
        "com.anylogic.third_party_libraries_$version/lib/classgraph-4.8.146.jar",
        "com.anylogic.third_party_libraries_$version/lib/codegen-utils-5.1.0.jar",
        "com.anylogic.third_party_libraries_$version/lib/commons-codec-1.16.0.jar",
        "com.anylogic.third_party_libraries_$version/lib/commons-collections4-4.4.jar",
        "com.anylogic.third_party_libraries_$version/lib/commons-compress-1.27.1.jar",
        "com.anylogic.third_party_libraries_$version/lib/commons-io-2.18.0.jar",
        "com.anylogic.third_party_libraries_$version/lib/commons-lang3-3.20.0.jar",
        "com.anylogic.third_party_libraries_$version/lib/commons-math3-3.6.1.jar",
        "com.anylogic.third_party_libraries_$version/lib/commons-pool-1.5.4.jar",
        "com.anylogic.third_party_libraries_$version/lib/commons-text-1.12.0.jar",
        "com.anylogic.third_party_libraries_$version/lib/crypt-codec-opener-1.0.1.jar",
        "com.anylogic.third_party_libraries_$version/lib/curvesapi-1.08.jar",
        "com.anylogic.third_party_libraries_$version/lib/ejml-core-0.33.jar",
        "com.anylogic.third_party_libraries_$version/lib/ejml-ddense-0.33.jar",
        "com.anylogic.third_party_libraries_$version/lib/glob-0.9.0.jar",
        "com.anylogic.third_party_libraries_$version/lib/graphhopper-al-0.10.1-without-commons-io-jackson-annotations.jar",
        "com.anylogic.third_party_libraries_$version/lib/gt-api-32.2.jar",
        "com.anylogic.third_party_libraries_$version/lib/gt-epsg-hsql-32.2.jar",
        "com.anylogic.third_party_libraries_$version/lib/gt-http-32.2.jar",
        "com.anylogic.third_party_libraries_$version/lib/gt-main-32.2.jar",
        "com.anylogic.third_party_libraries_$version/lib/gt-metadata-32.2.jar",
        "com.anylogic.third_party_libraries_$version/lib/gt-referencing-32.2.jar",
        "com.anylogic.third_party_libraries_$version/lib/gt-shapefile-32.2.jar",
        "com.anylogic.third_party_libraries_$version/lib/hsqldb-2.7.1.jar",
        "com.anylogic.third_party_libraries_$version/lib/indriya-2.2.jar",
        "com.anylogic.third_party_libraries_$version/lib/jackcess-4.0.2.jar",
        "com.anylogic.third_party_libraries_$version/lib/jackcess-encrypt-4.0.2.jar",
        "com.anylogic.third_party_libraries_$version/lib/jackson-annotations-2.16.2.jar",
        "com.anylogic.third_party_libraries_$version/lib/jackson-core-2.16.2.jar",
        "com.anylogic.third_party_libraries_$version/lib/jackson-databind-2.16.2.jar",
        "com.anylogic.third_party_libraries_$version/lib/jai_core-1.1.3.jar",
        "com.anylogic.third_party_libraries_$version/lib/jakarta.activation-1.2.2.jar",
        "com.anylogic.third_party_libraries_$version/lib/jakarta.annotation-api-1.3.4.jar",
        "com.anylogic.third_party_libraries_$version/lib/jakarta.inject-api-2.0.1.jar",
        "com.anylogic.third_party_libraries_$version/lib/jakarta.xml.bind-api-2.3.3.jar",
        "com.anylogic.third_party_libraries_$version/lib/javax.annotation-api-1.3.2.jar",
        "com.anylogic.third_party_libraries_$version/lib/javax.inject-1.jar",
        "com.anylogic.third_party_libraries_$version/lib/jaxb-api-2.3.0.jar",
        "com.anylogic.third_party_libraries_$version/lib/jaxb-impl-2.3.8.jar",
        "com.anylogic.third_party_libraries_$version/lib/jcl-over-slf4j-1.7.25.jar",
        "com.anylogic.third_party_libraries_$version/lib/jgltf-impl-v1-2.0.4.jar",
        "com.anylogic.third_party_libraries_$version/lib/jgltf-impl-v2-2.0.4.jar",
        "com.anylogic.third_party_libraries_$version/lib/jgltf-model-2.0.4.jar",
        "com.anylogic.third_party_libraries_$version/lib/jgridshift-core-1.3.jar",
        "com.anylogic.third_party_libraries_$version/lib/joml-1.10.6.jar",
        "com.anylogic.third_party_libraries_$version/lib/json-simple-1.1.1.jar",
        "com.anylogic.third_party_libraries_$version/lib/jsqlparser-4.6.jar",
        "com.anylogic.third_party_libraries_$version/lib/jsr-275-1.0-beta-2.jar",
        "com.anylogic.third_party_libraries_$version/lib/jtds-1.3.1.jar",
        "com.anylogic.third_party_libraries_$version/lib/jts-core-1.20.0.jar",
        "com.anylogic.third_party_libraries_$version/lib/jul-to-slf4j-1.7.25.jar",
        "com.anylogic.third_party_libraries_$version/lib/kotlin-stdlib-1.8.20.jar",
        "com.anylogic.third_party_libraries_$version/lib/kotlin-stdlib-common-1.8.20.jar",
        "com.anylogic.third_party_libraries_$version/lib/kotlin-stdlib-jdk7-1.8.20.jar",
        "com.anylogic.third_party_libraries_$version/lib/kotlin-stdlib-jdk8-1.8.20.jar",
        "com.anylogic.third_party_libraries_$version/lib/log4j-api-2.26.0.jar",
        "com.anylogic.third_party_libraries_$version/lib/log4j-core-2.26.0.jar",
        "com.anylogic.third_party_libraries_$version/lib/log4j-over-slf4j-1.7.25.jar",
        "com.anylogic.third_party_libraries_$version/lib/mapdb-1.0.9-al-6088d6f1.jar",
        "com.anylogic.third_party_libraries_$version/lib/mariadb-java-client-3.2.0.jar",
        "com.anylogic.third_party_libraries_$version/lib/mssql-jdbc-13.2.1.jre11.jar",
        "com.anylogic.third_party_libraries_$version/lib/mysema-commons-lang-0.2.4.jar",
        "com.anylogic.third_party_libraries_$version/lib/net.opengis.ows-32.2.jar",
        "com.anylogic.third_party_libraries_$version/lib/obj-0.4.0.jar",
        "com.anylogic.third_party_libraries_$version/lib/ojdbc11-23.2.0.0.jar",
        "com.anylogic.third_party_libraries_$version/lib/openmap-5.1.15.jar",
        "com.anylogic.third_party_libraries_$version/lib/org.eclipse.emf.common-2.15.0.jar",
        "com.anylogic.third_party_libraries_$version/lib/org.eclipse.emf.ecore-2.15.0.jar",
        "com.anylogic.third_party_libraries_$version/lib/org.eclipse.emf.ecore.xmi-2.15.0.jar",
        "com.anylogic.third_party_libraries_$version/lib/org.w3.xlink-32.2.jar",
        "com.anylogic.third_party_libraries_$version/lib/poi-5.4.1.jar",
        "com.anylogic.third_party_libraries_$version/lib/poi-examples-5.4.1.jar",
        "com.anylogic.third_party_libraries_$version/lib/poi-excelant-5.4.1.jar",
        "com.anylogic.third_party_libraries_$version/lib/poi-ooxml-5.4.1.jar",
        "com.anylogic.third_party_libraries_$version/lib/poi-ooxml-lite-5.4.1.jar",
        "com.anylogic.third_party_libraries_$version/lib/poi-scratchpad-5.4.1.jar",
        "com.anylogic.third_party_libraries_$version/lib/postgresql-42.6.0.jar",
        "com.anylogic.third_party_libraries_$version/lib/querydsl-codegen-5.1.0.jar",
        "com.anylogic.third_party_libraries_$version/lib/querydsl-core-5.1.0.jar",
        "com.anylogic.third_party_libraries_$version/lib/querydsl-sql-5.1.0.jar",
        "com.anylogic.third_party_libraries_$version/lib/querydsl-sql-codegen-5.1.0.jar",
        "com.anylogic.third_party_libraries_$version/lib/re2j-1.6.jar",
        "com.anylogic.third_party_libraries_$version/lib/si-quantity-2.1.jar",
        "com.anylogic.third_party_libraries_$version/lib/si-units-2.1.jar",
        "com.anylogic.third_party_libraries_$version/lib/slf4j-api-1.7.25.jar",
        "com.anylogic.third_party_libraries_$version/lib/systems-common-2.1.jar",
        "com.anylogic.third_party_libraries_$version/lib/unit-api-2.2.jar",
        "com.anylogic.third_party_libraries_$version/lib/uom-lib-common-2.2.jar",
        "com.anylogic.third_party_libraries_$version/lib/xmlbeans-5.3.0.jar",
    ).forEach { path ->
        implementation(files("$pluginsDir/$path"))
    }
}
