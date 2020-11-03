package com.jklee.cleancode.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JKStringTest {

	@DisplayName("쉼표로 String 을 분리한다.")
	@Test
	public void spiltString() {
		String needSplit = "1,2";
		Assertions.assertEquals("1", needSplit.split(",")[0]);
		Assertions.assertEquals("2", needSplit.split(",")[1]);

		String needSplit2 = "1";
		Assertions.assertEquals(needSplit2.split(",").length, new String[]{"1"}.length);
		Assertions.assertEquals(needSplit2.split(",")[0], new String[]{"1"}[0]);
	}

	@DisplayName("subString 으로 괄호를 제거한다.")
	@Test
	public void substring() {
		String needSubString = "(1,2)";
		Assertions.assertEquals("1,2", needSubString.substring(1, 4));
	}

	@DisplayName("charAt 으로 특정 문자를 가져온다.")
	@Test
	public void charAt() {
		String test = "abc";

		Assertions.assertEquals('a', test.charAt(0));
		Assertions.assertEquals('b', test.charAt(1));
		Assertions.assertEquals('c', test.charAt(2));

		try {
			Assertions.assertEquals('c', test.charAt(3));
		} catch (Exception ex) {
			Assertions.assertEquals("String index out of range: 3", ex.getMessage());
		}
	}
}
