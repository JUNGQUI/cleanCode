package com.jklee.cleancode.ladder;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LadderTest {

	@Autowired private Ladder ladder;

	@Test
	void makeLadderTest() {
		ladder.makeLadder("poo,JK,Crong,Meai", 5);
	}
}