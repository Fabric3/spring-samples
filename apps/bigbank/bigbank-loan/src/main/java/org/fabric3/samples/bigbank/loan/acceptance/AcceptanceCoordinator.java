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

import org.fabric3.samples.bigbank.api.loan.LoanException;
import org.fabric3.samples.bigbank.api.message.LoanApplication;

/**
 * Coordinator that handles processing for loan terms that have been accepted by applicants. If a loan is accepted, an appraisal will be ordered and a
 * funding date scheduled once the appraisal has been received and approved.
 *
 * @version $Revision$ $Date$
 */
public interface AcceptanceCoordinator {
    /**
     * Returns the terms of a loan.
     *
     * @param id the loan id
     * @return the loan application
     * @throws LoanException if an exception during acceptance was encountered. Subtypes including LoanNotFoundException and LoanNotApprovedException
     *                       may be thrown.
     */
    LoanApplication retrieve(long id) throws LoanException;

    /**
     * Accepts the terms of a loan.
     *
     * @param id   the loan id
     * @param type the type of option selected
     * @throws LoanException if an exception during acceptance was encountered.
     */
    void accept(long id, String type) throws LoanException;

    /**
     * Declines the terms of a loan.
     *
     * @param id the loan id
     * @throws LoanException if an exception during acceptance was encountered. Subtypes including LoanNotFoundException and LoanNotApprovedException
     *                       may be thrown.
     */
    void decline(long id) throws LoanException;
}
