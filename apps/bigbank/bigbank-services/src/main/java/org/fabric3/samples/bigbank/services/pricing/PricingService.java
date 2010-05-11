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
package org.fabric3.samples.bigbank.services.pricing;

/**
 * Implementations compile a set of different loan options that fit the characteristics of an applicant and loan amount.
 *
 * @version $Rev$ $Date$
 */
public interface PricingService {

    /**
     * Prices a loan application.
     *
     * @param request the data required to price a loan application
     * @return the pricing result
     */
    PriceResponse price(PricingRequest request);
}
