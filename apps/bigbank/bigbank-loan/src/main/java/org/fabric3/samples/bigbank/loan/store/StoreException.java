package org.fabric3.samples.bigbank.loan.store;

/**
 * @version $Revision$ $Date$
 */
public class StoreException extends Exception {
    private static final long serialVersionUID = 5946877131537880818L;

    public StoreException(Throwable cause) {
        super(cause);
    }

    public StoreException(String message, Throwable cause) {
        super(message, cause);
    }

    public StoreException(String message) {
        super(message);
    }
}
