package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class BuyerTest {

    @Test
    @DisplayName("구매하려는 수동 로또 티켓의 금액이 가지고 있는 금액보다 많은 경우 예외가 발생한다.")
    void create() {
        //given
        PurchaseAmount currentAmount = new PurchaseAmount(10_000);
        NumberOfTickets manualNumberOfTickets = new NumberOfTickets(11);

        //when //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Buyer(currentAmount, manualNumberOfTickets))
                .withMessage("구매하려는 수동 로또 티켓의 금액은 가지고 있는 금액보다 작아야 합니다.");
    }
}
