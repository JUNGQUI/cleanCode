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
class DrawServiceTest {
	@Autowired private DrawService drawService;

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
		drawService.drawTable("LJK", bowlingPoints);
		drawService.drawTable("LJK", bowlingPoints11Frame);
	}

	@Test
	void scoreTest() {
		drawService.drawTable("LJK", bowlingPoints);
		drawService.drawTable("LJK", bowlingPoints11Frame);

		Frame frame = new Frame(1);
		Frame frame11 = new Frame(1);

		for (BowlingPoint point : bowlingPoints) {
			frame.bowling(point.getFirstScore());
			drawService.drawTable("1fr", frame);
			frame.bowling(point.getSecondScore());
			drawService.drawTable("2fr", frame);
		}

		for (BowlingPoint point : bowlingPoints11Frame) {
			frame11.bowling(point.getFirstScore());
			drawService.drawTable("111", frame11);
			frame11.bowling(point.getSecondScore());
			drawService.drawTable("112", frame11);
		}

		System.out.println(frame.totalScore());
		System.out.println(frame11.totalScore());
	}
}