package com.ashish.primes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.ashish.primes.domain.PrimeNumberApplicationStrategyClient;
import com.ashish.primes.domain.strategy.PrimeNumberApplicationStrategy;
import com.ashish.primes.web.Result;

@SpringBootTest
public class PrimeNumberApplicationStrategyClientTest {

	@Test
	public void testPrimeNumberApplicationStrategyInt() {
		PrimeNumberApplicationStrategyClient client = new PrimeNumberApplicationStrategyClient();
		Result result = client.execute(new TestApplicationStrategy(), 5);
		assertEquals(result.getPrimes().size(), 3);
		assertEquals((int) result.getPrimes().get(1), 3);
	}

	public class TestApplicationStrategy implements PrimeNumberApplicationStrategy {

		@Override
		public List<Integer> execute(int upperBound) {
			List<Integer> result = new ArrayList<Integer>();
			result.add(2);
			result.add(3);
			result.add(5);
			return result;
		}

	}
}
