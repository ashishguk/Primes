package com.ashish.primes.domain.strategy;

import com.ashish.primes.domain.generator.Simple1PrimeNumberGenerator;
import com.ashish.primes.domain.generator.Simple2PrimeNumberGenerator;
import com.ashish.primes.domain.generator.SundaramPrimeNumberGenerator;

/**
 * Determine the requested strategy. Implementation of a new strategy need to be
 * added here.
 */
public class StrategySelector {
	public static PrimeNumberApplicationStrategy selectStrategy(String requestedStrategy) {
		switch (requestedStrategy.toLowerCase()) {
		case "simple1":
			return new Simple1PrimeNumberGenerator();
		case "simple2":
			return new Simple2PrimeNumberGenerator();
		case "sundaram":
			return new SundaramPrimeNumberGenerator();
		default:
			throw new UnsupportedOperationException(
					String.format("Invalid requested strategy,  %s", requestedStrategy));
		}
	}
}
