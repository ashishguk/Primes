package com.ashish.primes.domain.strategy;

import java.util.List;

/**
 * Use this interface to implement new strategy patterns.
 */

public interface PrimeNumberApplicationStrategy {
	/**
	 * @param upperBound -  the upper bound of the prime numbers to be generated.
	 * @return
	 */
	public List<Integer> execute(int upperBound);

}
