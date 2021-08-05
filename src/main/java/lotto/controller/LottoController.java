package lotto.controller;

import lotto.controller.dto.request.BuyerRequest;
import lotto.controller.dto.request.LottoTicketsRequest;
import lotto.controller.dto.request.WinningStatisticsRequest;
import lotto.controller.dto.response.LottoTicketsCountResponse;
import lotto.controller.dto.response.LottoTicketsResponse;
import lotto.controller.dto.response.WinningStatisticsResponse;
import lotto.domain.Buyer;
import lotto.domain.WinningStatistics;
import lotto.domain.number.WinningNumbers;
import lotto.domain.ticket.LottoTicketGenerator;
import lotto.domain.ticket.LottoTickets;
import lotto.domain.ticket.LottoTicketsCount;
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
        Buyer buyer = createBuyer(inputView.inputPurchaseAmount(), inputView.inputManualTicketsCount());
        LottoTicketsCountResponse lottoTicketsCountResponse = new LottoTicketsCountResponse(buyer.getManualTicketsCount().intValue(), buyer.getAutoTicketsCount().intValue());
        LottoTickets lottoTickets = buyLottoTickets(inputView.inputManualLottoNumbers(lottoTicketsCountResponse), buyer.getAutoTicketsCount());
        LottoTicketsResponse lottoTicketsResponse = new LottoTicketsResponse(lottoTickets.list());
        outputView.printLottoTicketsCount(lottoTicketsCountResponse);
        outputView.printLottoTickets(lottoTicketsResponse);
        WinningStatistics winningStatistics = getWinningStatistics(inputView.inputWinningNumbers(), inputView.inputBonusNumber(), lottoTickets);
        WinningStatisticsResponse winningStatisticsResponse = new WinningStatisticsResponse(winningStatistics.getRanks(), winningStatistics.calculateProfit(buyer.getTotalTicketsCount()));
        outputView.printWinningStatistics(winningStatisticsResponse);
    }

    private Buyer createBuyer(String inputPurchaseAmount, String inputManualTicketsCount) {
        BuyerRequest buyerRequest = new BuyerRequest(inputPurchaseAmount, inputManualTicketsCount);
        return buyerRequest.getBuyer();
    }

    private LottoTickets buyLottoTickets(List<List<String>> inputManualLottoNumbers, LottoTicketsCount autoTicketsCount) {
        LottoTicketsRequest lottoTicketsRequest = new LottoTicketsRequest(inputManualLottoNumbers);
        LottoTickets manualTickets = LottoTicketGenerator.createManualTickets(lottoTicketsRequest.getManualLottoNumbers());
        LottoTickets autoTickets = LottoTicketGenerator.createAutoTickets(autoTicketsCount);
        return new LottoTickets(manualTickets, autoTickets);
    }

    private WinningStatistics getWinningStatistics(List<String> inputWinnningNumbers, String inputBonusNumber, LottoTickets lottoTickets) {
        WinningStatisticsRequest winningStatisticsRequest = new WinningStatisticsRequest(inputWinnningNumbers, inputBonusNumber);
        WinningNumbers winningNumbers = winningStatisticsRequest.getWinningNumbers();
        return new WinningStatistics(lottoTickets.match(winningNumbers));
    }
}
