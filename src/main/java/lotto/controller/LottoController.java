package lotto.controller;

import lotto.domain.BuyingPrice;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTicketVendingMachine;
import lotto.view.InputView;

import java.util.List;

public class LottoController {
    public void run() {
        String inputPrice = InputView.getBuyingPrice();
        BuyingPrice buyingPrice = new BuyingPrice(inputPrice);
        LottoTicketVendingMachine lottoTicketVendingMachine = new LottoTicketVendingMachine();
        List<LottoTicket> lottoTickets = lottoTicketVendingMachine.issueTickets(buyingPrice);

    }
}
