package lotto.view;

import lotto.domain.dto.response.LottoTicketsCountResponse;
import lotto.domain.dto.response.LottoTicketsResponse;
import lotto.domain.dto.response.WinningStatisticsResponse;

public interface OutputView {
    void printNumberOfTickets(LottoTicketsCountResponse lottoTicketsCountResponse);

    void printLottoTickets(LottoTicketsResponse lottoTicketsResponse);

    void printWinningStatistics(WinningStatisticsResponse winningStatisticsResponse);
}
