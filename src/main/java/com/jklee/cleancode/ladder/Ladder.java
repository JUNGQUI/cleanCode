package com.jklee.cleancode.ladder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class Ladder {

	public void makeLadder(String people, int count) {
		List<String> peoples = peopleSeparator(people);

		int maxLength = peoples.stream()
				.map(String::length)
				.max(Comparator.naturalOrder())
				.orElseThrow();

		List<String> results = ladderBuilder(peoples, maxLength, count);

		for (String result : results) {
			System.out.println(result);
		}
	}

	List<String> ladderBuilder(List<String> name, int maxLength, int count) {
		List<String> results = new ArrayList<>();

		List<String> ladderBone = Arrays.stream(
				"| ".repeat(name.size())
						.split(" "))
				.filter(Objects::nonNull)
				.collect(Collectors.toList());

		for (int i = 0; i < count; i++) {
			results.add(
					i == 0
							? ladderBuilderOnelineName(name, maxLength)
							: ladderBuilderOneline(ladderBone, maxLength)
			);
		}

		return results;
	}

	String ladderBuilderOneline(List<String> inputs, int maxLength) {
		AtomicBoolean flag = new AtomicBoolean(true);
		Random random = new Random();

		return reformatting(
				String.valueOf(
						inputs.stream()
								.map(
										input -> {
											int remainLength = maxLength - input.length();

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
									int remainLength = maxLength - input.length();
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
				.replace(",", "");
	}

}
