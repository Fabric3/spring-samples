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
package org.fabric3.samples.bigbank.services.rate;

import java.io.Serializable;

/**
 * Contains rate information for a given loan type.
 */
public class Rate implements Serializable {
    private static final long serialVersionUID = -2068873111891197563L;
    private String type;
    private float rate;
    private float apr;

    public Rate() {
    }

    public Rate(String type, float rate, float apr) {
        this.type = type;
        this.rate = rate;
        this.apr = apr;
    }

    public String getType() {
        return type;
    }

    public float getRate() {
        return rate;
    }

    public float getApr() {
        return apr;
    }
}
