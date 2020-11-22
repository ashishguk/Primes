package com.ashish.primes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * <h1>Generate and Return Prime numbers!</h1> This is an API which calculates
 * and returns all the prime numbers up to and including a number provided.
 * 
 * @author Ashish Gupta
 * @version 1.0
 * @since 2020-11-20
 */

@SpringBootApplication
public class PrimesApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrimesApplication.class, args);
	}

}
