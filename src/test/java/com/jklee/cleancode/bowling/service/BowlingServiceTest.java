package com.jklee.cleancode.bowling.service;

import com.jklee.cleancode.bowling.refactoring.Frame;
import java.util.Random;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BowlingServiceTest {

	@Autowired private DrawService drawService;

	@Test
	void fullTest() {
		Random random = new Random();
		Frame frame_LJK = new Frame();
		Frame frame_BRS = new Frame();

		for (int i = 0; i < 10; i++) {
			int score = random.nextInt(11);
			frame_LJK.bowling(score);

			if (i == 9 && score == 10) {
				i--;
			}

			if (score != 10) {
				score = random.nextInt(11 - score);
				frame_LJK.bowling(score);
			}
			drawService.drawTable("LJK", frame_LJK);
		}

		for (int i = 0; i < 10; i++) {
			int score = random.nextInt(11);
			frame_BRS.bowling(score);

			if (i == 9 && score == 10) {
				i--;
			}

			if (score != 10) {
				score = random.nextInt(11 - score);
				frame_BRS.bowling(score);
			}

			drawService.drawTable("BRS", frame_BRS);
		}
	}
}
