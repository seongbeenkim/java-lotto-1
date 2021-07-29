package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class BuyerTest {

    @Test
    @DisplayName("구매하려는 수동 로또 티켓의 금액이 가지고 있는 금액보다 많은 경우 예외가 발생한다.")
    void validateMaxedOut() {
        //given
        PurchaseAmount currentAmount = new PurchaseAmount(10_000);
        NumberOfTickets manualNumberOfTickets = new NumberOfTickets(11);

        //when //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Buyer(currentAmount, manualNumberOfTickets))
                .withMessage("구매하려는 수동 로또 티켓의 금액은 가지고 있는 금액보다 작아야 합니다.");
    }

    @Test
    @DisplayName("자동으로 구입할 수 있는 티켓의 수를 반환한다.")
    void getNumberOfAutoTicket() {
        //given
        PurchaseAmount currentAmount = new PurchaseAmount(10_000);
        NumberOfTickets manualNumberOfTickets = new NumberOfTickets(5);
        Buyer buyer = new Buyer(currentAmount, manualNumberOfTickets);

        //when
        NumberOfTickets numberOfAutoTickets = buyer.getNumberOfAutoTickets();

        //then
        assertThat(numberOfAutoTickets).isEqualTo(new NumberOfTickets(5));
    }
}
