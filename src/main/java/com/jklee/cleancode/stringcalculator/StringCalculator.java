package com.jklee.cleancode.stringcalculator;

import java.util.regex.Pattern;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class StringCalculator {
	public int calculator(String needCalculator) {
		if (!StringUtils.hasText(needCalculator)) {
			throw new IllegalArgumentException();
		}

		return calculateFrame(needCalculator.split(" "));
	}

	private int calculateFrame(String... needCalculate) {
		String sign = "";
		int result = initValue(needCalculate[0]);

		for (String needCal : needCalculate) {
			sign = checkSign(needCal) ? needCal : sign;
			result = !checkSign(needCal) && StringUtils.hasText(sign)
					? calculate(result, Integer.parseInt(needCal), sign)
					: result;
		}

		return result;
	}

	private int calculate(int a, int b, String sign) {
		if ("+".equals(sign)) {
			return a+b;
		} else if ("-".equals(sign)) {
			return a-b;
		} else if ("*".equals(sign)) {
			return a*b;
		} else if ("/".equals(sign)) {
			return a/b;
		}

		throw new IllegalArgumentException();
	}

	private int initValue(String needCal) {
		if (checkSign(needCal)) {
			throw new IllegalArgumentException();
		}

		return Integer.parseInt(needCal);
	}

	private boolean checkSign(String needCheck) {
		return Pattern.matches("[+\\-*/]", needCheck);
	}
}
