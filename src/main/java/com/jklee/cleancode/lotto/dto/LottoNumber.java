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
public class LottoNumber {
	List<Integer> lottoNumber;

	public LottoNumber() {
		this.lottoNumber = LottoUtils.generateNumber();
	}

	public LottoNumber lottoBuilderManual(
			@NonNull List<Integer> lottoNumber
	) {
		LottoUtils.numberValidator(lottoNumber);

		return LottoNumber.lottoNumberBuilder()
				.lottoNumber(lottoNumber)
				.build();
	}
}
