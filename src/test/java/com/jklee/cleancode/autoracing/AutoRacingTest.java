package com.jklee.cleancode.autoracing;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AutoRacingTest {

	@Autowired AutoRacing autoRacing;

	@Test
	public void auto() {
		autoRacing.autoRacing(3, 5);
		autoRacing.autoRacing(5, 10);
	}

}