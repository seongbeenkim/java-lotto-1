package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.domain.LottoTicket.LOTTO_NUMBERS_COUNT;

public class ManualLottoNumbers {
    private final List<LottoNumber> lottoNumbers;

    public ManualLottoNumbers(final List<LottoNumber> lottoNumbers) {
        validateCountOf(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validateCountOf(final List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> deduplicatedLottoNumbers = new HashSet<>(lottoNumbers);

        if (deduplicatedLottoNumbers.size() != LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException("서로 다른 로또 번호가 6개여야 합니다.");
        }
    }

    public List<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }
}
