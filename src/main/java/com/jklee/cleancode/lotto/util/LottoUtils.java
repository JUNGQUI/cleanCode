package com.jklee.cleancode.lotto.util;

import com.jklee.cleancode.lotto.dto.LottoNumber;
import com.jklee.cleancode.lotto.dto.LottoRankResult;
import com.jklee.cleancode.lotto.exception.LottoException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import lombok.experimental.UtilityClass;

@UtilityClass
public class LottoUtils {
	private final List<Integer> number = Arrays.asList(
			1, 2, 3, 4, 5, 6, 7, 8, 9,
			10, 11, 12, 13, 14, 15, 16, 17, 18, 19,
			20, 21, 22, 23, 24, 25, 26, 27, 28, 29,
			30, 31, 32, 33, 34, 35, 36, 37, 38, 39,
			40, 41, 42, 43, 44, 45
	);

	public void numberValidator(List<Integer> numbers) {
		if (numbers == null || numbers.size() != 6) {
			throw new LottoException("로또 번호가 올바르지 않습니다.");
		}
	}

	public LottoRankResult matchNumber (LottoNumber week, LottoNumber request) {
		int match = 0;

		for (int i = 0; i < 6; i++) {
			if (week.getLottoNumber().get(i).equals(
					request.getLottoNumber().get(i))) {
				match++;
			}
		}

		if (ranking(match) == 0) {
			return null;
		}

		return LottoRankResult.builder()
				.rank(ranking(match))
				.winningCount(1)
				.build();
	}

	public List<Integer> generateNumber() {
		Collections.shuffle(number, new Random());

		List<Integer> result = new ArrayList<>(
				number.subList(0, 6)
		);

		Collections.sort(result);

		return result;
	}

	private Integer ranking(int match) {
		int rank = 7-match;

		if (rank > 3) {
			return 0;
		}

		return rank;
	}
}
