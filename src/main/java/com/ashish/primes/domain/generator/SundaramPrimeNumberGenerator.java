package com.ashish.primes.domain.generator;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

import com.ashish.primes.domain.strategy.PrimeNumberApplicationStrategy;

/**
 * The sieve of Sundaram:
 * Start with a list of the integers from 1 to n. 
 * From this list, remove all numbers of the form i + j + 2ij.
 * The remaining numbers are doubled and incremented by one, 
 * giving a list of the odd prime numbers (i.e., all primes except 2) below 2n + 1.
 */
public class SundaramPrimeNumberGenerator implements PrimeNumberApplicationStrategy{
	@Override
	public List<Integer> execute(int upperBound) {
		BitSet isPrime = this.sieve(upperBound);
		

		return calculatePrimesFromSieved(isPrime, upperBound);
	}


	protected BitSet sieve(int upperBound) {
		int sundaramLimit = (int)Math.ceil(upperBound/2.0); // we can only do half of upperbound.
		BitSet isPrime = new BitSet(sundaramLimit);
		isPrime.set(0, upperBound - 1); //set all to prime

		int j = 1;
//Now set the bit to false for every i+j+2ij
		for(int i = 1; i <= j; i++){
			for(j = i; (i + j + 2*i*j) < sundaramLimit; j++){
				isPrime.clear(i + j + 2*i*j);
			}
		}
		
		return isPrime;
	}
	
	/**
	 * The remaining numbers are doubled and incremented by one.
	 */

	protected List<Integer> calculatePrimesFromSieved(BitSet isPrime, int upperBound) {
         List<Integer> primes = new ArrayList<Integer>();
		
		//2 is never returned in the algorithm so include it.
		if(upperBound > 1){
			primes.add(2);
		}
		
		//Sundaram starts at 3 (= 2 * i + 1, where i = 1)
		for (int i = isPrime.nextSetBit(1); i >= 0; i = isPrime.nextSetBit(i+1)) {
			int candidatePrime = 2*i + 1;
			
			if (candidatePrime <= upperBound){
			primes.add(candidatePrime);
			}
			if (i == Integer.MAX_VALUE) {
				break; // or (i+1) would overflow
			}
		}
		
		return primes;
	}

}
