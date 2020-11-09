package com.jklee.cleancode.autoracing;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AutoRacingWinnerTest {

	@Autowired private AutoRacingWinner autoRacingWinner;

	@Test
	public void winnerTest() {
		autoRacingWinner.AutoRacintWinner(
				"Porsche,Lamborghini,McLaren,Maybach,Bugatti",
				15);
	}
}