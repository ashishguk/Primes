package com.ashish.primes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.ashish.primes.domain.generator.Simple1PrimeNumberGenerator;
import com.ashish.primes.domain.generator.Simple2PrimeNumberGenerator;
import com.ashish.primes.domain.generator.SundaramPrimeNumberGenerator;
import com.ashish.primes.domain.strategy.PrimeNumberApplicationStrategy;

@SpringBootTest
public class PrimeNumberStrategiesTest {
	protected static List<PrimeNumberApplicationStrategy> primeNumberGenerators;
	
	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
		primeNumberGenerators = new ArrayList<PrimeNumberApplicationStrategy>();
		primeNumberGenerators.add(new Simple1PrimeNumberGenerator());
		primeNumberGenerators.add(new Simple2PrimeNumberGenerator());
		primeNumberGenerators.add(new SundaramPrimeNumberGenerator());
	}
	
	@AfterAll
	public static void tearDownAfterClass() throws Exception {
		primeNumberGenerators.clear();
		primeNumberGenerators = null;
	}
	
	@Test
	public void ifUpperLimit2(){
		for(PrimeNumberApplicationStrategy strategy : primeNumberGenerators)
		{
			List<Integer> result = strategy.execute(2);
			assertEquals(1, result.size());
		}
	}
	
	@Test
	public void ifUpperLimit10(){
		for(PrimeNumberApplicationStrategy strategy : primeNumberGenerators)
		{
			List<Integer> result = strategy.execute(10);
			assertEquals(4, result.size());
		}
	}
}

