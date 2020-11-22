package com.jklee.cleancode;

import java.util.Random;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CleancodeApplicationTests {

	@Test
	void contextLoads() {
		Random random = new Random();

		random.nextInt(10); // NOTE : 0~9
	}

}
