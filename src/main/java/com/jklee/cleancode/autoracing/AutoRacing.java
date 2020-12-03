package com.jklee.cleancode.autoracing;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class AutoRacing {
	public void autoRacing(int value, int number) {
		List<String> cars = new ArrayList<>();

		for (int i = 0; i < value; i++) {
			cars.add("-");
		}

		cars = RacingUtil.calculator(cars, number);

		RacingUtil.printCars(cars);
	}
}
