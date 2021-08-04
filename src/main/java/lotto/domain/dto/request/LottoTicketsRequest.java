package lotto.domain.dto.request;

import lotto.domain.number.LottoNumber;
import lotto.domain.number.ManualLottoNumbers;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicketsRequest {
    private final List<ManualLottoNumbers> lottoNumbers;

    public LottoTicketsRequest(final List<List<String>> lottoNumbersOfManualTickets) {
        this.lottoNumbers = convertToLottoNumber(lottoNumbersOfManualTickets);
    }

    private List<ManualLottoNumbers> convertToLottoNumber(final List<List<String>> lottoNumbersOfManualTickets) {
        try {
            return lottoNumbersOfManualTickets.stream()
                    .map(LottoTicketsRequest::convert)
                    .map(ManualLottoNumbers::new)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("로또 번호는 모두 정수 타입이여야 합니다.");
        }
    }

    private static List<LottoNumber> convert(List<String> lottoNumbers) {
        return lottoNumbers.stream()
                .map(Integer::parseInt)
                .map(LottoNumber::valueOf)
                .collect(Collectors.toList());
    }

    public List<ManualLottoNumbers> getManualLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }
}
