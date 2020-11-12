package com.jklee.cleancode.lambda;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LambdaTest {

	// nextstep.fp.Lambda의 sumAll method
	List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

//	int sumAllLambda(List<Integer> numbers) {
//		return numbers.forEach();
//	}

	int sumAll(List<Integer> numbers) {
		int total = 0;
		for (int number : numbers) {
			total += number;
		}
		return total;
	}

	\int sumAllEven(List<Integer> numbers) {
		int total = 0;
		for (int number : numbers) {
			if (number % 2 == 0) {
				total += number;
			}
		}
		return total;
	}

	@Test
	public void 이동() {
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
	public void 정지() {
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
}
