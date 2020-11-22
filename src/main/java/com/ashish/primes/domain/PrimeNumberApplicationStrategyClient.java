package com.ashish.primes.domain;

import java.util.ArrayList;
import java.util.List;

import com.ashish.primes.domain.strategy.PrimeNumberApplicationStrategy;
import com.ashish.primes.domain.strategy.StrategySelector;
import com.ashish.primes.web.Result;

/**
 * Running the requested strategy
 */

public class PrimeNumberApplicationStrategyClient {
	public Result execute(String requestedStrategy, int upperBound) {
		try {
			// Work out the strategy
			PrimeNumberApplicationStrategy strategy = StrategySelector.selectStrategy(requestedStrategy);
			return execute(strategy, upperBound);
		} catch (Exception e) {
			return new Result(requestedStrategy, upperBound, e.getMessage(), e.getStackTrace().toString());
		}
	}

	/**
	 * Overloaded operator to allow for injection of strategy
	 */
	public Result execute(PrimeNumberApplicationStrategy strategy, int upperBound) {

		List<Integer> primes;
		// if upper bound is 0 or 1, then there are no primes.

		if (upperBound < 2) {
			primes = new ArrayList<Integer>(0);

		} else {
			primes = strategy.execute(upperBound);
		}

		try {
			return new Result(strategy.getClass().getSimpleName(), upperBound, primes);
		} catch (Exception e) {
			return new Result(strategy.getClass().getSimpleName(), upperBound, e.getMessage(),
					e.getStackTrace().toString());
		}

	}

}
