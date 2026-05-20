package energy.lux.esdl;

import esdl.EnergySystem;
import esdl.EsdlPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

import java.io.IOException;
import java.net.URL;

/**
 * Read ESDL XML to an object.
 */
public class ESDLReader {
    static {
        EsdlPackage.eINSTANCE.eClass();
    }

    public static EnergySystem readResource(URL javaUrl) {
        var eclipseUri = URI.createURI(javaUrl.toString());

        XMIResource resource = new XMIResourceImpl(eclipseUri);
        try {
            resource.load(null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return (EnergySystem) resource.getContents().get(0);
    }
}
