package domain;

import domain.strategy.ManualNumberGenerationStrategy;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TicketTest {

    @Test
    void ofTest() {
        Ticket ticket = Ticket.of(new ManualNumberGenerationStrategy());
        Set<Integer> manualNumbers =ticket.getNumbers();
        Set<Integer> numbers = new HashSet<>(Arrays.asList(0,1,2,3,4,5));
        assertThat(manualNumbers.containsAll(numbers))
                .isTrue();
    }

    @Test
    void checkTicketWithWinningNumberTest() {
        Ticket ticket = Ticket.of(new ManualNumberGenerationStrategy());

        Set<Integer> numbers = new HashSet<>(Arrays.asList(0,1,2,3,4,5));
        WinningNumbers winningNumbers = new WinningNumbers(numbers,6);

        assertThat(ticket.checkTicketWithWinningNumber(winningNumbers))
                .isEqualTo(Prize.SIX_MATCHED);
    }
}