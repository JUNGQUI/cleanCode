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

	public boolean matchName(String name) {
		return this.name.equals(name);
	}

	public static boolean ageIsInRange1(User user) {
		boolean isInRange = false;

		if (user != null && user.getAge() != null
				&& (user.getAge() >= 30
				&& user.getAge() <= 45)) {
			isInRange = true;
		}
		return isInRange;
	}

	public static boolean ageIsInRange2(User user) {
		Optional<User> optionalUser = Optional.ofNullable(user);
		return optionalUser.map(ou -> ou.getAge() != null && ou.getAge() >= 30 && ou.getAge() <= 45).orElse(false);
	}
}
