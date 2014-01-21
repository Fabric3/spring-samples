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

import static org.fabric3.samples.rs.calculator.Constants.*;

/**
 * An implementation of the Multiply service.
 */
public class MultiplyServiceImpl implements MultiplyService {

    public double multiply(double n1, double n2) {
    	// simulate long lasting processing for demonstrating the effect of caching
    	try {
			Thread.sleep(SIMULATED_PROCESSING_TIME);
		} catch (InterruptedException e) {
			// Do nothing
		}
        return n1 * n2;
    }

}