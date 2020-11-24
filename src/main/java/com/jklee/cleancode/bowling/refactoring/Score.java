package com.jklee.cleancode.bowling.refactoring;

import lombok.Builder;

@Builder
public class Score {
	private int score;
	private int leftCount;

	public Score(int score, int leftCount) {
		this.score = score;
		this.leftCount = leftCount;
	}
}
