package com.jklee.cleancode.lotto.controller;

import com.jklee.cleancode.lotto.dto.LottoRankResultResponse;
import com.jklee.cleancode.lotto.dto.LottoResult;
import com.jklee.cleancode.lotto.service.LottoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LottoController {
	private final LottoService lottoService;

	@GetMapping(value = "/get")
	public LottoResult getLotto(int money) {
		money = money/1000;

		return lottoService.getLottos(money);
	}

	@PostMapping(value = "/check")
	public LottoRankResultResponse checkLotto(LottoResult request) {
		return lottoService.checkLottos(request);
	}
}
