package com.jklee.cleancode.optional;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder
@NoArgsConstructor
@AllArgsConstructor
public class Users {
	private String name;
	private int age;

	public Users getUser(String name) {
		return Users.builder()
				.name(name)
				.age(35)
				.build();
	}

	public static final Users DEFAULT_USER = Users.builder()
			.name("codesquard")
			.age(30)
			.build();
}
