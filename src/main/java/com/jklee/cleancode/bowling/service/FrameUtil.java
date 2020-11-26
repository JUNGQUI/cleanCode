package com.jklee.cleancode.bowling.service;

import com.jklee.cleancode.bowling.BowlingStatus;
import com.jklee.cleancode.bowling.refactoring.Frame;
import lombok.experimental.UtilityClass;

@UtilityClass
public class FrameUtil {
	public BowlingStatus getLastStatus(Frame frame) {
		if (frame.getNextFrame() == null) {
			String sign = frame.getScore().getPointSign();

			return sign.contains("X")
					? BowlingStatus.STRIKE
					: sign.contains("/")
							? BowlingStatus.SPARE
							: BowlingStatus.OPEN;
		}

		return getLastStatus(frame.getNextFrame());
	}
}
