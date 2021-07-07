package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static lotto.domain.LottoTicketVendingMachine.TICKET_PRICE;

public class WinningStatistics {
    private final WinningNumbers winningNumbers;
    private final Map<LottoPrize, Integer> ranks = new HashMap<>();

    public WinningStatistics(WinningNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
        initRanks();
    }

    private void initRanks() {
        Arrays.stream(values()).filter(v -> v.matchedWinningNumberCount() > 0)
                .forEach(v -> ranks.put(v, 0));
    }

    public Map<LottoPrize, Integer> groupByWinningNumber(List<LottoTicket> lottoTickets) {
        List<Integer> matchedCounts = matchedCountList(lottoTickets);

        for (int i = 0; i < matchedCounts.size(); i++) {
            int matchedCount = matchedCounts.get(i);

            if (matchedCount == SECOND.matchedWinningNumberCount() && winningNumbers.isMatchedBonusNumber(lottoTickets.get(i))) {
                ranks.put(SECOND, ranks.get(SECOND) + 1);
                continue;
            }

            LottoPrize matchedLottoPrize = findBy(matchedCount);
            ranks.put(matchedLottoPrize, ranks.get(matchedLottoPrize) + 1);
        }

        return ranks;
    }

    private List<Integer> matchedCountList(List<LottoTicket> lottoTickets) {
        return lottoTickets.stream()
                .map(lottoTicket -> winningNumbers.matchedWinningNumberCount(lottoTicket))
                .collect(Collectors.toList());
    }

    public float profitRate(int ticketAmount, Map<LottoPrize, Integer> lottoPrize) {
        int totalPrize = totalPrize(lottoPrize);
        return (float) totalPrize / (ticketAmount * TICKET_PRICE);
    }

    private int totalPrize(Map<LottoPrize, Integer> lottoPrize) {
        return lottoPrize.keySet().stream()
                .mapToInt(v -> v.prizeMoney() * lottoPrize.get(v))
                .sum();
    }
}
