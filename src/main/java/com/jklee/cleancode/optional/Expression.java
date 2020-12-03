package com.jklee.cleancode.optional;

import java.util.Arrays;

public enum Expression {
	PLUS("+"), MINUS("-"), TIMES("*"), DIVIDE("/");

	private String expression;

	Expression(String expression) {
		this.expression = expression;
	}

	static Expression of(String expression) {
		Expression result = null;

		for (Expression v : values()) {
			result = v.expression.equals(expression) ? v : result;
		}

		if (result == null) {
			throw new IllegalArgumentException(String.format("%s는 사칙연산에 해당하지 않는 표현식입니다.", expression));
		}

		return result;
	}

	static Expression ofWithOptional(String expression) {
		return Arrays.stream(Expression.values())
				.filter(ex -> ex.expression.equals(expression))
				.findFirst().orElseThrow(
						() -> new IllegalArgumentException(String.format("%s는 사칙연산에 해당하지 않는 표현식입니다.", expression)
						)
		);
	}
}
