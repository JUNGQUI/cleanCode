package com.jklee.cleancode.autoracing;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class AutoRacingWinner {

	public void AutoRacintWinner(String cars, int number) {
		List<String> racingCars = new ArrayList<>();
		List<String> raceResult = new ArrayList<>();

		for (String carName : cars.split(",")) {
			racingCars.add(carName);
			raceResult.add("-");
		}

		raceResult = RacingUtil.calculator(raceResult, number);

		RacingUtil.printCars(
				RacingUtil.calculateWinner(
						racingCars, raceResult
				)
		);
	}
}
