package com.jklee.cleancode.lotto.service;

import com.jklee.cleancode.lotto.dto.LottoNumber;
import com.jklee.cleancode.lotto.dto.LottoRankResult;
import com.jklee.cleancode.lotto.dto.LottoResult;
import com.jklee.cleancode.lotto.dto.LottoRankResultResponse;
import com.jklee.cleancode.lotto.util.LottoUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class LottoService {
	public LottoResult getLottos(int money) {
		LottoResult lottoResult = LottoResult.lottoResultBuilder().build();

		for (int i = 0; i < money; i++) {
			lottoResult.updateNumber(
					Collections.singletonList(
							new LottoNumber()
					)
			);
		}

		return lottoResult;
	}

	public LottoRankResultResponse checkLottos(LottoResult request) {
		LottoNumber weekLottoNumber = new LottoNumber();
		List<LottoRankResult> rankResults = new ArrayList<>();

		for (LottoNumber lottoNumber : request.getLottoNumbers()) {
			LottoRankResult result = LottoUtils.matchNumber(weekLottoNumber, lottoNumber);

			if (result != null) {
				rankResults.add(result);
			}
		}

		return LottoRankResultResponse
				.builder()
				.lottoRankResult(rankResults)
				.build();
	}
}
