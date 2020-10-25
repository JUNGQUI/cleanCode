package com.jklee.cleancode.lotto.dto;

import com.jklee.cleancode.lotto.util.LottoUtils;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LottoNumberTest {

	@Test
	public void createNumberTest() {
		List<Integer> numbers1 = LottoUtils.generateNumber();
		List<Integer> numbers2 = LottoUtils.generateNumber();
		List<Integer> numbers3 = LottoUtils.generateNumber();
		List<Integer> numbers4 = LottoUtils.generateNumber();
		List<Integer> numbers5 = LottoUtils.generateNumber();
		List<Integer> numbers6 = LottoUtils.generateNumber();
		List<Integer> numbers7 = LottoUtils.generateNumber();

		System.out.println("J Tag");
	}

	@Test
	public void lottoNumberValidationTest() {
		LottoUtils.numberValidator(LottoUtils.generateNumber());
		LottoUtils.numberValidator(Collections.singletonList(1));
	}
}