package lotto.controller.dto.response;

import lotto.domain.ticket.LottoTicket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicketsResponse {
    private final List<LottoTicket> lottoTickets;

    public LottoTicketsResponse(final List<LottoTicket> lottoTickets) {
        this.lottoTickets = new ArrayList<>(lottoTickets);
    }

    public List<LottoNumbersResponse> list() {
        return Collections.unmodifiableList(lottoTickets.stream()
                .map(LottoTicket::getLottoNumbers)
                .map(LottoNumbersResponse::new)
                .collect(Collectors.toList()));
    }
}
