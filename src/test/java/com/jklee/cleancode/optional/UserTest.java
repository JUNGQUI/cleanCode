package com.jklee.cleancode.optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserTest {
	@Test
	public void whenFiltersWithoutOptional_thenCorrect() {
		Assertions.assertTrue(User.ageIsInRange1(new User("crong", 35)));
		Assertions.assertFalse(User.ageIsInRange1(new User("crong", 48)));
		Assertions.assertFalse(User.ageIsInRange1(new User("crong", null)));
		Assertions.assertFalse(User.ageIsInRange1(new User("crong", 29)));
		Assertions.assertFalse(User.ageIsInRange1(null));
	}

	@Test
	public void whenFiltersWithOptional_thenCorrect() {
		Assertions.assertTrue(User.ageIsInRange2(new User("crong", 35)));
		Assertions.assertFalse(User.ageIsInRange2(new User("crong", 48)));
		Assertions.assertFalse(User.ageIsInRange2(new User("crong", null)));
		Assertions.assertFalse(User.ageIsInRange2(new User("crong", 29)));
		Assertions.assertFalse(User.ageIsInRange2(null));
	}
}