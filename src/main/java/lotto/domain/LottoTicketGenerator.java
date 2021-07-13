package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.LottoNumber.LOTTO_NUMBER_MAX_BOUND;
import static lotto.domain.LottoNumber.LOTTO_NUMBER_MIN_BOUND;
import static lotto.domain.LottoTicket.LOTTO_NUMBERS_COUNT;

public class LottoTicketGenerator {
    private static final List<LottoNumber> lottoNumbers = collectLottoNumbers();

    private static List<LottoNumber> collectLottoNumbers() {
        return IntStream.rangeClosed(LOTTO_NUMBER_MIN_BOUND, LOTTO_NUMBER_MAX_BOUND)
                .mapToObj(LottoNumber::valueOf)
                .collect(Collectors.toList());
    }

    private LottoTicketGenerator() {
    }

    public static LottoTicket autoTicket() {
        Collections.shuffle(lottoNumbers);
        return new LottoTicket(lottoNumbers.subList(0, LOTTO_NUMBERS_COUNT));
    }
}
