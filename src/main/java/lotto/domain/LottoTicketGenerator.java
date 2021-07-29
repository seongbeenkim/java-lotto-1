package lotto.domain;

import java.util.Collections;
import java.util.Comparator;
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

    public static LottoTickets createAutoTickets(final LottoTicketsCount lottoTicketsCount) {
        return new LottoTickets(IntStream.range(0, lottoTicketsCount.intValue())
                .mapToObj(i -> createAutoTicket())
                .collect(Collectors.toList()));
    }

    private static LottoTicket createAutoTicket() {
        Collections.shuffle(lottoNumbers);
        List<LottoNumber> lottoTicketNumbers = lottoNumbers.subList(0, LOTTO_NUMBERS_COUNT);
        lottoTicketNumbers.sort(Comparator.comparing(LottoNumber::value));
        return new LottoTicket(lottoTicketNumbers);
    }

    public static LottoTickets createManualTickets(List<List<LottoNumber>> manualLottoNumbers) {
        return new LottoTickets(manualLottoNumbers.stream()
                .map(LottoTicket::new)
                .collect(Collectors.toList()));
    }
}
