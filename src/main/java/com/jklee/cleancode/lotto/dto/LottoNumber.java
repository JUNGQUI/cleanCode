package com.jklee.cleancode.lotto.dto;

import com.jklee.cleancode.lotto.exception.LottoException;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder(builderMethodName = "lottoNumberBuilder")
@NoArgsConstructor
@AllArgsConstructor
public class LottoNumber {
	List<String> lottoNumber;

	public void numberValidator() {
		if (this.lottoNumber == null || this.lottoNumber.size() != 6) {
			throw new LottoException("로또 번호가 올바르지 않습니다.");
		}
	}
}
