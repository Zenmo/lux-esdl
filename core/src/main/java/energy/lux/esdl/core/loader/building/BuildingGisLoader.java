package energy.lux.esdl.core.loader.building;

import esdl.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zero_engine.GridConnection;
import zero_engine.OL_GISObjectType;
import zerointerfaceloader.Zero_Loader;

import java.util.Optional;

public class BuildingGisLoader {
    private static final Logger logger = LoggerFactory.getLogger(BuildingGisLoader.class);

    private static final double METERS_TO_DEGREES = 0.00001;

    public static void loadGis(AbstractBuilding building, Zero_Loader luxLoader, GridConnection luxGridConnection) {
        var geometry = building.getGeometry();
        if (geometry == null) {
            return;
        }

        var optPolygon = geometryToPolygon(geometry);
        if (optPolygon.isEmpty()) {
            return;
        }
        var polygon = optPolygon.get();

        var gisBuilding = luxLoader.energyModel.add_pop_GIS_Buildings();
        gisBuilding.p_id = building.getId();

        var firstPoint = polygon.getPoint().get(0);
        gisBuilding.p_longitude = firstPoint.getLon();
        gisBuilding.p_latitude = firstPoint.getLat();
        gisBuilding.gisRegion = luxLoader.zero_Interface.f_createGISObject(toLatLonPairs(polygon));
        gisBuilding.p_GISObjectType = OL_GISObjectType.BUILDING;

        gisBuilding.c_containedGridConnections.add(luxGridConnection);
        luxGridConnection.c_connectedGISObjects.add(gisBuilding);
    }

    private static Optional<SubPolygon> geometryToPolygon(Geometry geometry) {
        if (geometry instanceof Point point) {
            return Optional.of(pointTo8x8Polygon(point));
        } else if (geometry instanceof Polygon polygon) {
            return polygon.getInterior().stream().findFirst();
        }

        logger.warn("Not implement building geometry {}", geometry.eClass().getInstanceClassName());
        return Optional.empty();
    }

    /**
     * Create a roughly 8m x 8m square to represent a house
     */
    private static SubPolygon pointTo8x8Polygon(Point point) {
        var esdlFactory = EsdlFactory.eINSTANCE;

        var subPolygon = esdlFactory.createSubPolygon();

        double halfSide = 4.0 * METERS_TO_DEGREES;
        double centerLon = point.getLon();
        double centerLat = point.getLat();

        // Create 4 corners of the square (clockwise from bottom-left)
        var point1 = esdlFactory.createPoint();
        point1.setLon(centerLon - halfSide);
        point1.setLat(centerLat - halfSide);

        var point2 = esdlFactory.createPoint();
        point2.setLon(centerLon + halfSide);
        point2.setLat(centerLat - halfSide);

        var point3 = esdlFactory.createPoint();
        point3.setLon(centerLon + halfSide);
        point3.setLat(centerLat + halfSide);

        var point4 = esdlFactory.createPoint();
        point4.setLon(centerLon - halfSide);
        point4.setLat(centerLat + halfSide);

        subPolygon.getPoint().add(point1);
        subPolygon.getPoint().add(point2);
        subPolygon.getPoint().add(point3);
        subPolygon.getPoint().add(point4);

        return subPolygon;
    }

    /**
     * Convert polygon to the format needed to construct {@link com.anylogic.engine.markup.GISRegion}
     */
    private static double[] toLatLonPairs(SubPolygon polygon) {
        var points = polygon.getPoint();
        var latLonPairs = new double[points.size() * 2];

        for (int i = 0; i < points.size(); i++) {
            var point = points.get(i);
            latLonPairs[i * 2] = point.getLat();
            latLonPairs[i * 2 + 1] = point.getLon();
        }

        return latLonPairs;
    }
}
