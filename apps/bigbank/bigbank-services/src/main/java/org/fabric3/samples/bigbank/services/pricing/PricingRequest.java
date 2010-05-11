package org.fabric3.samples.bigbank.services.pricing;

import java.io.Serializable;

/**
 * @version $Revision$ $Date$
 */
public class PricingRequest implements Serializable {
    private static final long serialVersionUID = 7816498055824352406L;
    private long id;
    private int riskFactor;

    public PricingRequest(long id, int riskFactor) {
        this.id = id;
        this.riskFactor = riskFactor;
    }

    public long getId() {
        return id;
    }

    public int getRiskFactor() {
        return riskFactor;
    }
}
