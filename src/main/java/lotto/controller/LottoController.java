package lotto.controller;

import lotto.domain.LottoTicketGenerator;
import lotto.domain.LottoTickets;
import lotto.domain.NumberOfTickets;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumbers;
import lotto.domain.WinningStatistics;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void run() {
        NumberOfTickets numberOfTickets = numberOfTicketsFrom(InputView.inputPurchaseAmount());
        OutputView.printNumberOfTickets(numberOfTickets);

        LottoTickets lottoTickets = buyLottoTickets(numberOfTickets);
        OutputView.printLottoTickets(lottoTickets);

        WinningStatistics winningStatistics = winningStatisticsOf(lottoTickets, InputView.inputWinningNumbers(), InputView.inputBonusNumber());
        OutputView.printWinningStatistics(winningStatistics.ranks(), winningStatistics.profit(numberOfTickets));
    }

    private NumberOfTickets numberOfTicketsFrom(final String inputPurchaseAmount) {
        PurchaseAmount purchaseAmount = new PurchaseAmount(inputPurchaseAmount);
        return purchaseAmount.numberOfTickets();
    }

    private LottoTickets buyLottoTickets(final NumberOfTickets numberOfTickets) {
        return LottoTicketGenerator.autoTicket(numberOfTickets);
    }

    private WinningStatistics winningStatisticsOf(final LottoTickets lottoTickets, final String inputWinningNumbers, final String inputBonusNumber) {
        WinningNumbers winningNumbers = new WinningNumbers(inputWinningNumbers, inputBonusNumber);
        return new WinningStatistics(lottoTickets.match(winningNumbers));
    }
}
