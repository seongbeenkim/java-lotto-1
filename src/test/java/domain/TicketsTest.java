package domain;

import domain.strategy.ManualNumberGenerationStrategy;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TicketsTest {

    @Test
    void ofTest() {
        Tickets tickets = Tickets.of(5,new ManualNumberGenerationStrategy());
        Set<Integer> numbers = new HashSet<>(Arrays.asList(0,1,2,3,4,5));
        List<Ticket> ticketList = tickets.getTickets();
        assertThat(ticketList.size())
                .isEqualTo(5);
        for(int i=0; i<5; i++)
            assertThat(ticketList.get(i).getNumbers().containsAll(numbers))
                .isTrue();
    }

}