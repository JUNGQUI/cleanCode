package com.jklee.cleancode.bowling.refactoring;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter @Builder
@NoArgsConstructor
@AllArgsConstructor
public class Frame {
	private int frameNumber;
	private Score score;

	private Frame prevFrame;
	private Frame nextFrame;

	public Frame(int frameNumber) {
		this.frameNumber = frameNumber;
	}

	public int totalScore() {
		if (this.nextFrame == null) {
			return score.getScore();
		}

		return score.getScore() + this.nextFrame.totalScore();
	}

	public void bowling(int point) {
		if (this.score == null) {
			this.score = Score.init(point);
			return;
		}

		boolean result = this.score.setScore(point);

		if (!result) {
			this.nextFrame = setNextFrame(this.nextFrame, point);
		}

		totalScore();
	}

	Frame setNextFrame(Frame frame, int point) {
		if (frame == null) {
			frame = new Frame(this.frameNumber+1);
			frame.prevFrame = this;
		}

		frame.bowling(point);

		return frame;
	}
}
