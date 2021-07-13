package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoTicket {
    static final int LOTTO_TICKET_PRICE = 1000;
    static final int LOTTO_NUMBERS_COUNT = 6;

    private final List<LottoNumber> lottoNumbers;

    public LottoTicket(final List<LottoNumber> lottoNumbers) {
        validateCountOf(lottoNumbers);
        this.lottoNumbers = new ArrayList<>(lottoNumbers);
    }

    private void validateCountOf(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> deduplicatedLottoNumbers = new HashSet<>(lottoNumbers);

        if (deduplicatedLottoNumbers.size() != LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException("서로 다른 로또 번호가 6개여야 합니다.");
        }
    }

    public List<LottoNumber> lottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }
}