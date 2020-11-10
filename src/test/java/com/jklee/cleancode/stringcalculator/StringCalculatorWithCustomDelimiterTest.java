package com.jklee.cleancode.stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StringCalculatorWithCustomDelimiterTest {
	@Autowired private StringCalculatorWithCustomDelimiter stringCalculatorWithCustomDelimiter;

	@DisplayName("전체 test")
	@Test
	public void fullTest() {
		stringCalculatorWithCustomDelimiter.calculator("1,2:3,4");
	}
}