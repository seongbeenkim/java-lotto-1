package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.LottoRank;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.domain.NumberOfTickets;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    private OutputView() {
    }

    public static void printNumberOfTickets(NumberOfTickets numberOfTickets) {
        System.out.printf("%d개를 구매했습니다.", numberOfTickets.value());
    }

    public static void printLottoTickets(LottoTickets lottoTickets) {
        lottoTickets.list()
                .stream()
                .map(LottoTicket::lottoNumbers)
                .forEach(OutputView::printLottoTicket);
        System.out.println();
    }

    private static void printLottoTicket(List<LottoNumber> lottoNumbers) {
        System.out.println();

        String result = lottoNumbers.stream()
                .mapToInt(LottoNumber::value)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.printf("[" + "%s" + "]", result);
    }

    public static void printWinningStatistics(Map<LottoRank, Integer> ranksCount) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        ranksCount.entrySet()
                .forEach(OutputView::printWinningStatistic);
    }

    private static void printWinningStatistic(Map.Entry<LottoRank, Integer> rank) {
        if (rank.getKey().equals(LottoRank.SECOND)) {
            System.out.printf("%d개 일치, 보너스 볼 일치(%d원) - %d개 \n", rank.getKey().matchedCount(), rank.getKey().prize(), rank.getValue());
            return;
        }

        System.out.printf("%d개 일치 (%d원)- %d개 \n", rank.getKey().matchedCount(), rank.getKey().prize(), rank.getValue());
    }
}
