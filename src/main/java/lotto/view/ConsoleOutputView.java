package lotto.view;

import lotto.controller.dto.response.LottoNumbersResponse;
import lotto.controller.dto.response.LottoRankResponse;
import lotto.controller.dto.response.LottoTicketsCountResponse;
import lotto.controller.dto.response.LottoTicketsResponse;
import lotto.controller.dto.response.WinningStatisticsResponse;

import java.util.stream.Collectors;

public class ConsoleOutputView implements OutputView{

    @Override
    public void printLottoTicketsCount(final LottoTicketsCountResponse lottoTicketsCountResponse) {
        System.out.printf("수동으로 %d장, 자동으로 %d장을 구매했습니다.", lottoTicketsCountResponse.getManualTicketsCount(), lottoTicketsCountResponse.getAutoTicketsCount());
    }

    @Override
    public void printLottoTickets(final LottoTicketsResponse lottoTicketsResponse) {
        lottoTicketsResponse.list()
                .forEach(this::printLottoTicket);
        System.out.println();
    }

    private void printLottoTicket(final LottoNumbersResponse lottoNumbersResponse) {
        System.out.println();

        String result = lottoNumbersResponse.list()
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.printf("[" + "%s" + "]", result);
    }

    @Override
    public void printWinningStatistics(final WinningStatisticsResponse winningStatisticsResponse) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        winningStatisticsResponse.list()
                .forEach(this::printWinningStatistic);

        System.out.printf("총 수익률은 %.2f입니다.", winningStatisticsResponse.getProfit());
    }

    private void printWinningStatistic(final LottoRankResponse rankResponse) {
        if (rankResponse.hasBouns()) {
            System.out.printf("%d개 일치, 보너스 볼 일치(%d원) - %d개 %n", rankResponse.getMatchedLottoNumbersCount(), rankResponse.getPrize(), rankResponse.getMatchedRankCount());
            return;
        }

        System.out.printf("%d개 일치 (%d원)- %d개 %n", rankResponse.getMatchedLottoNumbersCount(), rankResponse.getPrize(), rankResponse.getMatchedRankCount());
    }
}
