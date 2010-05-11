package org.fabric3.samples.bigbank.services.pricing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @version $Revision$ $Date$
 */
public class PriceResponse implements Serializable {
    private static final long serialVersionUID = 3009581081316393018L;

    private List<PricingOption> options = new ArrayList<PricingOption>();
    private long id;

    public PriceResponse(long id) {
        this.id = id;
    }

    public List<PricingOption> getOptions() {
        return options;
    }

    public void addOption(PricingOption option) {
        options.add(option);
    }

    public long getId() {
        return id;
    }
}
