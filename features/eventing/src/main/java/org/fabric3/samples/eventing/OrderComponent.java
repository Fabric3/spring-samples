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

import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.oasisopen.sca.annotation.Scope;

import org.fabric3.api.annotation.Consumer;

/**
 * Component that subscribes to the buy and sell channels to match sell and buy orders.
 */
@Scope("COMPOSITE")
public class OrderComponent {
    private Queue<BuyOrder> buyOrders = new ConcurrentLinkedQueue<BuyOrder>();

    private ScheduledExecutorService executorService;

    public OrderComponent() {
        executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleWithFixedDelay(new OrderExpirer(), 120, 120, TimeUnit.SECONDS);
    }

    /**
     * Receives sell orders as they arrive in the sell channel.
     *
     * @param sellOrder a received offer
     */
    @Consumer("sellChannel")
    public void onSell(SellOrder sellOrder) {
        System.out.println("Received a sell order:" + sellOrder.getSymbol() + " @ " + sellOrder.getPrice() + " [" + sellOrder.getId() + "]");
        for (Iterator<BuyOrder> iterator = buyOrders.iterator(); iterator.hasNext(); ) {
            BuyOrder buyOrder = iterator.next();
            if (match(sellOrder, buyOrder)) {
                System.out.println("Matched orders: " + buyOrder.getSymbol() + " @ " + sellOrder.getPrice() + " [" + sellOrder.getId() + "]");
                iterator.remove();
                break;
            }
        }
    }

    /**
     * Receives buy orders as they arrive in the order channel.
     *
     * @param buyOrder a received buy request
     */
    @Consumer("buyChannel")
    public void onBuy(BuyOrder buyOrder) {
        System.out.println("Received an buy order:" + buyOrder.getSymbol() + " @ " + buyOrder.getMaxPrice() + " [" + buyOrder.getId() + "]");
        buyOrders.add(buyOrder);
    }

    private boolean match(SellOrder sellOrder, BuyOrder buyOrder) {
        return (sellOrder.getSymbol().equals(buyOrder.getSymbol()) && sellOrder.getPrice() <= buyOrder.getMaxPrice());
    }

    private class OrderExpirer implements Runnable {

        public void run() {
            long now = System.currentTimeMillis();
            for (Iterator<BuyOrder> iterator = buyOrders.iterator(); iterator.hasNext(); ) {
                BuyOrder buyOrder = iterator.next();
                if (buyOrder.getExpireTime() <= now) {
                    System.out.println("Expired buy order: " + buyOrder.getSymbol() + " @ " + buyOrder.getMaxPrice() + " [" + buyOrder.getId() + "]");
                    iterator.remove();
                }
            }
        }
    }

}
