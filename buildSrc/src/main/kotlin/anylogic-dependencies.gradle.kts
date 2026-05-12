
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
    val anylogicProjectAlpxs = listOf(
        "/home/erik/zenmo/ANYLOGIC/zero_engine/Zero_engine.alpx",
        "/home/erik/zenmo/ANYLOGIC/zero_Interface-Loader/Zero_Interface-Loader.alpx",
        "/home/erik/zenmo/ANYLOGIC/zero_results_UI/results_UI.alpx",
    ).map { file(it) }

    val parsedAlpxFiles = anylogicProjectAlpxs.map { alpx ->
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
        val dependencyJarFiles = dependencyJarNames.map { anylogicProjectAlpxs[i].parentFile.resolve(it) }

        return@flatMapIndexed dependencyJarFiles
    }

    jarFiles.forEach { jarFile ->
        implementation(files(jarFile))
    }
}

fun DependencyHandlerScope.addAnyLogicDependencies() {
    listOf(
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.core8_8.9.7.202512121151/com.anylogic.ms.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.engine.database_8.9.7.202512121151/com.anylogic.engine.database.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.engine.datautil_8.9.7.202512121151/com.anylogic.engine.datautil.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.engine.editorapi_8.9.7.202512121151/com.anylogic.engine.editorapi.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.engine.gis_8.9.7.202512121151/com.anylogic.engine.gis.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.engine.sa_8.9.7.202512121151/com.anylogic.engine.sa.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.engine.sa_8.9.7.202512121151/lib/al-spark-core-2.9.4-with-jetty-9.4.57.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.engine.sa_8.9.7.202512121151/lib/jackson-annotations-2.16.2.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.engine.sa_8.9.7.202512121151/lib/jackson-core-2.16.2.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.engine.sa_8.9.7.202512121151/lib/jackson-databind-2.16.2.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.engine.sa_8.9.7.202512121151/lib/javax.servlet-api-3.1.0.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.engine.sa_8.9.7.202512121151/lib/jetty-client-9.4.57.v20241219.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.engine.sa_8.9.7.202512121151/lib/jetty-continuation-9.4.57.v20241219.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.engine.sa_8.9.7.202512121151/lib/jetty-http-9.4.57.v20241219.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.engine.sa_8.9.7.202512121151/lib/jetty-io-9.4.57.v20241219.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.engine.sa_8.9.7.202512121151/lib/jetty-security-9.4.57.v20241219.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.engine.sa_8.9.7.202512121151/lib/jetty-server-9.4.57.v20241219.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.engine.sa_8.9.7.202512121151/lib/jetty-servlet-9.4.57.v20241219.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.engine.sa_8.9.7.202512121151/lib/jetty-servlets-9.4.57.v20241219.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.engine.sa_8.9.7.202512121151/lib/jetty-util-9.4.57.v20241219.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.engine.sa_8.9.7.202512121151/lib/jetty-util-ajax-9.4.57.v20241219.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.engine.sa_8.9.7.202512121151/lib/jetty-webapp-9.4.57.v20241219.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.engine.sa_8.9.7.202512121151/lib/jetty-xml-9.4.57.v20241219.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.engine.sa_8.9.7.202512121151/lib/sa/com.anylogic.engine.sa.web.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.engine.sa_8.9.7.202512121151/lib/sa/executor-basic-8.3.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.engine.sa_8.9.7.202512121151/lib/sa/ioutil-8.3.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.engine.sa_8.9.7.202512121151/lib/sa/util-8.3.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.engine.sa_8.9.7.202512121151/lib/slf4j-api-1.7.25.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.engine.sa_8.9.7.202512121151/lib/websocket-api-9.4.57.v20241219.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.engine.sa_8.9.7.202512121151/lib/websocket-client-9.4.57.v20241219.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.engine.sa_8.9.7.202512121151/lib/websocket-common-9.4.57.v20241219.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.engine.sa_8.9.7.202512121151/lib/websocket-server-9.4.57.v20241219.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.engine.sa_8.9.7.202512121151/lib/websocket-servlet-9.4.57.v20241219.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.engine_8.9.7.202512121151/com.anylogic.engine.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.libraries.modules_8.9.7.202512121151/lib/MarkupDescriptors/MarkupDescriptors.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.optimizer_8.9.7.202512121151/lib/OptQuest.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.optimizer_8.9.7.202512121151/lib/jmetal_5.10_d76b1367d1640b9ebf1a2f6958e952573f12183a.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.process_modeling_library_8.9.7.202512121151/lib/ProcessModelingLibrary.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.third_party_libraries_8.9.7.202512121151/lib/GeographicLib-Java-1.49.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.third_party_libraries_8.9.7.202512121151/lib/al-ecj-4.27.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.third_party_libraries_8.9.7.202512121151/lib/apiguardian-api-1.1.2.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.third_party_libraries_8.9.7.202512121151/lib/commons-codec-1.16.0.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.third_party_libraries_8.9.7.202512121151/lib/commons-collections4-4.4.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.third_party_libraries_8.9.7.202512121151/lib/commons-compress-1.27.1.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.third_party_libraries_8.9.7.202512121151/lib/commons-io-2.18.0.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.third_party_libraries_8.9.7.202512121151/lib/commons-lang3-3.10.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.third_party_libraries_8.9.7.202512121151/lib/commons-math3-3.6.1.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.third_party_libraries_8.9.7.202512121151/lib/commons-pool-1.5.4.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.third_party_libraries_8.9.7.202512121151/lib/commons-text-1.12.0.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.third_party_libraries_8.9.7.202512121151/lib/ejml-core-0.33.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.third_party_libraries_8.9.7.202512121151/lib/ejml-ddense-0.33.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.third_party_libraries_8.9.7.202512121151/lib/graphhopper-al-0.10.1-without-commons-io-jackson-annotations.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.third_party_libraries_8.9.7.202512121151/lib/gt-api-32.2.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.third_party_libraries_8.9.7.202512121151/lib/gt-epsg-hsql-32.2.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.third_party_libraries_8.9.7.202512121151/lib/gt-http-32.2.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.third_party_libraries_8.9.7.202512121151/lib/gt-main-32.2.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.third_party_libraries_8.9.7.202512121151/lib/gt-metadata-32.2.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.third_party_libraries_8.9.7.202512121151/lib/gt-referencing-32.2.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.third_party_libraries_8.9.7.202512121151/lib/gt-shapefile-32.2.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.third_party_libraries_8.9.7.202512121151/lib/indriya-2.2.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.third_party_libraries_8.9.7.202512121151/lib/jai_core-1.1.3.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.third_party_libraries_8.9.7.202512121151/lib/jakarta.annotation-api-1.3.4.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.third_party_libraries_8.9.7.202512121151/lib/jakarta.inject-api-2.0.1.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.third_party_libraries_8.9.7.202512121151/lib/jgridshift-core-1.3.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.third_party_libraries_8.9.7.202512121151/lib/joml-1.10.6.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.third_party_libraries_8.9.7.202512121151/lib/json-simple-1.1.1.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.third_party_libraries_8.9.7.202512121151/lib/jsr-275-1.0-beta-2.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.third_party_libraries_8.9.7.202512121151/lib/jts-core-1.20.0.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.third_party_libraries_8.9.7.202512121151/lib/log4j-api-2.24.3.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.third_party_libraries_8.9.7.202512121151/lib/log4j-core-2.24.3.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.third_party_libraries_8.9.7.202512121151/lib/mapdb-1.0.9-al-6088d6f1.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.third_party_libraries_8.9.7.202512121151/lib/net.opengis.ows-32.2.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.third_party_libraries_8.9.7.202512121151/lib/openmap-5.1.15.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.third_party_libraries_8.9.7.202512121151/lib/org.eclipse.emf.common-2.15.0.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.third_party_libraries_8.9.7.202512121151/lib/org.eclipse.emf.ecore-2.15.0.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.third_party_libraries_8.9.7.202512121151/lib/org.eclipse.emf.ecore.xmi-2.15.0.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.third_party_libraries_8.9.7.202512121151/lib/org.w3.xlink-32.2.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.third_party_libraries_8.9.7.202512121151/lib/poi-5.4.1.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.third_party_libraries_8.9.7.202512121151/lib/poi-examples-5.4.1.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.third_party_libraries_8.9.7.202512121151/lib/poi-excelant-5.4.1.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.third_party_libraries_8.9.7.202512121151/lib/poi-ooxml-5.4.1.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.third_party_libraries_8.9.7.202512121151/lib/poi-ooxml-lite-5.4.1.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.third_party_libraries_8.9.7.202512121151/lib/poi-scratchpad-5.4.1.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.third_party_libraries_8.9.7.202512121151/lib/querydsl-core-5.1.0.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.third_party_libraries_8.9.7.202512121151/lib/querydsl-sql-5.1.0.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.third_party_libraries_8.9.7.202512121151/lib/querydsl-sql-codegen-5.1.0.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.third_party_libraries_8.9.7.202512121151/lib/re2j-1.6.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.third_party_libraries_8.9.7.202512121151/lib/si-quantity-2.1.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.third_party_libraries_8.9.7.202512121151/lib/si-units-2.1.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.third_party_libraries_8.9.7.202512121151/lib/systems-common-2.1.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.third_party_libraries_8.9.7.202512121151/lib/unit-api-2.2.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.third_party_libraries_8.9.7.202512121151/lib/uom-lib-common-2.2.jar",
        "/home/erik/anylogic/8.9.7/plugins/com.anylogic.third_party_libraries_8.9.7.202512121151/lib/xmlbeans-5.3.0.jar",
    ).forEach { path ->
        implementation(files(path))
    }
}
