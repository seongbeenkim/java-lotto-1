package lotto.domain.dto.request;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class NumberOfTicketsRequestTest {

    @ParameterizedTest
    @ValueSource(strings = {"천원", "1000원", "1000.0"})
    @DisplayName("구매 금액이 정수 타입이 아닐 경우, 예외가 발생한다.")
    void validateInteger(String money) {
        //when //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new NumberOfTicketsRequest(money))
                .withMessage("구매 금액은 정수여야 합니다.");
    }

    @Test
    @DisplayName("입력받은 구입 금액을 반환한다.")
    void getPurchaseAmount() {
        //given
        String money = "1000";
        NumberOfTicketsRequest numberOfTicketsRequest = new NumberOfTicketsRequest(money);

        //when
        int purchaseAmount = numberOfTicketsRequest.getPurchaseAmount();

        //then
        assertThat(purchaseAmount).isEqualTo(Integer.parseInt(money));
    }
}
