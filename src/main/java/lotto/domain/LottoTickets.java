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

    public List<LottoResult> match(WinningNumbers winningNumbers) {
        return lottoTickets.stream()
                .map(winningNumbers::match)
                .filter(lottoResult -> lottoResult.matchedCount() >= 3)
                .collect(Collectors.toList());
    }
}
