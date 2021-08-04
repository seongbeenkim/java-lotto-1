package lotto.view;

import lotto.domain.dto.response.LottoTicketsCountResponse;
import lotto.domain.dto.response.LottoTicketsResponse;
import lotto.domain.dto.response.WinningStatisticsResponse;

public interface OutputView {
    void printLottoTicketsCount(LottoTicketsCountResponse lottoTicketsCountResponse);

    void printLottoTickets(LottoTicketsResponse lottoTicketsResponse);

    void printWinningStatistics(WinningStatisticsResponse winningStatisticsResponse);
}
