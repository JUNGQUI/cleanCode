package com.jklee.cleancode.bowling;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder(builderMethodName = "bowlingBuilder", toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class BowlingPoint {
	private int frame;
	private BowlingStatus bowlingStatus;
	private int firstPoint;
	private int secondPoint;

	public static BowlingPointBuilder builder (
			int frame,
			int firstPoint,
			int secondPoint) {

		BowlingStatus bowlingStatus = firstPoint == 10 ? BowlingStatus.STRIKE
				: firstPoint + secondPoint == 10 ? BowlingStatus.SPARE : BowlingStatus.OPEN;

		return BowlingPoint.bowlingBuilder()
				.frame(frame)
				.firstPoint(firstPoint)
				.secondPoint(secondPoint)
				.bowlingStatus(bowlingStatus);
	}

	public String getPoint() {
		return firstPoint == 10
				? "X"
				: firstPoint + secondPoint == 10
						? firstPoint + "|" + "\\"
						: (firstPoint == 0 ? "-" : firstPoint)
								+ "|"
								+ (secondPoint == 0 ? "-" : secondPoint);

	}

	public BowlingStatus getStatus() {
		return bowlingStatus;
	}
}
