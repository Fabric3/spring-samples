package org.fabric3.samples.bigbank.services.appraisal;

import java.io.Serializable;

/**
 * @version $Revision$ $Date$
 */
public class AppraisalResult implements Serializable {
    private static final long serialVersionUID = 1094048646709453908L;
    public static int APPROVED = 1;
    public static int DECLINED = -1;
    private long id;
    private int result;
    private String[] comments;

    public AppraisalResult() {
    }

    public AppraisalResult(long id, int result, String[] comments) {
        this.id = id;
        this.result = result;
        this.comments = comments;
    }

    public long getId() {
        return id;
    }

    public int getResult() {
        return result;
    }

    public String[] getComments() {
        return comments;
    }

}
