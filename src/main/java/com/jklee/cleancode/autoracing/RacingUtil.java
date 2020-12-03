package com.jklee.cleancode.autoracing;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;
import lombok.experimental.UtilityClass;

@UtilityClass
public class RacingUtil {

	public void printCars(List<String> cars) {
		for (String car : cars) {
			System.out.println(car);
		}
	}

	public List<String> calculator(List<String> cars, int count) {
		Random random = new Random();

		for (int i = 0; i < count; i++) {
			cars = cars.stream()
					.map(car -> {
						if (random.nextInt(10) >= 4) {
							car += "-";
						}

						return car;
					})
					.collect(Collectors.toList());
		}

		return cars;
	}

	public List<String> calculateWinner(List<String> carNames, List<String> racingResult) {
		List<String> results = new ArrayList<>();
		int winningCount = 0;

		for (String result : racingResult) {
			winningCount = Math.max(winningCount, result.length());
		}

		for (int i = 0; i < carNames.size(); i++) {
			String name = racingResult.get(i).length() == winningCount
					? carNames.get(i)
					: null;

			results.add(name);
		}

		return results.stream()
				.filter(Objects::nonNull)
				.collect(
						Collectors.toList()
				);
	}

	public String refactoringCalculateWinner(List<String> carNames, List<String> racingResult) {
		int winningCount = 0, winnerIdx = -1;

		for (int i = 0; i < racingResult.size(); i++) {
			int prevCount = winningCount;
			winningCount = Math.max(winningCount, racingResult.get(i).length());
			winnerIdx = winningCount > prevCount ? i : winnerIdx;
		}

		return carNames.get(winnerIdx);
	}
}
