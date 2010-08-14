package org.fabric3.samples.bigbank.client.ws.loan;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for loanApplication complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="loanApplication">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="options" type="{http://loan.api.bigbank.samples.fabric3.org/}loanOption" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "loanApplication", propOrder = {
        "options",
        "status"
})
public class LoanApplication {

    @XmlElement(nillable = true)
    protected List<LoanOption> options;
    protected int status;

    /**
     * Gets the value of the options property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the returned list will be
     * present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for the options property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOptions().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list {@link LoanOption }
     */
    public List<LoanOption> getOptions() {
        if (options == null) {
            options = new ArrayList<LoanOption>();
        }
        return this.options;
    }

    /**
     * Gets the value of the status property.
     */
    public int getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     */
    public void setStatus(int value) {
        this.status = value;
    }

}
