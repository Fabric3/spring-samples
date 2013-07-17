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
package org.fabric3.samples.bigbank.services.pricing.impl;

import org.fabric3.samples.bigbank.services.pricing.PriceResponse;
import org.fabric3.samples.bigbank.services.pricing.PricingOption;
import org.fabric3.samples.bigbank.services.pricing.PricingRequest;
import org.fabric3.samples.bigbank.services.pricing.PricingService;
import org.fabric3.samples.bigbank.services.rate.Rate;
import org.fabric3.samples.bigbank.services.rate.RateResults;
import org.fabric3.samples.bigbank.services.rate.RateService;

/**
 * Default implementation of the PricingService that uses a RateService to compile up-to-date loan options.
 */
public class RiskBasedPricingService implements PricingService {
    private RateService rateService;

    public void setRateService(RateService rateService) {
        this.rateService = rateService;
    }

    public PriceResponse price(PricingRequest request) {
        System.out.println("PricingService: Pricing application");
        PriceResponse response = new PriceResponse(request.getId());
        RateResults rateResults = rateService.calculateRates(request.getRiskFactor());
        for (Rate rate : rateResults.getRates()) {
            response.addOption(new PricingOption(rate.getType(), rate.getRate(), rate.getApr()));
        }
        return response;
    }
}
