package com.jklee.cleancode.lotto.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LottoRankResultResponse {
	private List<LottoRankResult> lottoRankResult;
}
