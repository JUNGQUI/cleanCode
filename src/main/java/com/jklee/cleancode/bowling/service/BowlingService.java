package com.jklee.cleancode.bowling.service;

import com.jklee.cleancode.bowling.BowlingPoint;
import com.jklee.cleancode.bowling.BowlingStatus;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class BowlingService {
	public void drawTable(String name, List<BowlingPoint> bowlingPoints) {
		System.out.println(drawHeader(bowlingPoints.get(9).getStatus()));
		System.out.println(drawPoint(name, bowlingPoints));
	}

	private String drawHeader(BowlingStatus bowlingStatus) {
		String header = "| NAME |  01  |  02  |  03  |  04  |  05  |  06  |  07  |  08  |  09  |  10  |";

		if (BowlingStatus.STRIKE.equals(bowlingStatus) ||
				BowlingStatus.SPARE.equals(bowlingStatus)) {
			header += "  11  |";
		}

		return header;
	}

	private String drawPoint(String name, List<BowlingPoint> bowlingPoints) {
		StringBuilder content = new StringBuilder("|  " + name + " |");
		int emptyContent = 10 - bowlingPoints.size();

		for (BowlingPoint bowlingPoint : bowlingPoints) {
			content.append("  ")
					.append(
							bowlingPoint.getPoint()
					).append(
							" ".repeat(
									4-bowlingPoint.getPoint().length()
							)
			)
					.append("|");
		}

		content.append("      |".repeat(Math.max(0, emptyContent)));

		return content.toString();
	}
}
