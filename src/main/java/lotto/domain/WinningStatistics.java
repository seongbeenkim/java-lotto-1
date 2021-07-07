package lotto.domain;

import static lotto.domain.LottoTicketVendingMachine.TICKET_PRICE;

public class WinningStatistics {

    public int matchedCount(LottoTicket lottoTickets, WinningNumbers winningNumbers) {
        return winningNumbers.matchedWinningNumberCount(lottoTickets);
    }

    public float profitRate(int ticketAmount, int totalPrize) {
        return (float) totalPrize / (ticketAmount * TICKET_PRICE);
    }
}
