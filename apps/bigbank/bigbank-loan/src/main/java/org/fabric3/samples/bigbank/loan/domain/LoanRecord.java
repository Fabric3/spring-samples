/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.fabric3.samples.bigbank.loan.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;
import java.io.Serializable;
import java.util.List;

/**
 * @version $Revision$ $Date$
 */
@Entity
public class LoanRecord implements Serializable {
    private static final long serialVersionUID = -5710340587799398147L;
    private long id;
    private long version;
    private long loanNumber;
    private long expiration;
    private int status;
    private String ssn;
    private String email;
    private double amount;
    private double downPayment;
    private String typeSelected;
    private PropertyInfo propertyInfo;
    private RiskInfo riskInfo;
    private List<TermInfo> terms;
    private int creditScore;

    public LoanRecord() {
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

    public long getLoanNumber() {
        return loanNumber;
    }

    public void setLoanNumber(long loanNumber) {
        this.loanNumber = loanNumber;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    /**
     * Returns the loan status as defined in {@link org.fabric3.samples.bigbank.api.message.LoanStatus}.
     *
     * @return the loan status
     */
    public int getStatus() {
        return status;
    }

    /**
     * Sets the loan status as defined in {@link org.fabric3.samples.bigbank.api.message.LoanStatus}.
     *
     * @param status the loan status
     */
    public void setStatus(int status) {
        this.status = status;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns the loan amount.
     *
     * @return the loan amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Sets the loan amount.
     *
     * @param amount the loan amount
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * Returns the loan downpayment amount.
     *
     * @return the loan downpayment amount
     */
    public double getDownPayment() {
        return downPayment;
    }

    /**
     * Sets the loan downpayment amount.
     *
     * @param downPayment loan downpayment amount
     */
    public void setDownPayment(double downPayment) {
        this.downPayment = downPayment;
    }

    @OneToOne(cascade = CascadeType.ALL)
    public PropertyInfo getPropertyInfo() {
        return propertyInfo;
    }

    public void setPropertyInfo(PropertyInfo propertyInfo) {
        this.propertyInfo = propertyInfo;
    }

    /**
     * Returns the applicant's credit score
     *
     * @return the applicant's credit score
     */
    public int getCreditScore() {
        return creditScore;
    }

    /**
     * Sets the applicant's credit score
     *
     * @param creditScore the applicant's credit score
     */
    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    /**
     * Returns the applicant's risk assesment.
     *
     * @return the applicant's risk assesment
     */
    @OneToOne(cascade = CascadeType.ALL)
    public RiskInfo getRiskInfo() {
        return riskInfo;
    }

    /**
     * Sets the applicant's risk assesment.
     *
     * @param assessment the applicant's risk assesment
     */
    public void setRiskInfo(RiskInfo assessment) {
        this.riskInfo = assessment;
    }


    public long getExpiration() {
        return expiration;
    }

    public void setExpiration(long expiration) {
        this.expiration = expiration;
    }

    public void setTerms(List<TermInfo> terms) {
        this.terms = terms;
    }

    @OneToMany(cascade = CascadeType.ALL)
    public List<TermInfo> getTerms() {
        return terms;
    }

    public String getTypeSelected() {
        return typeSelected;
    }

    public void setTypeSelected(String typeSelected) {
        this.typeSelected = typeSelected;
    }

}
