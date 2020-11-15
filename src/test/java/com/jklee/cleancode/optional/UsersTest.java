package com.jklee.cleancode.optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UsersTest {
	@Test
	public void getUser() {
		Users users = new Users();
		Assertions.assertEquals(users.getUser("crong"), new User("crong", 35));
		Assertions.assertEquals(users.getUserWithOptional("crong"), new User("crong", 35));
	}


	@Test
	public void getDefaultUser() {
		Users users = new Users();
		Assertions.assertEquals(users.getUser("codesquard"), Users.DEFAULT_USER);
		Assertions.assertEquals(users.getUserWithOptional("codesquard"), Users.DEFAULT_USER);
	}
}
