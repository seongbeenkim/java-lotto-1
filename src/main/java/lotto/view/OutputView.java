package lotto.view;

import lotto.domain.LottoTicket;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public static void printLottoTickets(List<LottoTicket> lottoTickets) {
        for (LottoTicket lottoTicket : lottoTickets) {
            List<String> lottoNumbers = lottoNumberToString(lottoTicket);
            System.out.println("[" + String.join(",", lottoNumbers) + "]");
        }
    }

    private static List<String> lottoNumberToString(LottoTicket lottoTicket) {
        List<String> lottoNumbers = lottoTicket.lottoNumbers().stream()
                .map(lottoNumber -> String.valueOf(lottoNumber.value()))
                .collect(Collectors.toList());
        return lottoNumbers;
    }

    public static void printTicketAmount(int ticketAmount) {
        System.out.println(String.format("%s개를 구매했습니다.", ticketAmount));
    }

    public static void printProfitRate(float profitRate) {
        System.out.println(String.format("총 수익률은 %.2f입니다.", profitRate));
    }

    public static void printWinningStatistics(int matchedWinningNumbers, boolean matchedBonusNumber, int prize, int matchedTicketCount) {
        if (matchedBonusNumber) {
            String.format("%d개 일치, 보너스 볼 일치 (%d원) - %개", matchedWinningNumbers, prize, matchedTicketCount);
        }
        String.format("%d개 일치 (%d원) - %개", matchedWinningNumbers, prize, matchedTicketCount);
    }
}
