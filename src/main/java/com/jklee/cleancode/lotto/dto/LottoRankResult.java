package com.jklee.cleancode.lotto.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LottoRankResult {
	private Integer rank;
	private Integer winningCount;
}
