package energy.lux.esdl.core;

public class EsdlException extends RuntimeException {
    public EsdlException(String message) {
        super(message);
    }

    public EsdlException(String message, Throwable cause) {
        super(message, cause);
    }
}
