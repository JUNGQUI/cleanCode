package com.jklee.cleancode.bowling.refactoring;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter @Builder
@NoArgsConstructor
@AllArgsConstructor
public class Score {
	private int score;
	private int leftCount;
	private int extraLeftCount;

	public static Score init(int point) {
		return Score.builder()
				.score(point)
				.extraLeftCount(point == 10 ? 2 : 1)
				.leftCount(point == 10 ? 2 : 1)
				.build();
	}

	public boolean setScore(int point) {
		if (leftCount != 2) {
			score += point;
			leftCount++;
			extraLeftCount = score == 10 ? 1 : 0;

			return true;
		}

		if (extraLeftCount != 0) {
			score += point;
			extraLeftCount--;
		}

		return false;
	}
}
