package lotto.domain.ticket;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.domain.ticket.LottoTicketsCount.LOTTO_TICKET_PRICE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTicketsCountTest {

    @Test
    @DisplayName("티켓 장수 객체를 생성한다.")
    void create() {
        //given
        int number = 10;

        //when
        LottoTicketsCount lottoTicketsCount = new LottoTicketsCount(number);

        //then
        assertThat(lottoTicketsCount).isEqualTo(new LottoTicketsCount(number));
    }

    @Test
    @DisplayName("0장 미만일 경우, 예외가 발생한다.")
    void validatePositive() {
        //when //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoTicketsCount(-1))
                .withMessage("티켓은 0장 이상이여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 100, 1000})
    @DisplayName("구매한 티켓 장수의 가격을 반환한다.")
    void getPaidPurchaseAmount(int input) {
        //given
        LottoTicketsCount lottoTicketsCount = new LottoTicketsCount(input);

        //when
        int result = lottoTicketsCount.getPaidPurchaseAmount();

        //then
        assertThat(result).isEqualTo(input * LOTTO_TICKET_PRICE);
    }

    @Test
    @DisplayName("전달받은 티켓의 수를 합친 새로운 객체를 반환한다.")
    void add() {
        //given
        LottoTicketsCount lottoTicketsCount1 = new LottoTicketsCount(10);
        LottoTicketsCount lottoTicketsCount2 = new LottoTicketsCount(10);

        //when
        LottoTicketsCount addedLottoTicketsCount = lottoTicketsCount1.add(lottoTicketsCount2);

        //then
        assertThat(addedLottoTicketsCount).isEqualTo(new LottoTicketsCount(20));
    }
}
