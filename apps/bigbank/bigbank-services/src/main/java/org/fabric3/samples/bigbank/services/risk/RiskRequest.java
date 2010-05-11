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
package org.fabric3.samples.bigbank.services.risk;

import java.io.Serializable;

/**
 * @version $Revision$ $Date$
 */
public class RiskRequest implements Serializable {
    private static final long serialVersionUID = -5185791927524383209L;
    private long id;
    private int creditScore;
    private double downPayment;
    private double amount;

    public RiskRequest(long id, int creditScore, double amount, double downPayment) {
        this.id = id;
        this.creditScore = creditScore;
        this.amount = amount;
        this.downPayment = downPayment;
    }

    public long getId() {
        return id;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public double getAmount() {
        return amount;
    }

    public double getDownPayment() {
        return downPayment;
    }
}
