package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    public LottoTickets(final List<LottoTicket> lottoTickets) {
        this.lottoTickets = new ArrayList<>(lottoTickets);
    }

    public List<LottoTicket> list() {
        return Collections.unmodifiableList(lottoTickets);
    }

    public List<LottoResult> match(final WinningNumbers winningNumbers) {
        return lottoTickets.stream()
                .map(winningNumbers::match)
                .filter(lottoResult -> lottoResult.matchedCount() >= LottoRank.FIFTH.matchedCount())
                .collect(Collectors.toList());
    }
}
