package com.jklee.cleancode.bowling.refactoring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FrameTest {
	@Test
	void frameTest() {
		Frame frame1 = new Frame(1);
		frame1.bowling(10);
		frame1.bowling(8);
		frame1.bowling(2);
		frame1.bowling(10);
		frame1.bowling(5);
		frame1.bowling(0);

		Frame frame2 = new Frame(1);
		frame2.bowling(10);
		frame2.bowling(10);
		frame2.bowling(10);
		frame2.bowling(9);
		frame2.bowling(1);
		frame2.bowling(1);
		frame2.bowling(0);

		Assertions.assertEquals(20, frame1.getScore().getScore());
		Assertions.assertEquals(20, frame1.getNextFrame().getScore().getScore());
		Assertions.assertEquals(15, frame1.getNextFrame().getNextFrame().getScore().getScore());
		Assertions.assertEquals(5, frame1.getNextFrame().getNextFrame().getNextFrame().getScore().getScore());
		Assertions.assertNull(frame1.getNextFrame().getNextFrame().getNextFrame().getNextFrame());

		Assertions.assertEquals(30, frame2.getScore().getScore());
		Assertions.assertEquals(29, frame2.getNextFrame().getScore().getScore());
		Assertions.assertEquals(20, frame2.getNextFrame().getNextFrame().getScore().getScore());
		Assertions.assertEquals(11, frame2.getNextFrame().getNextFrame().getNextFrame().getScore().getScore());
	}
}