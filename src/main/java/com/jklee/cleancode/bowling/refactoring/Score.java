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
	private int legacyScore;

	private int leftCount;
	private int extraLeftCount;

	private String pointSign;

	public static Score init(int point) {
		return Score.builder()
				.score(point)
				.extraLeftCount(point == 10 ? 2 : 1)
				.leftCount(point == 10 ? 2 : 1)
				.pointSign(point == 10
						? "X"
						: point == 0
								? "-|"
								: point + "|"
				)
				.build();
	}

	public boolean setScore(int point) {
		if (leftCount != 2) {
			score += point;
			leftCount++;
			extraLeftCount = score == 10 ? 1 : 0;

			pointSign += leftCount == 2 && score == 10
					? "/"
					: point == 0
							? "-"
							: String.valueOf(point);

			return true;
		}

		if (extraLeftCount != 0) {
			score += point;
			extraLeftCount--;
		}

		return false;
	}
}
