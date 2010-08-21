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
package org.fabric3.samples.bigbank.services.risk;

import java.io.Serializable;

/**
 * Represents the risk associated with a loan calculated by a RiskAssessmentService.
 *
 * @version $Revision$ $Date$
 */
public class RiskResponse implements Serializable {
    private static final long serialVersionUID = 1427555176373119897L;
    public static final RiskReason[] EMPTY = new RiskReason[0];
    public static final int APPROVE = 1;
    public static final int REJECT = -1;
    private long id;
    private int decision;
    private int factor;
    private RiskReason[] reasons = EMPTY;

    public RiskResponse(long id, int decision, int factor, RiskReason[] reasons) {
        this.id = id;
        this.decision = decision;
        this.factor = factor;
        this.reasons = reasons;
    }

    public RiskResponse() {
    }

    public long getId() {
        return id;
    }

    public int getRiskFactor() {
        return factor;
    }

    public void setRiskFactor(int factor) {
        this.factor = factor;
    }

    public int getDecision() {
        return decision;
    }

    public void setDecision(int decision) {
        this.decision = decision;
    }

    public RiskReason[] getReasons() {
        return reasons;
    }

    public void setReasons(RiskReason[] reasons) {
        this.reasons = reasons;
    }

}
