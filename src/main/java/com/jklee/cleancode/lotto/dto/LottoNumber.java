package com.jklee.cleancode.lotto.dto;

import com.jklee.cleancode.lotto.util.LottoUtils;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Getter
@Builder(builderMethodName = "lottoNumberBuilder")
@NoArgsConstructor
@AllArgsConstructor
public class LottoNumber {
	List<Integer> lottoNumber;

	public LottoNumber lottoBuilderManual(
			@NonNull List<Integer> lottoNumber
	) {
		LottoUtils.numberValidator(lottoNumber);

		return LottoNumber.lottoNumberBuilder().lottoNumber(lottoNumber).build();
	}

	public LottoNumber lottoBuilderAuto() {
		return LottoNumber.lottoNumberBuilder()
				.lottoNumber(
						LottoUtils.generateNumber()
				)
				.build();
	}
}
