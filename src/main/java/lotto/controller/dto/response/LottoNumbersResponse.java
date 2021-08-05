package lotto.controller.dto.response;

import lotto.domain.number.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbersResponse {
    private final List<LottoNumber> lottoNumbers;

    public LottoNumbersResponse(final List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = new ArrayList<>(lottoNumbers);
    }

    public List<Integer> list() {
        return Collections.unmodifiableList(lottoNumbers.stream()
                .map(LottoNumber::value)
                .collect(Collectors.toList()));
    }
}
