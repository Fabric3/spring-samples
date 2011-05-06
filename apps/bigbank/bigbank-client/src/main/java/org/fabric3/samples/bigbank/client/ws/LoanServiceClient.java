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
package org.fabric3.samples.bigbank.client.ws;

import java.net.URL;
import java.util.UUID;
import javax.xml.namespace.QName;

import org.fabric3.samples.bigbank.client.ws.loan.Address;
import org.fabric3.samples.bigbank.client.ws.loan.LoanApplication;
import org.fabric3.samples.bigbank.client.ws.loan.LoanOption;
import org.fabric3.samples.bigbank.client.ws.loan.LoanRequest;
import org.fabric3.samples.bigbank.client.ws.loan.LoanService;
import org.fabric3.samples.bigbank.client.ws.loan.LoanServiceService;
import org.fabric3.samples.bigbank.client.ws.loan.OptionSelection;

/**
 * Demonstrates interacting with the BigBank Loan Service via web services. This client would typically be a part of a third-party system which
 * interacted with BigBank.
 * <p/>
 * Note the URL needs to be changed depending on the runtime the application is deployed to.
 *
 * @version $Rev$ $Date$
 */
public class LoanServiceClient {

    public static void main(String[] args) throws Exception {
        // URL when loan service deployed in the cluster without a load-balancer on localhost
        // Zone 1 port: 8182
        URL url = new URL("http://localhost:8180/loanService?wsdl");

        // URL when loan service deployed to WebLogic without a load-balancer and a Managed server set to port 7003 on localhost
        // URL url = new URL("http://localhost:7003/loanService?wsdl");

        QName name = new QName("http://loan.api.bigbank.samples.fabric3.org/", "LoanServiceService");
        LoanServiceService endpoint = new LoanServiceService(url, name);
        LoanService loanService = endpoint.getLoanServicePort();

        // apply for a loan
        LoanRequest request = new LoanRequest();
        request.setAmount(300000);
        request.setDownPayment(15000);
        request.setEmail("foo@bar.com");
        request.setSSN(UUID.randomUUID().toString());
        Address address = new Address();
        address.setCity("San Francisco");
        address.setState("CA");
        address.setStreet("123 Kearney");
        address.setZip(94110);
        request.setPropertyAddress(address);

        System.out.println("Submitting loan application...");
        long id = loanService.apply(request);
        System.out.println("\nLoan application id is: " + id);

        LoanApplication application = loanService.retrieve(id);
        System.out.println("\nLoan options are: ");

        for (LoanOption option : application.getOptions()) {
            System.out.println(option.getType() + " " + option.getRate() + "% " + option.getApr() + " apr");
        }
        OptionSelection selection = new OptionSelection();

        String selectedType = application.getOptions().get(0).getType();
        System.out.println("\nSelecting " + selectedType + "...");
        selection.setId(id);
        selection.setType(selectedType);
        loanService.accept(selection);
        System.out.println("\nLoan accepted and processed.");

    }
}