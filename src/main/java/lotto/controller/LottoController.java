package lotto.controller;

import lotto.domain.LottoTicketGenerator;
import lotto.domain.LottoTickets;
import lotto.domain.NumberOfTickets;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumbers;
import lotto.domain.WinningStatistics;
import lotto.domain.dto.LottoTicketsResponse;
import lotto.domain.dto.NumberOfTicketsResponse;
import lotto.domain.dto.WinningStatisticsResponse;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void run() {
        NumberOfTickets numberOfTickets = extractNumberOfTicketsFrom(InputView.inputPurchaseAmount());
        NumberOfTicketsResponse numberOfTicketsResponse = new NumberOfTicketsResponse(numberOfTickets.getNumberOfTickets());
        OutputView.printNumberOfTickets(numberOfTicketsResponse);

        LottoTickets lottoTickets = buyLottoTickets(numberOfTickets);
        LottoTicketsResponse lottoTicketsResponse = new LottoTicketsResponse(lottoTickets.list());
        OutputView.printLottoTickets(lottoTicketsResponse);

        WinningStatistics winningStatistics = quantifyLottoResults(lottoTickets, InputView.inputWinningNumbers(), InputView.inputBonusNumber());
        WinningStatisticsResponse winningStatisticsResponse = new WinningStatisticsResponse(winningStatistics.getRanks(), winningStatistics.calculateProfit(numberOfTickets));
        OutputView.printWinningStatistics(winningStatisticsResponse);
    }

    private NumberOfTickets extractNumberOfTicketsFrom(final String inputPurchaseAmount) {
        PurchaseAmount purchaseAmount = new PurchaseAmount(inputPurchaseAmount);
        return purchaseAmount.convertToNumberOfTickets();
    }

    private LottoTickets buyLottoTickets(final NumberOfTickets numberOfTickets) {
        return LottoTicketGenerator.createAutoTickets(numberOfTickets);
    }

    private WinningStatistics quantifyLottoResults(final LottoTickets lottoTickets, final String inputWinningNumbers, final String inputBonusNumber) {
        WinningNumbers winningNumbers = new WinningNumbers(inputWinningNumbers, inputBonusNumber);
        return new WinningStatistics(lottoTickets.match(winningNumbers));
    }
}
