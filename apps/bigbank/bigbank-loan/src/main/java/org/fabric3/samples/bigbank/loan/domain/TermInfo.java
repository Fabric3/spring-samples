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

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

/**
 * @version $Revision$ $Date$
 */
@Entity
public class TermInfo implements Serializable {
    private static final long serialVersionUID = -3157707604835927354L;
    private String type;
    private float rate;
    private float apr;
    private long id;
    private long version;

    public TermInfo() {
    }

    public TermInfo(String type, float rate, float apr) {
        this.type = type;
        this.rate = rate;
        this.apr = apr;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public float getApr() {
        return apr;
    }

    public void setApr(float apr) {
        this.apr = apr;
    }

}
