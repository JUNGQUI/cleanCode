package com.jklee.cleancode.bowling;

public enum BowlingStatus {
	STRIKE, SPARE, OPEN;

	public static BowlingStatus getBowlingStatusForInit(int score) {
		if (score == 10) {
			return BowlingStatus.STRIKE;
		}

		return BowlingStatus.OPEN;
	}
}
