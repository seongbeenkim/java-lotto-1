package lotto.view;

import lotto.domain.dto.LottoNumbersResponse;
import lotto.domain.dto.LottoRankResponse;
import lotto.domain.dto.LottoTicketsResponse;
import lotto.domain.dto.NumberOfTicketsResponse;
import lotto.domain.dto.WinningStatisticsResponse;

import java.util.stream.Collectors;

public class OutputView {

    private OutputView() {
    }

    public static void printNumberOfTickets(final NumberOfTicketsResponse numberOfTicketsResponse) {
        System.out.printf("%d개를 구매했습니다.", numberOfTicketsResponse.getNumberOfTickets());
    }

    public static void printLottoTickets(final LottoTicketsResponse lottoTicketsResponse) {
        lottoTicketsResponse.list()
                .forEach(OutputView::printLottoTicket);
        System.out.println();
    }

    private static void printLottoTicket(final LottoNumbersResponse lottoNumbersResponse) {
        System.out.println();

        String result = lottoNumbersResponse.list()
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.printf("[" + "%s" + "]", result);
    }

    public static void printWinningStatistics(final WinningStatisticsResponse winningStatisticsResponse) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        winningStatisticsResponse.list()
                .forEach(OutputView::printWinningStatistic);

        System.out.printf("총 수익률은 %.2f입니다.", winningStatisticsResponse.getProfit());
    }

    private static void printWinningStatistic(final LottoRankResponse rankResponse) {
        if (rankResponse.hasBouns()) {
            System.out.printf("%d개 일치, 보너스 볼 일치(%d원) - %d개 \n", rankResponse.getMatchedLottoNumbersCount(), rankResponse.getTotalPrize(), rankResponse.getMatchedRankCount());
            return;
        }

        System.out.printf("%d개 일치 (%d원)- %d개 \n", rankResponse.getMatchedLottoNumbersCount(), rankResponse.getTotalPrize(), rankResponse.getMatchedRankCount());
    }
}
