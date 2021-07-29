package lotto.controller;

import lotto.domain.Buyer;
import lotto.domain.LottoTicketGenerator;
import lotto.domain.LottoTickets;
import lotto.domain.NumberOfTickets;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumbers;
import lotto.domain.WinningStatistics;
import lotto.domain.dto.request.BuyerRequest;
import lotto.domain.dto.request.LottoTicketsRequest;
import lotto.domain.dto.request.WinningStatisticsRequest;
import lotto.domain.dto.response.LottoTicketsResponse;
import lotto.domain.dto.response.NumberOfTicketsResponse;
import lotto.domain.dto.response.WinningStatisticsResponse;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Buyer buyer = createBuyer(inputView.inputPurchaseAmount(), inputView.inputNumberOfManualTickets());
        NumberOfTicketsResponse numberOfTicketsResponse = new NumberOfTicketsResponse(buyer.getNumberOfManualTickets().intValue(), buyer.getNumberOfAutoTickets().intValue());
        LottoTickets lottoTickets = buyLottoTickets(inputView.inputManualLottoNumbers(numberOfTicketsResponse), buyer.getNumberOfAutoTickets());
        LottoTicketsResponse lottoTicketsResponse = new LottoTicketsResponse(lottoTickets.list());
        outputView.printNumberOfTickets(numberOfTicketsResponse);
        outputView.printLottoTickets(lottoTicketsResponse);
        WinningStatistics winningStatistics = getWinningStatistics(inputView.inputWinningNumbers(), inputView.inputBonusNumber(), lottoTickets);
        WinningStatisticsResponse winningStatisticsResponse = new WinningStatisticsResponse(winningStatistics.getRanks(), winningStatistics.calculateProfit(buyer.getTotalNumberOfTickets()));
        outputView.printWinningStatistics(winningStatisticsResponse);
    }

    private Buyer createBuyer(String inputPurchaseAmount, String inputNumberOfManualTickets) {
        BuyerRequest buyerRequest = new BuyerRequest(inputPurchaseAmount);
        PurchaseAmount purchaseAmount = new PurchaseAmount(buyerRequest.getPurchaseAmount());
        NumberOfTickets numberOfManualTickets = new NumberOfTickets(Integer.parseInt(inputNumberOfManualTickets));
        return new Buyer(purchaseAmount, numberOfManualTickets);
    }

    private LottoTickets buyLottoTickets(List<List<String>> inputManualLottoNumbers, NumberOfTickets numberOfAutoTickets) {
        LottoTicketsRequest lottoTicketsRequest = new LottoTicketsRequest(inputManualLottoNumbers);
        LottoTickets manualTickets = LottoTicketGenerator.createManualTickets(lottoTicketsRequest.getManualLottoNumbers());
        LottoTickets autoTickets = LottoTicketGenerator.createAutoTickets(numberOfAutoTickets);
        return manualTickets.add(autoTickets);
    }

    private WinningStatistics getWinningStatistics(List<String> inputWinnningNumbers, String inputBonusNumber, LottoTickets lottoTickets) {
        WinningStatisticsRequest winningStatisticsRequest = new WinningStatisticsRequest(inputWinnningNumbers, inputBonusNumber);
        WinningNumbers winningNumbers = new WinningNumbers(winningStatisticsRequest.getWinningNumbers(), winningStatisticsRequest.getBonusNumber());
        return new WinningStatistics(lottoTickets.match(winningNumbers));
    }
}
