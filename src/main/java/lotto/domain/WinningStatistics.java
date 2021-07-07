package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static lotto.domain.LottoTicketVendingMachine.TICKET_PRICE;

public class WinningStatistics {
    private final WinningNumbers winningNumbers;

    public WinningStatistics(WinningNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    private List<Integer> matchedCountList(List<LottoTicket> lottoTickets) {
        return lottoTickets.stream()
                .map(lottoTicket -> winningNumbers.matchedWinningNumberCount(lottoTicket))
                .collect(Collectors.toList());
    }

    public Map<Integer, Long> groupByWinningNumber(List<LottoTicket> lottoTickets) {
        List<Integer> matchedCounts = matchedCountList(lottoTickets);

        return matchedCounts.stream()
                .collect(Collectors.groupingBy(n -> n, HashMap::new, Collectors.counting()));
    }

    public float profitRate(int ticketAmount, int totalPrize) {
        return (float) totalPrize / (ticketAmount * TICKET_PRICE);
    }
}
