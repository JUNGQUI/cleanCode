package com.jklee.cleancode.ladder;

import java.util.Random;

public class LadderUtil {
	public static boolean generatePoint() {
		Random random = new Random();
		return random.nextInt(99) % 2 == 0;
	}
}
