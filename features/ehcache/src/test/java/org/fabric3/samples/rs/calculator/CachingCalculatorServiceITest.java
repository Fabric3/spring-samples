package org.fabric3.samples.rs.calculator;

import static org.fabric3.samples.rs.calculator.Constants.SIMULATED_PROCESSING_TIME;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.oasisopen.sca.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This integration test tests the caching mechanism inside Fabric3 container.
 * 
 * @author teemu
 *
 */
public class CachingCalculatorServiceITest {

	private Logger log = LoggerFactory.getLogger(getClass());

	@Reference
	private CalculatorService cachingCalculatorService;
	
	@Test
	public void testCachingCalculate() {
		long beginTime = System.nanoTime();
		String firstResult = cachingCalculatorService.calculate("1+2");
		// without value in cache the processing is slow (notice we use nanosecs here instead of ms as is in processing simulation)
		long processingTime = System.nanoTime() - beginTime;
		log.debug("Processing without value in cache was {} nanoseconds", processingTime);
		assertThat(processingTime, is(greaterThan(SIMULATED_PROCESSING_TIME * 1000)));
		beginTime = System.nanoTime();
		String secondResult = cachingCalculatorService.calculate("1+2");
		// now we get the value from cache which is faster
		processingTime = System.nanoTime() - beginTime;
		log.debug("Processing with a cached value was {} nanoseconds", processingTime);
		assertThat(processingTime, is(lessThan(SIMULATED_PROCESSING_TIME * 1000)));
		// make sure we got the same results from both calls
		assertThat(secondResult, is(firstResult));
	}

}
