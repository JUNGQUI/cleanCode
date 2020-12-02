package com.jklee.cleancode.autoracing;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AutoRacingWinnerTest {

	private List<String> racingCars = new ArrayList<>();
	private List<String> raceResult = new ArrayList<>();

	@Autowired private AutoRacingWinner autoRacingWinner;

	@BeforeEach
	void initRacing() {
		for (String carName : "Porsche,Lamborghini,McLaren,Maybach,Bugatti".split(",")) {
			racingCars.add(carName);
			raceResult.add("-");
		}

		raceResult = RacingUtil.calculator(raceResult, 15);
	}

	@Test
	public void winnerTest() {
		autoRacingWinner.AutoRacintWinner(
				"Porsche,Lamborghini,McLaren,Maybach,Bugatti",
				15);
	}

	@Test
	void winnerTestRefactoring() {
		Assertions.assertEquals(
				RacingUtil.calculateWinner(racingCars, raceResult).get(0),
				RacingUtil.refactoringCalculateWinner(racingCars, raceResult)
		);
	}
}