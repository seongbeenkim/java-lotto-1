package lotto.view;

import lotto.domain.dto.response.LottoTicketsResponse;
import lotto.domain.dto.response.NumberOfTicketsResponse;
import lotto.domain.dto.response.WinningStatisticsResponse;

public interface OutputView {
    void printNumberOfTickets(NumberOfTicketsResponse numberOfTicketsResponse);

    void printLottoTickets(LottoTicketsResponse lottoTicketsResponse);

    void printWinningStatistics(WinningStatisticsResponse winningStatisticsResponse);
}
