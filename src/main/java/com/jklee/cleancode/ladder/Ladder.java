package com.jklee.cleancode.ladder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class Ladder {

	public List<String> makeLadder(List<String> peoples, List<String> results, int count) {

		int maxLength = peoples.stream()
				.map(String::length)
				.max(Comparator.naturalOrder())
				.orElseThrow();

		return ladderBuilder(peoples, results, maxLength, count);
	}

	public String playLadder(String condition, List<String> peoples, List<String> result, List<String> ladder) {
		int idx = findIndex(condition, peoples);

		if ("all".equals(condition)) {
			return forwardLadderForAll(ladder, peoples, result);
		}

		return result.get(forwardLadder(ladder, idx));
	}

	int findIndex(String condition, List<String> peoples) {
		int idx = -1;
		int i = 0;

		for (String people : peoples) {
			idx = people.equals(condition) ? i : idx;
			i++;
		}

		return idx;
	}

	List<String> ladderBuilder(List<String> name, List<String> result, int maxLength, int count) {
		List<String> results = new ArrayList<>();

		List<String> ladderBone = Arrays.stream(
				"|,".repeat(name.size())
						.split(","))
				.filter(Objects::nonNull)
				.collect(Collectors.toList());

		for (int i = 0; i < count; i++) {
			results.add(
					i == 0
							? ladderBuilderOnelineName(name, maxLength)
							: i == count - 1
									? ladderBuilderOnelineName(result, maxLength)
									: ladderBuilderOneline(ladderBone, maxLength)
			);
		}

		return results;
	}

	String forwardLadderForAll(List<String> ladders, List<String> peoples, List<String> results) {
		AtomicInteger i = new AtomicInteger();

		return reformatting(
				String.valueOf(
						peoples.stream()
								.map(people -> {
									String result = people + " : " + results.get(forwardLadder(ladders, i.get())) + " ";
									i.getAndIncrement();
									return result;
								})
								.collect(Collectors.toList())
				)
		);
	}

	int forwardLadder(List<String> ladders, int index) {
		for (String ladder: ladders) {
			List<String> onelineLadder = Arrays.asList(ladder.split("\\|"));

			if (onelineLadder.size() == 1) continue;

			String leftLadder = index < 0 ? "" : onelineLadder.get(index);
			String rightLadder = index+1 >= onelineLadder.size() ? "" : onelineLadder.get(index+1);

			index = goLadderOneline(leftLadder, rightLadder, index);
		}

		return index;
	}

	int goLadderOneline(String leftLadder, String rightLadder, int startIdx) {
		return leftLadder.contains("-")
				? startIdx - 1
				: rightLadder.contains("-")
						? startIdx + 1 : startIdx;
	}

	String ladderBuilderOneline(List<String> inputs, int maxLength) {
		AtomicBoolean flag = new AtomicBoolean(true);
		Random random = new Random();

		return reformatting(
				String.valueOf(inputs.stream()
						.map(
								input -> {
									int remainLength = maxLength - input.length() + 1;

									if (flag.get()) {
										flag.set(false);
										return " ".repeat(remainLength) + input;
									}

									if (random.nextInt(100) % 2 == 0) {
										flag.set(true);
										return "-".repeat(remainLength) + input;
									}

									return " ".repeat(remainLength) + input;
								})
						.collect(Collectors.toList())
				)
		);
	}

	String ladderBuilderOnelineName(List<String> inputs, int maxLength) {
		return reformatting(
				String.valueOf(inputs.stream()
						.map(
								input -> {
									int remainLength = maxLength - input.length() + 1;
									return " ".repeat(remainLength) + input;
								})
						.collect(Collectors.toList())
				)
		);
	}

	List<String> peopleSeparator(String people) {
		return Arrays.stream(people.split(","))
				.map(name -> name.replace(",", ""))
				.collect(Collectors.toList());
	}

	String reformatting(String needReform) {
		return needReform
				.replace("[", "")
				.replace("]", "")
				.replace(", ", "");
	}

}
