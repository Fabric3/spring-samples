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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A collection of current loan Rates.
 *
 * @version $Rev$ $Date$
 */
public class RateResults implements Serializable {
    private static final long serialVersionUID = -8117214455334146925L;
    private List<Rate> rates = new ArrayList<Rate>();

    public void addRate(Rate rate) {
        rates.add(rate);
    }

    public List<Rate> getRates() {
        return Collections.unmodifiableList(rates);
    }
}
