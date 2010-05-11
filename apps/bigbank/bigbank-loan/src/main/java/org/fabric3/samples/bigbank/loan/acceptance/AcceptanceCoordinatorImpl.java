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
package org.fabric3.samples.bigbank.loan.acceptance;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.fabric3.samples.bigbank.api.loan.LoanApplicationNotFoundException;
import org.fabric3.samples.bigbank.api.loan.LoanException;
import org.fabric3.samples.bigbank.api.message.LoanApplication;
import org.fabric3.samples.bigbank.api.message.LoanOption;
import org.fabric3.samples.bigbank.api.message.LoanStatus;
import org.fabric3.samples.bigbank.loan.domain.LoanRecord;
import org.fabric3.samples.bigbank.loan.domain.TermInfo;
import org.fabric3.samples.bigbank.loan.notification.NotificationService;
import org.fabric3.samples.bigbank.loan.store.StoreException;
import org.fabric3.samples.bigbank.loan.store.StoreService;
import org.fabric3.samples.bigbank.services.appraisal.AppraisalRequest;
import org.fabric3.samples.bigbank.services.appraisal.AppraisalResult;
import org.fabric3.samples.bigbank.services.appraisal.AppraisalSchedule;
import org.fabric3.samples.bigbank.services.appraisal.AppraisalService;

/**
 * Default implementation of the AcceptanceCoordinator.
 *
 * @version $Revision$ $Date$
 */
public class AcceptanceCoordinatorImpl implements AcceptanceCoordinator {
    private AppraisalService appraisalService;
    private NotificationService notificationService;
    private StoreService storeService;

    public void setAppraisalService(AppraisalService appraisalService) {
        this.appraisalService = appraisalService;
    }

    public void setNotificationService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void setStoreService(StoreService storeService) {
        this.storeService = storeService;
    }

    public LoanApplication retrieve(long loanId) throws LoanException {
        LoanRecord record = findRecord(loanId);
        LoanApplication application = new LoanApplication();
        LoanOption[] options = new LoanOption[record.getTerms().size()];
        for (int i = 0; i < record.getTerms().size(); i++) {
            TermInfo term = record.getTerms().get(i);
            LoanOption loanOption = new LoanOption(term.getType(), term.getRate(), term.getApr());
            options[i] = loanOption;
        }
        application.setOptions(options);
        return application;
    }

    public void accept(long id, String type) throws LoanException {
        LoanRecord record = findRecord(id);
        List<TermInfo> terms = record.getTerms();
        boolean found = false;
        for (TermInfo term : terms) {
            if (term.getType().equals(type)) {
                found = true;
                break;
            }
        }
        if (!found) {
            throw new InvalidLoanOptionException("Invalid loan option selected for loan " + id);
        }
        record.setTypeSelected(type);
        record.setStatus(LoanStatus.AWAITING_APPRAISAL);
        try {
            storeService.update(record);
        } catch (StoreException e) {
            throw new LoanException(e);
        }
        AppraisalRequest request = new AppraisalRequest(id, record.getPropertyInfo().getAddress());
        AppraisalSchedule schedule = appraisalService.appraise(request);
        schedule(schedule);
    }

    public void decline(long id) throws LoanException {
        LoanRecord record = findRecord(id);
        record.setStatus(LoanStatus.DECLINED);
        try {
            storeService.update(record);
        } catch (StoreException e) {
            throw new LoanException(e);
        }
    }

    private void schedule(AppraisalSchedule schedule) throws LoanException {
        long id = schedule.getId();
        LoanRecord record = findRecord(id);
        String email = record.getEmail();
        Date date = schedule.getDate();
        notificationService.appraisalScheduled(email, id, date);
    }

    private void appraisalCompleted(AppraisalResult result) throws LoanException {
        if (AppraisalResult.DECLINED == result.getResult()) {
            // just return
            return;
        }
        LoanRecord record = findRecord(result.getId());
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 1);
        notificationService.fundingDateScheduled(record.getEmail(), record.getId(), calendar.getTime());
    }

    private LoanRecord findRecord(long id) throws LoanException {
        LoanRecord record;
        try {
            record = storeService.find(id);
        } catch (StoreException e) {
            throw new LoanException(e);
        }
        if (record == null) {
            throw new LoanApplicationNotFoundException("No loan application on file with id " + id);
        }
        return record;
    }


}
