package lotto.view;

import lotto.controller.dto.response.LottoTicketsCountResponse;
import lotto.controller.dto.response.LottoTicketsResponse;
import lotto.controller.dto.response.WinningStatisticsResponse;

public interface OutputView {
    void printLottoTicketsCount(LottoTicketsCountResponse lottoTicketsCountResponse);

    void printLottoTickets(LottoTicketsResponse lottoTicketsResponse);

    void printWinningStatistics(WinningStatisticsResponse winningStatisticsResponse);
}
