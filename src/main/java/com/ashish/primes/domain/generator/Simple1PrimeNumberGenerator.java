package com.ashish.primes.domain.generator;

import java.util.ArrayList;
import java.util.List;

import com.ashish.primes.domain.strategy.PrimeNumberApplicationStrategy;

/**
 * Go through the loop to check if it is divisible with any number less than
 * itself.
 */
public class Simple1PrimeNumberGenerator implements PrimeNumberApplicationStrategy {
	@Override
	public List<Integer> execute(int upperBound) {
		List<Integer> result = new ArrayList<Integer>();

		// go through the loop
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

		for (int j = 2; j < candidate; j++) {
			if (candidate % j == 0) { // it has factors, hence not prime
				return false;
			}
		}

		// out of loop and not found a factor
		return true;
	}

}
