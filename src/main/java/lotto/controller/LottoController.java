package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static lotto.domain.LottoTicketVendingMachine.TICKET_PRICE;

public class LottoController {
    public void run() {
        String inputPrice = InputView.getBuyingPrice();
        BuyingPrice buyingPrice = new BuyingPrice(inputPrice);
        int ticketAmount = buyingPrice.divide(TICKET_PRICE);
        OutputView.printTicketAmount(ticketAmount);

        LottoTicketVendingMachine lottoTicketVendingMachine = new LottoTicketVendingMachine();
        List<LottoTicket> lottoTickets = lottoTicketVendingMachine.issueTickets(buyingPrice);
        OutputView.printLottoTickets(lottoTickets);

        String inputWinningNumbers = InputView.getWinningNumber();
        List<Integer> splitWinningNumbers = InputView.split(inputWinningNumbers)
                .stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int bonusNumber = Integer.parseInt(InputView.getBonusNumber());
        WinningNumbers winningNumbers = new WinningNumbers(splitWinningNumbers, bonusNumber);
        WinningStatistics winningStatistics = new WinningStatistics(winningNumbers);

        Map<LottoPrize, Integer> ranks = winningStatistics.groupByWinningNumber(lottoTickets);
        OutputView.printWinningStatistics(ranks);

        float profitRate = winningStatistics.profitRate(ticketAmount, ranks);
        OutputView.printProfitRate(profitRate);
    }
}
