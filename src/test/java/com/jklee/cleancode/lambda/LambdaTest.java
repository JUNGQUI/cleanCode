package com.jklee.cleancode.lambda;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LambdaTest {

	List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

	@Test
	void 이동() {
		Car car = new Car("pobi", 0);
		Car actual = car.move(new MoveStrategy() {
			@Override
			public boolean isMovable() {
				return true;
			}
		});
		Assertions.assertEquals(new Car("pobi", 1), actual);

		Car carWithLambda = new Car("pobi", 0);
		carWithLambda.move(() -> true);

		Assertions.assertEquals(new Car("pobi", 1), carWithLambda);
	}

	@Test
	void 정지() {
		Car car = new Car("pobi", 0);
		Car actual = car.move(new MoveStrategy() {
			@Override
			public boolean isMovable() {
				return false;
			}
		});
		Assertions.assertEquals(new Car("pobi", 0), actual);

		Car carWithLambda = new Car("pobi", 0);
		carWithLambda.move(() -> false);

		Assertions.assertEquals(new Car("pobi", 0), carWithLambda);
	}

	@Test
	void sumTest() {
		Assertions.assertEquals(
				sumAll(numbers),
				sumAllForLambda(numbers, number -> true)
		);

		Assertions.assertEquals(
				sumAllEven(numbers),
				sumAllForLambda(numbers, number -> number % 2 == 0)
		);
	}

	int sumAll(List<Integer> numbers) {
		int total = 0;
		for (int number : numbers) {
			total += number;
		}
		return total;
	}

	int sumAllEven(List<Integer> numbers) {
		int total = 0;
		for (int number : numbers) {
			if (number % 2 == 0) {
				total += number;
			}
		}
		return total;
	}

	int sumAllForLambda(List<Integer> numbers, Conditional conditional) {
		return numbers.stream()
				.filter(conditional::test)
				.mapToInt(number -> number)
				.sum();
	}
}
