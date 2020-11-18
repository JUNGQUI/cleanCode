package com.jklee.cleancode.ladder;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LadderTest {

	@Autowired private Ladder ladder;

	private final List<String> peoples = new ArrayList<>();
	private final List<String> results = new ArrayList<>();

	@BeforeEach
	void setup() {
		peoples.add("poo");
		peoples.add("JK");
		peoples.add("Crong");
		peoples.add("Meai");

		results.add("1등");
		results.add("2등");
		results.add("3등");
		results.add("4등");
	}

	@Test
	void makeLadderTest() {
		List<String> ladderResult = ladder.makeLadder(peoples, results, 5);

		for (String ladders : ladderResult) {
			System.out.println(ladders);
		}
	}

	@Test
	void makeAndPlayLadderTest() {
		List<String> ladderResult = ladder.makeLadder(peoples, results, 5);

		for (String ladders : ladderResult) {
			System.out.println(ladders);
		}

		System.out.println(
				ladder.playLadder(
						"JK",
						peoples,
						results,
						ladderResult)
		);

		System.out.println(
				ladder.playLadder(
						"all",
						peoples,
						results,
						ladderResult)
		);
	}

	@Test
	void LadderLineInit() {
		List<LadderLine> ladderLines = new ArrayList<>();

		for (int i = 0; i < 15; i++) {
			ladderLines.add(LadderLine.init(peoples.size()));
		}

		System.out.println("J Tag");
	}

	@Test
	void LadderLineTest() {
		int count = 15;
		int maxLength = peoples.stream()
				.map(String::length)
				.max(Integer::compareTo)
				.orElseThrow();

		List<LadderLine> ladderLines = ladder.makeLadderRefactoring(peoples.size(), count);;

		ladder.ladderBuilderRefactoring(peoples, results, ladderLines, maxLength, count);

		System.out.println(
				ladder.playLadderRefactoring("all", peoples, results, ladderLines)
		);


		System.out.println(
				ladder.playLadderRefactoring("poo", peoples, results, ladderLines)
		);
	}
}