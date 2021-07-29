package lotto.domain.dto.response;

import lotto.domain.NumberOfTickets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberOfTicketsResponseTest {

    @Test
    @DisplayName("로또 티켓의 수를 인자로 받아 dto 객체를 생성한다.")
    void create() {
        //given
        int amount = 10;
        NumberOfTickets numberOfManualTickets = new NumberOfTickets(amount);
        NumberOfTickets numberOfAutoTickets = new NumberOfTickets(amount);

        //when
        NumberOfTicketsResponse numberOfTicketsResponse = new NumberOfTicketsResponse(numberOfManualTickets.intValue(), numberOfAutoTickets.intValue());

        //then
        assertThat(numberOfTicketsResponse.getNumberOfManualTickets()).isEqualTo(amount);
        assertThat(numberOfTicketsResponse.getNumberOfAutoTickets()).isEqualTo(amount);
    }
}
