package com.jklee.cleancode.bowling;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BowlingPoint {
	private int frame;
	private BowlingStatus bowlingStatus;
	private int finalPoint;

	void updatePoint(int point) {
		finalPoint += point;
	}

	public BowlingPoint bowlingPointBuilder (
			int frame,
			int point,
			BowlingStatus bowlingStatus) {
		return BowlingPoint.builder()
				.frame(frame)
				.bowlingStatus(bowlingStatus)
				.finalPoint(point)
				.build();
	}
}
