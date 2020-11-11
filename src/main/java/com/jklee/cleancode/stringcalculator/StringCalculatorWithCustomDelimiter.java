package com.jklee.cleancode.stringcalculator;

import java.util.regex.Pattern;
import org.springframework.stereotype.Component;

@Component
public class StringCalculatorWithCustomDelimiter {

	public void calculator(String needCalculate) {
		int result = 0;
		CustomDelimiter customDelimiter = customDelimiter(needCalculate);

		String delimiter = customDelimiter.isCustom() ?
				customDelimiter.getDelimiter() : ",|:";

		needCalculate = refineString(needCalculate, delimiter);
		String[] StringNumbers = needCalculate.split(delimiter);

		for (String stringNumber : StringNumbers) {
			validateNumber(stringNumber);
			result += Integer.parseInt(stringNumber);
		}

		System.out.println(result);
	}

	private void validateNumber(String stringNumber) {
		if (stringNumber.contains("-")
				|| !Pattern.matches("^(0|[1-9][0-9]*)$", stringNumber)) {
			throw new RuntimeException("올바르지 않은 값입니다.");
		}
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
