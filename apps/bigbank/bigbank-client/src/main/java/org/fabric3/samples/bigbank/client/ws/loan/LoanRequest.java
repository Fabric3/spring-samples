package org.fabric3.samples.bigbank.client.ws.loan;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for loanRequest complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="loanRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="downPayment" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="propertyAddress" type="{http://loan.api.bigbank.samples.fabric3.org/}address" minOccurs="0"/>
 *         &lt;element name="SSN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "loanRequest", propOrder = {
        "amount",
        "downPayment",
        "email",
        "propertyAddress",
        "ssn"
})
public class LoanRequest {

    protected double amount;
    protected double downPayment;
    protected String email;
    protected Address propertyAddress;
    @XmlElement(name = "SSN")
    protected String ssn;

    /**
     * Gets the value of the amount property.
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     */
    public void setAmount(double value) {
        this.amount = value;
    }

    /**
     * Gets the value of the downPayment property.
     */
    public double getDownPayment() {
        return downPayment;
    }

    /**
     * Sets the value of the downPayment property.
     */
    public void setDownPayment(double value) {
        this.downPayment = value;
    }

    /**
     * Gets the value of the email property.
     *
     * @return possible object is {@link String }
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     *
     * @param value allowed object is {@link String }
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Gets the value of the propertyAddress property.
     *
     * @return possible object is {@link Address }
     */
    public Address getPropertyAddress() {
        return propertyAddress;
    }

    /**
     * Sets the value of the propertyAddress property.
     *
     * @param value allowed object is {@link Address }
     */
    public void setPropertyAddress(Address value) {
        this.propertyAddress = value;
    }

    /**
     * Gets the value of the ssn property.
     *
     * @return possible object is {@link String }
     */
    public String getSSN() {
        return ssn;
    }

    /**
     * Sets the value of the ssn property.
     *
     * @param value allowed object is {@link String }
     */
    public void setSSN(String value) {
        this.ssn = value;
    }

}
