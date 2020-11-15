package com.jklee.cleancode.optional;

import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
	private String name;
	private Integer age;

	public static boolean ageIsInRange1(User user) {
		return user != null && user.getAge() != null && (user.getAge() >= 30 && user.getAge() <= 45);
	}

	public static boolean ageIsInRange2(User user) {
		Optional<User> optionalUser = Optional.ofNullable(user);
		return optionalUser.map(ou -> ou.getAge() != null && ou.getAge() >= 30 && ou.getAge() <= 45).orElse(false);
	}

	public static final User DEFAULT_USER = User.builder()
			.name("codesquard")
			.age(30)
			.build();
}
