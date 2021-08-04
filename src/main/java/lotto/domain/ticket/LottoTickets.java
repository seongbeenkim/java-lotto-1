package lotto.domain.ticket;

import lotto.domain.number.WinningNumbers;
import lotto.domain.result.LottoResults;
import lotto.enums.LottoRank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    public LottoTickets(final LottoTickets manualTickets, final LottoTickets autoTickets) {
        this(merge(manualTickets, autoTickets));
    }

    private static List<LottoTicket> merge(final LottoTickets manualTickets, final LottoTickets autoTickets) {
        List<LottoTicket> lottoTickets = new ArrayList<>(manualTickets.lottoTickets);
        lottoTickets.addAll(autoTickets.lottoTickets);
        return lottoTickets;
    }

    public LottoTickets(final List<LottoTicket> lottoTickets) {
        this.lottoTickets = new ArrayList<>(lottoTickets);
    }

    public List<LottoTicket> list() {
        return Collections.unmodifiableList(lottoTickets);
    }

    public LottoResults match(final WinningNumbers winningNumbers) {
        return new LottoResults(lottoTickets.stream()
                .map(winningNumbers::match)
                .filter(lottoResult -> lottoResult.getMatchedCount() >= LottoRank.FIFTH.getMatchedCount())
                .collect(Collectors.toList()));
    }
}
