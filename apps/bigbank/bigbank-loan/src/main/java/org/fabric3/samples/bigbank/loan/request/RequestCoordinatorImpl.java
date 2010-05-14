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
package org.fabric3.samples.bigbank.loan.request;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.fabric3.samples.bigbank.api.loan.LoanException;
import org.fabric3.samples.bigbank.api.message.LoanRequest;
import org.fabric3.samples.bigbank.api.message.LoanStatus;
import org.fabric3.samples.bigbank.loan.domain.LoanRecord;
import org.fabric3.samples.bigbank.loan.domain.PropertyInfo;
import org.fabric3.samples.bigbank.loan.domain.TermInfo;
import org.fabric3.samples.bigbank.loan.notification.NotificationService;
import org.fabric3.samples.bigbank.loan.store.StoreException;
import org.fabric3.samples.bigbank.loan.store.StoreService;
import org.fabric3.samples.bigbank.services.credit.CreditScore;
import org.fabric3.samples.bigbank.services.credit.CreditService;
import org.fabric3.samples.bigbank.services.pricing.PriceResponse;
import org.fabric3.samples.bigbank.services.pricing.PricingOption;
import org.fabric3.samples.bigbank.services.pricing.PricingRequest;
import org.fabric3.samples.bigbank.services.pricing.PricingService;
import org.fabric3.samples.bigbank.services.risk.RiskAssessmentService;
import org.fabric3.samples.bigbank.services.risk.RiskRequest;
import org.fabric3.samples.bigbank.services.risk.RiskResponse;

/**
 * Default implementation of the RequestCoordinator service.
 *
 * @version $Revision$ $Date$
 */
@Transactional
public class RequestCoordinatorImpl implements RequestCoordinator {
    private CreditService creditService;
    private RiskAssessmentService riskService;
    private PricingService pricingService;
    private NotificationService notificationService;
    private StoreService storeService;

    public void setCreditService(CreditService creditService) {
        this.creditService = creditService;
    }

    public void setRiskService(RiskAssessmentService riskService) {
        this.riskService = riskService;
    }

    public void setPricingService(PricingService pricingService) {
        this.pricingService = pricingService;
    }

    public void setNotificationService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void setStoreService(StoreService storeService) {
        this.storeService = storeService;
    }

    public long start(LoanRequest request) throws LoanException {
        // create a loan application and process it
        LoanRecord record = new LoanRecord();
        record.setSsn(request.getSSN());
        record.setEmail(request.getEmail());
        record.setAmount(request.getAmount());
        record.setDownPayment(request.getDownPayment());
        PropertyInfo info = new PropertyInfo(request.getPropertyAddress());
        record.setPropertyInfo(info);
        record.setStatus(LoanStatus.SUBMITTED);
        try {
            storeService.save(record);
        } catch (StoreException e) {
            throw new LoanException(e);
        }
        // pull the applicant's credit score
        record = score(record);
        record = assess(record);
        return record.getId();
    }

    public void cancel() {
        throw new UnsupportedOperationException();
    }

    private LoanRecord score(LoanRecord record) throws LoanException {
        // assess the loan risk
        CreditScore score = creditService.score(record.getSsn());
        System.out.println("Received credit score");
        try {
            record.setCreditScore(score.getScore());
            return storeService.update(record);
        } catch (StoreException e) {
            throw new LoanException(e);
        }
    }

    private LoanRecord assess(LoanRecord record) throws LoanException {
        System.out.println("Assessing loan application");
        RiskRequest riskRequest = new RiskRequest(record.getId(), record.getCreditScore(), record.getAmount(), record.getDownPayment());
        RiskResponse response = riskService.assessRisk(riskRequest);
        if (RiskResponse.APPROVE == response.getDecision()) {
            // calculate the terms
            return price(record, response);
        } else {
            // declined
            return reject(record);
        }
    }

    private LoanRecord price(LoanRecord record, RiskResponse response) throws LoanException {
        System.out.println("Accepted loan application");
        PricingRequest pricingRequest = new PricingRequest(record.getId(), response.getRiskFactor());
        PriceResponse priceResponse = pricingService.price(pricingRequest);
        List<TermInfo> termImfos = new ArrayList<TermInfo>();
        for (PricingOption pricingOption : priceResponse.getOptions()) {
            TermInfo termInfo = new TermInfo();
            termInfo.setApr(pricingOption.getApr());
            termInfo.setRate(pricingOption.getRate());
            termInfo.setType(pricingOption.getType());
            termImfos.add(termInfo);
        }
        record.setTerms(termImfos);
        try {
            record.setStatus(LoanStatus.AWAITING_ACCEPTANCE);
            record = storeService.update(record);
            // notify the client
            notificationService.approved(record.getEmail(), record.getId());
            return record;
        } catch (StoreException e) {
            throw new LoanException(e);
        }

    }

    private LoanRecord reject(LoanRecord record) throws LoanException {
        try {
            System.out.println("Rejected loan application");
            record.setStatus(LoanStatus.REJECTED);
            record = storeService.update(record);
            // notify the client
            notificationService.rejected(record.getEmail(), record.getId());
            return record;
        } catch (StoreException e) {
            throw new LoanException(e);
        }
    }

}
