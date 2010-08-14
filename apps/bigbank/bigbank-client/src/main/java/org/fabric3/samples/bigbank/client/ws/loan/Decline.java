package org.fabric3.samples.bigbank.client.ws.loan;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for decline complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="decline">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arg0" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "decline", propOrder = {
        "arg0"
})
public class Decline {

    protected long arg0;

    /**
     * Gets the value of the arg0 property.
     */
    public long getArg0() {
        return arg0;
    }

    /**
     * Sets the value of the arg0 property.
     */
    public void setArg0(long value) {
        this.arg0 = value;
    }

}
