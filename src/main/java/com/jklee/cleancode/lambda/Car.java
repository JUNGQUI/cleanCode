package com.jklee.cleancode.lambda;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder
@NoArgsConstructor
@AllArgsConstructor
public class Car {
	private String carName;
	private int movement;

	public Car move(MoveStrategy moveStrategy) {
		if (moveStrategy.isMovable()) {
			this.movement = this.movement+1;
		}

		return this;
	}
}
