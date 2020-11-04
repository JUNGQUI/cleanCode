package com.jklee.cleancode.stringcalculator;

import java.util.regex.Pattern;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class StringCalculator {
	public int calculator(String needCalculator) {
		int prevVal = 0;
		String sign = "";

		if (!StringUtils.hasText(needCalculator)) {
			throw new IllegalArgumentException();
		}

		for (String needCal : needCalculator.split(" ")) {
			if (checkSign(needCal)) {
				sign = needCal;
				continue;
			}

			if (!StringUtils.hasText(sign)) {
				prevVal = Integer.parseInt(needCal);
				continue;
			}

			prevVal = calculate(prevVal, Integer.parseInt(needCal), sign);
		}

		return prevVal;
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

	private boolean checkSign(String needCheck) {
		return Pattern.matches("[+\\-*/]", needCheck);
	}
}
