package lotto.controller;

import lotto.domain.LottoTicketGenerator;
import lotto.domain.LottoTickets;
import lotto.domain.NumberOfTickets;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void run() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(InputView.inputPurchaseAmount());
        NumberOfTickets numberOfTickets = purchaseAmount.numberOfTickets();
        OutputView.printNumberOfTickets(numberOfTickets);
        LottoTickets lottoTickets = LottoTicketGenerator.autoTicket(numberOfTickets);
        OutputView.printLottoTickets(lottoTickets);
        WinningNumbers winningNumbers = new WinningNumbers(InputView.inputWinningNumbers(), InputView.inputBonusNumber());
    }
}
