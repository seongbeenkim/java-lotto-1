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
    void validateMinimum() {
        //when //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new PurchaseAmount(999))
                .withMessage("최소 구입 금액은 1,000원 이상이여야 합니다.");
    }

    @Test
    @DisplayName("1,000원 단위가 아닐 경우, 예외가 발생한다.")
    void validateUnit() {
        //when //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new PurchaseAmount(1001))
                .withMessage("구입 금액은 1,000원 단위여야 합니다.");
    }

    @Test
    @DisplayName("인자로 받은 값보다 비교하여 작을 경우, 참을 반환한다.")
    void isLessThan() {
        //given
        PurchaseAmount purchaseAmount = new PurchaseAmount(1000);
        int greaterNumber = 1001;

        //when
        boolean actual = purchaseAmount.isLessThan(greaterNumber);

        //then
        assertThat(actual).isTrue();
    }

    @Test
    @DisplayName("현재 금액에서 인자로 받은 금액을 뺀 결과를 반환한다.")
    void subtract() {
        //given
        PurchaseAmount purchaseAmount = new PurchaseAmount(10000);

        //when
        int leftAmount = purchaseAmount.subtract(1000);

        //then
        assertThat(leftAmount).isEqualTo(9000);
    }
}
