package com.jklee.cleancode.optional;

import java.util.Arrays;

public enum Expression {
	PLUS("+"), MINUS("-"), TIMES("*"), DIVIDE("/");

	private String expression;

	Expression(String expression) {
		this.expression = expression;
	}

	private static boolean matchExpression(Expression e, String expression) {
		return expression.equals(e.expression);
	}

	static Expression of(String expression) {
		for (Expression v : values()) {
			if (matchExpression(v, expression)) {
				return v;
			}
		}

		throw new IllegalArgumentException(String.format("%s는 사칙연산에 해당하지 않는 표현식입니다.", expression));
	}

	static Expression ofWithOptional(String expression) {
		return Arrays.stream(Expression.values())
				.filter(ex -> matchExpression(ex, expression))
				.findFirst().orElseThrow(
						() -> new IllegalArgumentException(String.format("%s는 사칙연산에 해당하지 않는 표현식입니다.", expression)
						)
		);
	}
}
