package com.jklee.cleancode.ladder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
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
					ladderBuilderOneline(i == 0 ? name : ladderBone, maxLength, i == 0)
			);
		}

		return results;
	}

	String ladderBuilderOneline(List<String> inputs, int maxLength, boolean flag) {
		String obj = flag ? " " : "-";
		return String.valueOf(inputs.stream()
				.map(
						input -> {
							int remainLength = maxLength - input.length();
							return obj.repeat(remainLength) + input;
						})
				.collect(Collectors.toList()))
				.replace("[", "")
				.replace("]", "")
				.replace(",", "");
	}

	List<String> peopleSeparator(String people) {
		return Arrays.stream(people.split(","))
				.map(name -> name.replace(",", ""))
				.collect(Collectors.toList());
	}

	String makeBlankOrLine(boolean flag, int maxLength) {
		return (flag ? " " : "-").repeat(Math.max(0, maxLength));
	}
}
