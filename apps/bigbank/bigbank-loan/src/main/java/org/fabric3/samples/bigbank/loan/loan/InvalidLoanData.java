package org.fabric3.samples.bigbank.loan.loan;

import org.fabric3.samples.bigbank.api.loan.LoanException;

/**
 * @version $Revision$ $Date$
 */
public class InvalidLoanData extends LoanException {
    private static final long serialVersionUID = -8593489214510658391L;

    public InvalidLoanData(String message) {
        super(message);
    }
}
