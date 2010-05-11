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
package org.fabric3.samples.bigbank.loan.store;

import org.fabric3.samples.bigbank.loan.domain.LoanRecord;

/**
 * Persists and retrieves loan application data.
 *
 * @version $Revision$ $Date$
 */
public interface StoreService {

    /**
     * Save a new loan application.
     *
     * @param record the loan record.
     * @throws StoreException if an exception saving the application is encountered
     */
    void save(LoanRecord record) throws StoreException;

    /**
     * Updates an existing loan application.
     *
     * @param record the loan record.
     * @throws StoreException if an exception updating the application is encountered
     */
    void update(LoanRecord record) throws StoreException;

    /**
     * Deletes a loan application
     *
     * @param id the application id
     * @throws StoreException if an exception deleting the application is encountered
     */
    void remove(long id) throws StoreException;

    /**
     * Returns a loan application for the given id.
     *
     * @param id the application id.
     * @return the loan application or null if not found
     * @throws StoreException if an exception retrieving the application is encountered
     */
    LoanRecord find(long id) throws StoreException;

    /**
     * Returns a loan record by SSB
     *
     * @param ssn the SSN
     * @return the loan record or null if not found
     * @throws StoreException if an exception retrieving the application is encountered
     */
    LoanRecord findBySSN(String ssn) throws StoreException;
}
