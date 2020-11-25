package com.jklee.cleancode.bowling.service;

import com.jklee.cleancode.bowling.BowlingPoint;
import com.jklee.cleancode.bowling.refactoring.Frame;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BowlingServiceTest {
	@Autowired private BowlingService bowlingService;

	List<BowlingPoint> bowlingPoints = new ArrayList<>();
	List<BowlingPoint> bowlingPoints11Frame = new ArrayList<>();

	@BeforeEach
	void init() {
		Random random = new Random();

		for (int i = 0; i < 10; i++) {
			int firstPoint = random.nextInt(10);
			int secondPoint = random.nextInt(10 - firstPoint);

			bowlingPoints.add(
					BowlingPoint.builder(
							i+1,
							firstPoint,
							secondPoint)
							.build()
			);
		}

		for (int i = 0; i < 9; i++) {
			int firstPoint = random.nextInt(10);
			int secondPoint = random.nextInt(10 - firstPoint);

			bowlingPoints11Frame.add(
					BowlingPoint.builder(
							i+1,
							firstPoint,
							secondPoint)
							.build()
			);
		}

		bowlingPoints11Frame.add(
				BowlingPoint.builder(
						10,
						10,
						0)
						.build()
		);

		bowlingPoints11Frame.add(
				BowlingPoint.builder(
						11,
						10,
						0)
						.build()
		);
	}

	@Test
	void buildPointTest() {
		BowlingPoint bowlingPoint = BowlingPoint.builder(
				1,
				10,
				0)
				.build();

		Assertions.assertEquals("X", bowlingPoint.getPoint());
	}

	@Test
	void drawTableTest() {
		bowlingService.drawTable("LJK", bowlingPoints);
		bowlingService.drawTable("LJK", bowlingPoints11Frame);
	}

	@Test
	void getScoreTest() {
		Frame frame = new Frame();
	}
}