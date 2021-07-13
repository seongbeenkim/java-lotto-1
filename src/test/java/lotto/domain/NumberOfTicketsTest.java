package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberOfTicketsTest {

    @Test
    @DisplayName("티켓 장수 객체를 생성한다.")
    void create() {
        //given
        int number = 10;

        //when
        NumberOfTickets numberOfTickets = new NumberOfTickets(number);

        //then
        assertThat(numberOfTickets).isEqualTo(new NumberOfTickets(number));
    }
}
