package com.jklee.cleancode;

import java.util.Random;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CleancodeApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void randomTest() {
		Random random = new Random();

		random.nextInt(10); // NOTE : 0~9
	}

	@Test
	void replaceTest() {
		String number = "01012345678";

		Assertions.assertEquals("+821012345678", number.replaceFirst("0", "+82"));
		Assertions.assertEquals("+821+8212345678", number.replace("0", "+82"));
	}

	@Test
	void stringUtilTest() {
		Assertions.assertFalse(org.springframework.util.StringUtils.hasText(" "));
		Assertions.assertTrue(org.junit.platform.commons.util.StringUtils.isBlank(" "));
	}
}
