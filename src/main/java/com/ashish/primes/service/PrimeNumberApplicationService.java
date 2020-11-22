package com.ashish.primes.service;

import com.ashish.primes.domain.PrimeNumberApplicationStrategyClient;
import com.ashish.primes.web.Result;

/**
 * This service connects to the underlying prime number generator library to
 * calculate the prime number
 *
 */

public class PrimeNumberApplicationService {
	public Result generatePrimes(String calculationStrategy, int upperBound) {
		PrimeNumberApplicationStrategyClient client = new PrimeNumberApplicationStrategyClient();

		Result result = client.execute(calculationStrategy, upperBound);

		return result;

	}
}