package controller;

import domain.Ticket;
import domain.Tickets;
import domain.WinningNumbers;
import service.LottoGameService;
import view.InputView;
import view.OutputView;

import java.util.*;

public class LottoGameController {

    private InputView inputView;
    private OutputView outputView;
    private final LottoGameService lottoGameService = new LottoGameService();

    public LottoGameController(InputView inputView, OutputView outputView){
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        int budgetForTickets = Integer.parseInt(inputView.getBudgetForTicketsConsole());
        int numberOfTickets = budgetForTickets / Ticket.TICKET_PRICE;
        Tickets tickets = lottoGameService.buyTickets(numberOfTickets);

        String winningNumberString = inputView.getWinningNumbersConsole();
        int bonusNumber = inputView.getBonusNumberConsole();

        Set<Integer> winningNumberSet = new HashSet<>();
        Arrays.stream(winningNumberString.split(","))
                .forEach(winningNumber -> winningNumberSet.add(Integer.parseInt(winningNumber)));

        lottoGameService.checkTickets(tickets, new WinningNumbers(winningNumberSet, bonusNumber));

        outputView.printResult(tickets);
    }
}
