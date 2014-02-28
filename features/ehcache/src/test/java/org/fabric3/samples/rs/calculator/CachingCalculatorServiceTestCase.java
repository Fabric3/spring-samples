package org.fabric3.samples.rs.calculator;

import static org.fabric3.samples.rs.calculator.Constants.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * This tests the caching mechanism WITHOUT any Fabric3 container involvement.
 * 
 * @author teemu
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:META-INF/caching-calculator-test-context.xml")
public class CachingCalculatorServiceTestCase {

	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
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
		assertThat(firstResult, is(secondResult));
	}

}
