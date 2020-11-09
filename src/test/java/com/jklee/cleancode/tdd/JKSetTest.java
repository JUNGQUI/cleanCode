package com.jklee.cleancode.tdd;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JKSetTest {

	private Set<Integer> numbers;

	@BeforeEach
	void setUp() {
		numbers = new HashSet<>();
		numbers.add(1);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
	}

	// Test Case 구현

	@DisplayName("set 의 size 를 확인하라.")
	@Test
	public void checkSetSize() {
		Assertions.assertEquals(3, numbers.size());
	}

	@DisplayName("set 으로 1, 2, 3 값이 있는지 확인하라.")
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	public void setContainsValue(int input) {
		Assertions.assertTrue(numbers.contains(input));
	}

//	@MethodSource("generateData")
	@DisplayName("set 으로 전달받은 값이 있는지 확인하라.")
	@ParameterizedTest
	@CsvSource(value = {"1,2,3", "4,5,"}, delimiter = ',')
	public void setContainsValueWithParam(
			Integer first,
			Integer second,
			Integer third) {
		List<Integer> inputs = new ArrayList<>();
		inputs.add(first);
		inputs.add(second);
		inputs.add(third);

		Assertions.assertTrue(numbers.containsAll(inputs));
	}

	static Stream<Arguments> generateData() {
		return Stream.of(
				Arguments.of(1, 2, 3),
				Arguments.of(4, 5)
		);
	}
}
