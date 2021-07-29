package lotto.domain.dto.request;

import lotto.domain.LottoNumber;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicketsRequest {
    private final List<List<LottoNumber>> lottoNumbers;

    public LottoTicketsRequest(final List<List<String>> lottoNumbersOfManualTickets) {
        this.lottoNumbers = convertToLottoNumber(lottoNumbersOfManualTickets);
    }

    private List<List<LottoNumber>> convertToLottoNumber(final List<List<String>> lottoNumbersOfManualTickets) {
        try {
            return lottoNumbersOfManualTickets.stream()
                    .map(LottoTicketsRequest::convert)
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

    public List<List<LottoNumber>> getManualLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }
}
