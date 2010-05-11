/*
 * See the NOTICE file distributed with this work for information
 * regarding copyright ownership.  This file is licensed
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
package org.fabric3.samples.bigbank.services.credit.impl;

import org.fabric3.samples.bigbank.services.credit.CreditScore;
import org.fabric3.samples.bigbank.services.credit.CreditService;

/**
 * Implementation of a CreditService that returns a credit score from the fictitious credit bureau. This implementation records all credit score
 * operations with the AuditService.
 *
 * @version $Rev$ $Date$
 */
public class CreditServiceImpl implements CreditService {
    private AuditService auditService;

    public void setAuditService(AuditService auditService) {
        this.auditService = auditService;
    }

    public CreditScore score(String ssn) {
        System.out.println("CreditService: Calculating credit score");
        auditService.recordCheck(ssn);
        CreditScore score;
        if (ssn.startsWith("11")) {
            score = new CreditScore(ssn, 300);
        } else if (ssn.startsWith("22")) {
            score = new CreditScore(ssn, 700);
        } else {
            score = new CreditScore(ssn, 760);
        }
        auditService.recordResult(ssn, score);
        return score;
    }
}