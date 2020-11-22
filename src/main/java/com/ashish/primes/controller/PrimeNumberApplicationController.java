package com.ashish.primes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ashish.primes.service.PrimeNumberApplicationService;
import com.ashish.primes.web.Result;

/**
 * This controller defines the paths and maps it to the service for creating and
 * handling prime numbers
 *
 */
@RestController
public class PrimeNumberApplicationController {

	@GetMapping("/primes/{initial}")
	public Result primeNumber(@PathVariable(value = "initial") String input,
			@RequestParam(value = "strategy", defaultValue = "simple1") String strategy) {
		
		try {
			Integer initial = Integer.valueOf(input);
			PrimeNumberApplicationService service = new PrimeNumberApplicationService();
			Result generatedResult = service.generatePrimes(strategy, initial);
			return (generatedResult);
		} catch (NumberFormatException e) {
			return new Result(strategy, 0, String.format("Invalid Input number, %s", input), e.getStackTrace().toString());
		}
	}

	@GetMapping("/primes")
	public String noInput() {
		return "Pleasae enter an Input number for returning Primes";
	}

}
