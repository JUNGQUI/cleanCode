package com.jklee.cleancode.optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UsersTest {
	@Test
	public void getUser() {
		Users users = new Users();
		Assertions.assertEquals(
				users.getUser("crong"),
				new Users("crong", 35)
		);
	}


	@Test
	public void getDefaultUser() {
		Users users = new Users();
		Assertions.assertEquals(
				users.getUser("codesquard"),
				Users.DEFAULT_USER
		);
	}
}