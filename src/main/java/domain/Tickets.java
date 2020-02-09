package domain;

import domain.strategy.NumberGenerationStrategy;

import java.util.*;

public class Tickets {

    private List<Ticket> tickets;
    private double profitRatio;
    Map<Prize, Integer> prizeResult = new HashMap<>();

    private Tickets(List<Ticket> tickets) {
        this.tickets = tickets;
        initializePrizeResult();
    }

    private void initializePrizeResult() {
        for(Prize prize : Prize.values()){
            prizeResult.put(prize, 0);
        }
    }

    public static Tickets of(int numberOfTickets, NumberGenerationStrategy strategy){
        List<Ticket> tickets = new ArrayList<>();

        for(int i = 0; i < numberOfTickets; i++){
            tickets.add(Ticket.of(strategy));
        }
        return new Tickets(tickets);
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void checkTicketsWithWinningNumbers(WinningNumbers winningNumbers) {
        Iterator<Ticket> ticketIterator = tickets.iterator();
        Prize prize;
        double profit = 0;

        while(ticketIterator.hasNext()){
            prize = ticketIterator.next().checkTicketWithWinningNumber(winningNumbers);
            int prizeNum = 1;
            if(prizeResult.containsKey(prize)){
                prizeNum = prizeResult.get(prize) + 1;
            }
            prizeResult.put(prize, prizeNum);
            profit += prize.getWinningMoney();
        }

        profitRatio = calculateProfitRatio(profit);
    }

    private double calculateProfitRatio(double profit) {
        return profit / (tickets.size() * Ticket.TICKET_PRICE);
    }

    public Map<Prize, Integer> getPrizeResult() {
        return prizeResult;
    }

    public double calculateProfitRatio() {
        return profitRatio;
    }
}
