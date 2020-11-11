package com.jklee.cleancode.stringcalculator;

import java.util.regex.Pattern;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StringCalculatorWithCustomDelimiterTest {
	@Autowired private StringCalculatorWithCustomDelimiter stringCalculatorWithCustomDelimiter;

	@DisplayName("전체 test")
	@Test
	void fullTest() {
		stringCalculatorWithCustomDelimiter.calculator("1,2:3,4");
	}

	@DisplayName("숫자 검증 test")
	@Test
	void validateNumberTest() {
		Assertions.assertTrue(validateNumber("1"));
		Assertions.assertTrue(validateNumber("3"));
		Assertions.assertTrue(validateNumber("13235245"));
		Assertions.assertFalse(validateNumber("1213d3qwd1"));
		Assertions.assertFalse(validateNumber("f232903i90"));
		Assertions.assertFalse(validateNumber("-345"));
	}

	@DisplayName("delimiter 분해 test")
	@Test
	void refinceStringTest() {
		Assertions.assertEquals(
				refineString("//; test", ";"),
				"test"
		);

		Assertions.assertEquals(
				refineString("//, must success", ","),
				"must success"
		);

		Assertions.assertNotEquals(
				refineString("//: test fail", ":"),
				"must failed"
		);
	}

	@DisplayName("custom delimiter 패턴 test")
	@Test
	void customDelimiter() {
		CustomDelimiter customDelimiter1 = customDelimiter("//; 12d121");
		CustomDelimiter customDelimiter2 = customDelimiter("//: 12d121");
		CustomDelimiter customDelimiter3 = customDelimiter("//, 12d121");
		CustomDelimiter customDelimiter4 = customDelimiter("//32asd. 12d121");

		Assertions.assertTrue(customDelimiter1.isCustom());
		Assertions.assertTrue(customDelimiter2.isCustom());
		Assertions.assertTrue(customDelimiter3.isCustom());
		Assertions.assertFalse(customDelimiter4.isCustom());

		Assertions.assertEquals(customDelimiter1.getDelimiter(), ";");
		Assertions.assertEquals(customDelimiter2.getDelimiter(), ":");
		Assertions.assertEquals(customDelimiter3.getDelimiter(), ",");
	}

	private boolean validateNumber(String stringNumber) {
		return !stringNumber.contains("-")
				&& Pattern.matches("^(0|[1-9][0-9]*)$", stringNumber);
	}

	private String refineString (String stringNumbers, String delimiter) {
		return stringNumbers.replace(
				"//" + delimiter + " ", ""
		);
	}

	private CustomDelimiter customDelimiter (String pattern) {
		if (Pattern.matches("//(.) (.*)", pattern)) {
			return CustomDelimiter.builder()
					.custom(true)
					.delimiter(
							pattern.split(" ")[0]
									.replace("//", "")
					)
					.build();
		}

		return CustomDelimiter.builder()
				.custom(false)
				.build();
	}
}