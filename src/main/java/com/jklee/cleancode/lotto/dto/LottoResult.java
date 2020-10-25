package com.jklee.cleancode.lotto.dto;

import com.jklee.cleancode.lotto.exception.LottoException;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder(builderMethodName = "lottoResultBuilder")
@NoArgsConstructor
@AllArgsConstructor
public class LottoResult {
	private List<LottoNumber> lottoNumbers;

	private void numbersValidator() {
		if (this.lottoNumbers == null || this.lottoNumbers.isEmpty()) {
			throw new LottoException("기존 번호가 없어 업데이트가 불가능합니다.");
		}
	}

	public void updateNumber(List<LottoNumber> lottoNumbers) {
		this.numbersValidator();
		this.lottoNumbers.addAll(lottoNumbers);
	}
}
