package com.ashish.primes.domain.generator;

import java.util.ArrayList;
import java.util.List;

import com.ashish.primes.domain.strategy.PrimeNumberApplicationStrategy;

/**
 * Go through the loop up only to its square root to check if it is divisible
 * with any number less than itself.
 */
public class Simple2PrimeNumberGenerator implements PrimeNumberApplicationStrategy {
	@Override
	public List<Integer> execute(int upperBound) {
		List<Integer> result = new ArrayList<Integer>();

		// Find all numbers that are prime and less than upperbound.
		for (int i = 2; i <= upperBound; i++) {
			if (isPrime(i)) {
				result.add(i);
			}
		}

		return result;
	}

	private boolean isPrime(int candidate) {
		if (candidate < 2) {
			return false;
		}

		for (int j = 2; j * j <= candidate; j++) { // Only determine factors up to square root times
			if (candidate % j == 0) { // factor found
				return false;
			}
		}

		// no factors found.
		return true;
	}

}
