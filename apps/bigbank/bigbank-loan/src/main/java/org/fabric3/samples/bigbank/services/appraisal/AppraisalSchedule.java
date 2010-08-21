package org.fabric3.samples.bigbank.services.appraisal;

import java.io.Serializable;
import java.util.Date;

/**
 * @version $Revision$ $Date$
 */
public class AppraisalSchedule implements Serializable {
    private static final long serialVersionUID = -1913119919081097742L;
    private long id;
    private Date date;

    public AppraisalSchedule() {
    }

    public AppraisalSchedule(long id, Date date) {
        this.id = id;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }
}
