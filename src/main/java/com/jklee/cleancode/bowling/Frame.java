package com.jklee.cleancode.bowling;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Frame {
	private int frameNo;
	private int score;

	private Frame prevFrame;
	private Frame nextFrame;

	public Frame (int frameCount) {
		frameNo = frameCount;
	}

	public void bowl(int point) {
		score = point;

	}

	public int getScore() {
		int totalScore = 0;

		return totalScore;
	}
}
