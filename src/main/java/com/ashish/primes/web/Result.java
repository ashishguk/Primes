package com.ashish.primes.web;

import java.util.ArrayList;
import java.util.List;

/**
 * Layout of Generated Response of API
 */
public class Result {
	private String strategy;
	private int initial;
	private List<Integer> primes;
	private List<String> errors;

	public Result(String requestedStrategy, int upperBound, String... errors) {
		this.strategy = requestedStrategy;
		this.initial = upperBound;
		if (errors != null) {
			this.errors = new ArrayList<String>(errors.length);
			for (String error : errors)
				this.errors.add(error);
		}
	}

	public Result(String requestedStrategy, int upperBound, List<Integer> primeNumbers) {

		this.strategy = requestedStrategy;
		this.initial = upperBound;
		this.primes = primeNumbers;
	}

	public String getStrategy() {
		return strategy;
	}

	public void setStrategy(String strategy) {
		this.strategy = strategy;
	}

	public int getInitial() {
		return initial;
	}

	public void setInitial(int initial) {
		this.initial = initial;
	}

	public List<Integer> getPrimes() {
		return primes;
	}

	public void setPrimes(List<Integer> primes) {
		this.primes = primes;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}


}
