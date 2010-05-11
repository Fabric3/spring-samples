
package org.fabric3.samples.bigbank.client.ws.loan;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for loanOption complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="loanOption">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="apr" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="rate" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "loanOption", propOrder = {
    "apr",
    "rate",
    "type"
})
public class LoanOption {

    protected float apr;
    protected float rate;
    protected String type;

    /**
     * Gets the value of the apr property.
     * 
     */
    public float getApr() {
        return apr;
    }

    /**
     * Sets the value of the apr property.
     * 
     */
    public void setApr(float value) {
        this.apr = value;
    }

    /**
     * Gets the value of the rate property.
     * 
     */
    public float getRate() {
        return rate;
    }

    /**
     * Sets the value of the rate property.
     * 
     */
    public void setRate(float value) {
        this.rate = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

}
