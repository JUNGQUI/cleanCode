package com.jklee.cleancode.lotto.service;

import com.jklee.cleancode.lotto.dto.LottoNumber;
import com.jklee.cleancode.lotto.dto.LottoRankResult;
import com.jklee.cleancode.lotto.dto.LottoRankResultResponse;
import com.jklee.cleancode.lotto.dto.LottoResult;
import com.jklee.cleancode.lotto.util.LottoUtils;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LottoServiceTest {

	@Autowired private LottoService lottoService;

	@Test
	public void testCheckNumber() {
		List<LottoNumber> lottoNumbers = new ArrayList<>();

		for (int i = 0; i < 500000; i++) {
			lottoNumbers.add(LottoNumber
					.lottoNumberBuilder()
					.lottoNumber(LottoUtils.generateNumber())
					.build()
			);
		}

		LottoResult lottoResult = LottoResult
				.lottoResultBuilder()
				.lottoNumbers(lottoNumbers)
				.build();

		LottoRankResultResponse lottoRankResultResponse = lottoService.checkLottos(lottoResult);

		System.out.println("J Tag");
	}
}