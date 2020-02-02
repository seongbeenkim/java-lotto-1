package service;

import domain.Tickets;
import domain.WinningNumbers;
import domain.strategy.RandomNumberGenerationStrategy;

public class LottoGameService {

    public Tickets buyTickets(int numberOfLotto) {
        return Tickets.of(numberOfLotto, new RandomNumberGenerationStrategy());
    }

    public void checkTickets(Tickets tickets, WinningNumbers winningNumbers) {
        tickets.checkTicketsWithWinningNumbers(winningNumbers);
    }
}
