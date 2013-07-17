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
package org.fabric3.samples.eventing;

import java.math.BigDecimal;
import java.util.Random;

import org.oasisopen.sca.annotation.Scope;

import org.fabric3.api.annotation.Producer;

/**
 * A simple stateless timer component that issues sell orders.
 */
@Scope("COMPOSITE")
public class SellTimer implements Runnable {
    private SellChannel sellChannel;
    private Random generator;

    public SellTimer(@Producer("sellChannel") SellChannel sellChannel) {
        this.sellChannel = sellChannel;
        generator = new Random();
    }

    public void run() {
        double price = generatePrice();
        SellOrder sellOrder = new SellOrder(System.currentTimeMillis(), "FOO", price);
        System.out.println("Sending sell order: " + sellOrder.getSymbol() + " @ " + sellOrder.getPrice());
        sellChannel.sell(sellOrder);
    }

    private double generatePrice() {
        double val = generator.nextDouble() * 5 + 70.0;
        BigDecimal bd = new BigDecimal(Double.toString(val));
        return bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

}
