package domain;

import domain.strategy.NumberGenerationStrategy;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Ticket {

    public static final int MAX_COUNT_OF_LOTTO_NUMBERS = 6;
    public static final int TICKET_PRICE = 1000;

    private static Prize prize;

    private Set<Integer> numbers;

    private Ticket(Set<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Ticket of(NumberGenerationStrategy strategy){
        return new Ticket(generateNumbers(strategy));
    }

    public static Prize getPrize() {
        return prize;
    }

    private static Set<Integer> generateNumbers(NumberGenerationStrategy strategy){

        Set<Integer> numbers = new HashSet();

        while(numbers.size() < MAX_COUNT_OF_LOTTO_NUMBERS)
            numbers.add(generateNumber(strategy));

        return numbers;
    }

    private static int generateNumber(NumberGenerationStrategy strategy) {
        return strategy.generateNumber();
    }

    public Prize checkTicketWithWinningNumber(WinningNumbers winningNumbers) {
        int countOfWinningNumbers = getCountOfWinningNumbers(winningNumbers);
        boolean isBonusNumber = false;

        if(countOfWinningNumbers == 5)
            isBonusNumber = getCountOfBonusNumber(winningNumbers.bonusNumber);

        prize = Prize.match(countOfWinningNumbers, isBonusNumber);
        return prize;
    }

    private int getCountOfWinningNumbers(WinningNumbers winningNumbers) {
        int count = 0;

        Iterator<Integer> winningNumberIterator = winningNumbers.winningNumbers.iterator();
        while(winningNumberIterator.hasNext())
            if(numbers.contains(winningNumberIterator.next())){
                count++;
        }
        return count;
    }

    private boolean getCountOfBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
