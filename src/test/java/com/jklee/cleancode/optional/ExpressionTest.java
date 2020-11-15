package com.jklee.cleancode.optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ExpressionTest {
	@Test
	public void of() {
		Assertions.assertSame(Expression.PLUS, Expression.of("+"));
	}

	@Test
	public void notValidExpression() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> Expression.of("&"));
		Assertions.assertThrows(IllegalArgumentException.class, () -> Expression.ofWithOptional("&"));
	}
}
