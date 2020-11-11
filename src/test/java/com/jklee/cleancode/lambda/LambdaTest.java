package com.jklee.cleancode.lambda;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LambdaTest {

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
	}
}
