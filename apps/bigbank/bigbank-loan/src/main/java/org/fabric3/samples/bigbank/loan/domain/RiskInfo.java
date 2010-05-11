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
package org.fabric3.samples.bigbank.loan.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @version $Revision$ $Date$
 */
@Entity
public class RiskInfo implements Serializable {
    private static final long serialVersionUID = 1427555176373119897L;
    public static final int APPROVE = 1;
    public static final int REJECT = -1;
    private long id;
    private long version;
    private int decision;
    private int factor;
    private List<RiskReasonInfo> reasons;

    public RiskInfo(int decision, int factor, List<RiskReasonInfo> reasons) {
        this.decision = decision;
        this.factor = factor;
        this.reasons = reasons;
    }

    public RiskInfo() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Version
    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
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

    @OneToMany(cascade = CascadeType.ALL)
    public List<RiskReasonInfo> getReasons() {
        return reasons;
    }

    public void setReasons(List<RiskReasonInfo> reasons) {
        this.reasons = reasons;
    }

}
