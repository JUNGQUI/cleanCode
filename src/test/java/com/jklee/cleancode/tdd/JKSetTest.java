package com.jklee.cleancode.tdd;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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

	@DisplayName("set 으로 전달받은 값이 있는지 확인하라.")
	@ParameterizedTest
	@CsvSource(value = {"test:test", "tEst:test", "Java:java"}, delimiter = ':')
	public boolean setContainsValueByParam(String input, String input_2) {
		return true;
	}
}
