package com.jklee.cleancode.autoracing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class AutoRacing {
	public void autoRacing(
			int value,
			int number
	) {
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("자동차 대수는 몇 대 인가요?");
//		int value = scanner.nextInt();
//		System.out.println("시도할 회수는 몇 회 인가요?");
//		int number = scanner.nextInt();

		List<String> cars = new ArrayList<>();

		for (int i = 0; i < value; i++) {
			cars.add("-");
		}

		cars = calculator(cars, number);

		printCars(cars);
	}

	private void printCars(
			List<String> cars
	) {
		for (String car : cars) {
			System.out.println(car);
		}
	}

	private List<String> calculator(
			List<String> cars,
			int count
	) {
		Random random = new Random();

		for (int i = 0; i < count; i++) {
			cars = cars.stream()
					.map(car -> {
						if (random.nextInt(10) >= 4) {
							car += "-";
						}

						return car;
					}).collect(Collectors.toList());
		}

		return cars;
	}
}
