package org.fabric3.samples.bigbank.client.ws.loan;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for address complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="address">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="city" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="state" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="street" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="zip" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "address", propOrder = {
        "city",
        "state",
        "street",
        "zip"
})
public class Address {

    protected String city;
    protected String state;
    protected String street;
    protected int zip;

    /**
     * Gets the value of the city property.
     *
     * @return possible object is {@link String }
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the value of the city property.
     *
     * @param value allowed object is {@link String }
     */
    public void setCity(String value) {
        this.city = value;
    }

    /**
     * Gets the value of the state property.
     *
     * @return possible object is {@link String }
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the value of the state property.
     *
     * @param value allowed object is {@link String }
     */
    public void setState(String value) {
        this.state = value;
    }

    /**
     * Gets the value of the street property.
     *
     * @return possible object is {@link String }
     */
    public String getStreet() {
        return street;
    }

    /**
     * Sets the value of the street property.
     *
     * @param value allowed object is {@link String }
     */
    public void setStreet(String value) {
        this.street = value;
    }

    /**
     * Gets the value of the zip property.
     */
    public int getZip() {
        return zip;
    }

    /**
     * Sets the value of the zip property.
     */
    public void setZip(int value) {
        this.zip = value;
    }

}
