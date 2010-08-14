package org.fabric3.samples.bigbank.client.ws.loan;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each Java content interface and Java element interface generated in the
 * org.fabric3.samples.bigbank.client.ws.loan package. <p>An ObjectFactory allows you to programatically construct new instances of the Java
 * representation for XML content. The Java representation of XML content can consist of schema derived interfaces and classes representing the
 * binding of schema type definitions, element declarations and model groups.  Factory methods for each of these are provided in this class.
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AcceptResponse_QNAME = new QName("http://loan.api.bigbank.samples.fabric3.org/", "acceptResponse");
    private final static QName _LoanApplication_QNAME = new QName("http://loan.api.bigbank.samples.fabric3.org/", "loanApplication");
    private final static QName _RetrieveResponse_QNAME = new QName("http://loan.api.bigbank.samples.fabric3.org/", "retrieveResponse");
    private final static QName _DeclineResponse_QNAME = new QName("http://loan.api.bigbank.samples.fabric3.org/", "declineResponse");
    private final static QName _Decline_QNAME = new QName("http://loan.api.bigbank.samples.fabric3.org/", "decline");
    private final static QName _LoanRequest_QNAME = new QName("http://loan.api.bigbank.samples.fabric3.org/", "loanRequest");
    private final static QName _Accept_QNAME = new QName("http://loan.api.bigbank.samples.fabric3.org/", "accept");
    private final static QName _ApplyResponse_QNAME = new QName("http://loan.api.bigbank.samples.fabric3.org/", "applyResponse");
    private final static QName _Retrieve_QNAME = new QName("http://loan.api.bigbank.samples.fabric3.org/", "retrieve");
    private final static QName _Apply_QNAME = new QName("http://loan.api.bigbank.samples.fabric3.org/", "apply");
    private final static QName _OptionSelection_QNAME = new QName("http://loan.api.bigbank.samples.fabric3.org/", "optionSelection");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package:
     * org.fabric3.samples.bigbank.client.ws.loan
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Decline }
     */
    public Decline createDecline() {
        return new Decline();
    }

    /**
     * Create an instance of {@link ApplyResponse }
     */
    public ApplyResponse createApplyResponse() {
        return new ApplyResponse();
    }

    /**
     * Create an instance of {@link Accept }
     */
    public Accept createAccept() {
        return new Accept();
    }

    /**
     * Create an instance of {@link Apply }
     */
    public Apply createApply() {
        return new Apply();
    }

    /**
     * Create an instance of {@link LoanRequest }
     */
    public LoanRequest createLoanRequest() {
        return new LoanRequest();
    }

    /**
     * Create an instance of {@link RetrieveResponse }
     */
    public RetrieveResponse createRetrieveResponse() {
        return new RetrieveResponse();
    }

    /**
     * Create an instance of {@link DeclineResponse }
     */
    public DeclineResponse createDeclineResponse() {
        return new DeclineResponse();
    }

    /**
     * Create an instance of {@link AcceptResponse }
     */
    public AcceptResponse createAcceptResponse() {
        return new AcceptResponse();
    }

    /**
     * Create an instance of {@link LoanOption }
     */
    public LoanOption createLoanOption() {
        return new LoanOption();
    }

    /**
     * Create an instance of {@link LoanApplication }
     */
    public LoanApplication createLoanApplication() {
        return new LoanApplication();
    }

    /**
     * Create an instance of {@link Retrieve }
     */
    public Retrieve createRetrieve() {
        return new Retrieve();
    }

    /**
     * Create an instance of {@link OptionSelection }
     */
    public OptionSelection createOptionSelection() {
        return new OptionSelection();
    }

    /**
     * Create an instance of {@link Address }
     */
    public Address createAddress() {
        return new Address();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AcceptResponse }{@code >}}
     */
    @XmlElementDecl(namespace = "http://loan.api.bigbank.samples.fabric3.org/", name = "acceptResponse")
    public JAXBElement<AcceptResponse> createAcceptResponse(AcceptResponse value) {
        return new JAXBElement<AcceptResponse>(_AcceptResponse_QNAME, AcceptResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoanApplication }{@code >}}
     */
    @XmlElementDecl(namespace = "http://loan.api.bigbank.samples.fabric3.org/", name = "loanApplication")
    public JAXBElement<LoanApplication> createLoanApplication(LoanApplication value) {
        return new JAXBElement<LoanApplication>(_LoanApplication_QNAME, LoanApplication.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveResponse }{@code >}}
     */
    @XmlElementDecl(namespace = "http://loan.api.bigbank.samples.fabric3.org/", name = "retrieveResponse")
    public JAXBElement<RetrieveResponse> createRetrieveResponse(RetrieveResponse value) {
        return new JAXBElement<RetrieveResponse>(_RetrieveResponse_QNAME, RetrieveResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeclineResponse }{@code >}}
     */
    @XmlElementDecl(namespace = "http://loan.api.bigbank.samples.fabric3.org/", name = "declineResponse")
    public JAXBElement<DeclineResponse> createDeclineResponse(DeclineResponse value) {
        return new JAXBElement<DeclineResponse>(_DeclineResponse_QNAME, DeclineResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Decline }{@code >}}
     */
    @XmlElementDecl(namespace = "http://loan.api.bigbank.samples.fabric3.org/", name = "decline")
    public JAXBElement<Decline> createDecline(Decline value) {
        return new JAXBElement<Decline>(_Decline_QNAME, Decline.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoanRequest }{@code >}}
     */
    @XmlElementDecl(namespace = "http://loan.api.bigbank.samples.fabric3.org/", name = "loanRequest")
    public JAXBElement<LoanRequest> createLoanRequest(LoanRequest value) {
        return new JAXBElement<LoanRequest>(_LoanRequest_QNAME, LoanRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Accept }{@code >}}
     */
    @XmlElementDecl(namespace = "http://loan.api.bigbank.samples.fabric3.org/", name = "accept")
    public JAXBElement<Accept> createAccept(Accept value) {
        return new JAXBElement<Accept>(_Accept_QNAME, Accept.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ApplyResponse }{@code >}}
     */
    @XmlElementDecl(namespace = "http://loan.api.bigbank.samples.fabric3.org/", name = "applyResponse")
    public JAXBElement<ApplyResponse> createApplyResponse(ApplyResponse value) {
        return new JAXBElement<ApplyResponse>(_ApplyResponse_QNAME, ApplyResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Retrieve }{@code >}}
     */
    @XmlElementDecl(namespace = "http://loan.api.bigbank.samples.fabric3.org/", name = "retrieve")
    public JAXBElement<Retrieve> createRetrieve(Retrieve value) {
        return new JAXBElement<Retrieve>(_Retrieve_QNAME, Retrieve.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Apply }{@code >}}
     */
    @XmlElementDecl(namespace = "http://loan.api.bigbank.samples.fabric3.org/", name = "apply")
    public JAXBElement<Apply> createApply(Apply value) {
        return new JAXBElement<Apply>(_Apply_QNAME, Apply.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OptionSelection }{@code >}}
     */
    @XmlElementDecl(namespace = "http://loan.api.bigbank.samples.fabric3.org/", name = "optionSelection")
    public JAXBElement<OptionSelection> createOptionSelection(OptionSelection value) {
        return new JAXBElement<OptionSelection>(_OptionSelection_QNAME, OptionSelection.class, null, value);
    }

}
