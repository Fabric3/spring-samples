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
package org.fabric3.samples.rs.calculator;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.oasisopen.sca.annotation.Reference;

/**
 * Implementation of the CalculatorService.
 *
 * @version $Rev$ $Date$
 */
@Path("/")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class CalculatorService {
    private AddService addService;
    private SubtractService subtractService;
    private MultiplyService multiplyService;
    private DivideService divideService;

    @Reference
    public void setAddService(AddService addService) {
        this.addService = addService;
    }

    @Reference
    public void setSubtractService(SubtractService subtractService) {
        this.subtractService = subtractService;
    }

    @Reference
    public void setMultiplyService(MultiplyService multiplyService) {
        this.multiplyService = multiplyService;
    }

    @Reference
    public void setDivideService(DivideService divideService) {
        this.divideService = divideService;
    }


    @GET
    @Path("/{formula}")
    public String calculate(@PathParam("formula") String formula) {
        formula = formula.replaceAll("\\s+", "");
        String[] tokens = formula.split("[\\+\\-\\*\\\\\\:]");
        if (tokens.length != 2) {
            throw new IllegalArgumentException("Invalid formula: " + formula);
        }
        double operand1 = Double.parseDouble(tokens[0]);
        double operand2 = Double.parseDouble(tokens[1]);
        double result;
        if (formula.indexOf("+") > 0) {
            result = addService.add(operand1, operand2);
        } else if (formula.indexOf("-") > 0) {
            result = subtractService.subtract(operand1, operand2);
        } else if (formula.indexOf("*") > 0) {
            result = multiplyService.multiply(operand1, operand2);
        } else if (formula.indexOf(":") > 0) {
            result = divideService.divide(operand1, operand2);
        } else {
            throw new IllegalArgumentException("Invalid formula: " + formula);
        }
        return String.valueOf(result);
    }

}

