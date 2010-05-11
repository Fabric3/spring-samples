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
package org.fabric3.samples.bigbank.loan.notification;

import java.util.Date;

/**
 * A NotificationService implementation that sends output to the console. In a more realistic implementation, an email or some other mechanism would
 * be used.
 *
 * @version $Revision$ $Date$
 */
public class NotificationServiceImpl implements NotificationService {

    public void approved(String email, long applicationId) {
        System.out.println("NotificationService: Loan has been approved for " + applicationId);
    }

    public void rejected(String email, long applicationId) {
        System.out.println("NotificationService: Loan has been declined for " + applicationId);
    }

    public void appraisalScheduled(String email, long applicationId, Date date) {
        System.out.println("NotificationService: Appraisal scheduled for loan application "
                + applicationId + " on " + date);
    }

    public void appraisalFinished(String email, long applicationId) {
        System.out.println("NotificationService: Appraisal finished for loan application " + applicationId);
    }

    public void fundingDateScheduled(String email, long applicationId, Date date) {
        System.out.println("NotificationService: Loan funding date scheduled for loan application "
                + applicationId + " on " + date);
    }
}
