package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PurchaseAmountTest {

    @Test
    @DisplayName("구매 금액을 생성한다.")
    void create() {
        //given
        int paidMoney = 1000;

        //when
        PurchaseAmount purchaseAmount = new PurchaseAmount(paidMoney);

        //then
        assertThat(purchaseAmount).isEqualTo(new PurchaseAmount(paidMoney));
    }

    @Test
    @DisplayName("1,000원 미만일 경우, 예외가 발생한다.")
    void validate() {
        //given //when //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new PurchaseAmount(999))
                .withMessage("최소 구입 금액은 1,000원 이상이여야 합니다.");
    }

    @Test
    @DisplayName("구입할 수 있는 로또 티켓의 장수를 반환한다.")
    void tickets() {
        //given
        PurchaseAmount purchaseAmount = new PurchaseAmount(1000);

        //when
        NumberOfTickets numberOfTickets = purchaseAmount.numberOfTickets();

        //then
        assertThat(numberOfTickets.value()).isEqualTo(1);
    }
}
