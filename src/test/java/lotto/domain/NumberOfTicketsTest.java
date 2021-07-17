package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.domain.LottoTicket.LOTTO_TICKET_PRICE;
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

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 100, 1000})
    @DisplayName("구매한 티켓 장수의 가격을 반환한다.")
    void getPaidPurchaseAmount(int input) {
        //given
        NumberOfTickets numberOfTickets = new NumberOfTickets(input);

        //when
        int result = numberOfTickets.getPaidPurchaseAmount();

        //then
        assertThat(result).isEqualTo(input * LOTTO_TICKET_PRICE);
    }
}
