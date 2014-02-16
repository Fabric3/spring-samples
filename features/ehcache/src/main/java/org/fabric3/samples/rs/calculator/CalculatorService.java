package org.fabric3.samples.rs.calculator;

import javax.ws.rs.GET;
import javax.ws.rs.Path;


public interface CalculatorService {

	@GET
	@Path("/{formula}")
	public abstract String calculate(String formula);

}