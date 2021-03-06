package com.jklee.cleancode.ladder;

import static com.jklee.cleancode.ladder.LadderUtil.generatePoint;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class LadderLine {
	private final List<Point> points;

	public LadderLine(List<Point> points) {
		this.points = points;
	}

	public int move(int position) {
		return points.get(position).move();
	}

	public static LadderLine init(int sizeOfPerson) {
		List<Point> points = new ArrayList<>();
		Point point = initFirst(points);
		point = initBody(sizeOfPerson, points, point);
		initLast(points, point);
		return new LadderLine(points);
	}

	private static Point initBody(int sizeOfPerson, List<Point> points, Point point) {
		for (int i = 1; i < sizeOfPerson - 1; i++) {
			point = point.next();
			points.add(point);
		}
		return point;
	}

	private static void initLast(List<Point> points, Point point) {
		point = point.last();
		points.add(point);
	}

	private static Point initFirst(List<Point> points) {
		Point point = Point.first(generatePoint());
		points.add(point);
		return point;
	}

	@Override
	public String toString() {
		return "LadderLine{" +
				"points=" + points +
				'}';
	}
}
