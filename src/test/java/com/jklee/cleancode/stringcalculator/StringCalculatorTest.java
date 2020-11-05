package com.jklee.cleancode.stringcalculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StringCalculatorTest {
	@Autowired private StringCalculator stringCalculator;

	@DisplayName("계산기로 계산한다.")
	@Test
	public void testCalculator() {
		int result = stringCalculator.calculator("2 + 3 * 4 / 2");
		Assertions.assertEquals(10, result);

		result = stringCalculator.calculator("5 + 1 * 4 / 2");
		Assertions.assertEquals(12, result);
	}
}