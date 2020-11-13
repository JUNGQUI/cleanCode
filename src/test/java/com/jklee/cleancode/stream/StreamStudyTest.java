package com.jklee.cleancode.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StreamStudyTest {

	List<Integer> numbers = Arrays.asList(1, 3, 4, 5, 6, 2, 1, 3, 9);

	@DisplayName("실습 1 : 3보다 큰 숫자를 2배하여 합을 구한다.")
	@Test
	void sumOverThreeAndDouble() {
		int result = 0;

		for (int number : numbers) {
			result += number >= 3 ? number : 0;
		}

		Assertions.assertEquals(
				result, numbers.stream()
						.mapToInt(number -> number >= 3 ? number : 0)
						.sum()
		);
	}

	@Nested
	@DisplayName("실습 2 : 문자열에서 단어를 12자 이상, 내림차순, 100개 정렬 ")
	class PrintLongestWordTop100 {
		final List<String> words = printLongestWordTop100();

		List<String> printLongestWordTop100() {
			List<String> words = buildWords();

			return words.stream()
					.filter(word -> word.length() >= 12)
					.sorted(Comparator.comparing(String::length).reversed())
					.distinct()
					.map(String::toLowerCase)
					.collect(Collectors.toList());
		}

		@Nested
		@TestMethodOrder(OrderAnnotation.class)
		@DisplayName("조건을 충족하는지 검증한다. ")
		class Validate {

			@Test
			@Order(1)
			@DisplayName("12자 이상의 단어인지, ")
			void check12Length() {
				Assertions.assertEquals(
						words.size(),
						words.stream()
								.filter(word -> word.length() >= 12)
								.count()
				);
			}

			@Test
			@Order(2)
			@DisplayName("내림차순인지, ")
			void checkDesc() {
				int maximum = 100;
				for (String word : words) {
					if (maximum < word.length()) {
						throw new RuntimeException("내림차순이 아니다.");
					}

					maximum = word.length();
				}
			}

			@Test
			@Order(3)
			@DisplayName("100개 정렬인지 확인한다.")
			void check100Count() {
				Assertions.assertTrue(words.size() >= 100);
			}
		}

		List<String> buildWords() {
			Random random = new Random();
			List<String> words = new ArrayList<>();

			for (int i = 0; i < 200; i++) {
				words.add(
						UUID.randomUUID()
								.toString()
								.replaceAll("-", "")
								.substring(0, random.nextInt(30))
				);
			}

			return words;
		}
	}
}