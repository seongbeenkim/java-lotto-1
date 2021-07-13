package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

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

    @Test
    @DisplayName("1장 미만일 경우, 예외가 발생한다.")
    void validatePositive() {
        //given //when //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new NumberOfTickets(0))
                .withMessage("티켓은 1장 이상이여야 합니다.");
    }
}
