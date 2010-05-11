package org.fabric3.samples.bigbank.loan.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @version $Revision$ $Date$
 */
@Entity
public class RiskReasonInfo implements Serializable {
    private static final long serialVersionUID = -1781028701570454727L;
    private long id;
    private long version;
    private String description;

    public RiskReasonInfo() {
    }

    public RiskReasonInfo(String description) {
        this.description = description;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Version
    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}