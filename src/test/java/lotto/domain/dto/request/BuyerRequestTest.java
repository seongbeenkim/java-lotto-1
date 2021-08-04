package lotto.domain.dto.request;

import lotto.domain.Buyer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BuyerRequestTest {

    @ParameterizedTest
    @ValueSource(strings = {"천원", "1000원", "1000.0"})
    @DisplayName("구매 금액이 정수 타입이 아닐 경우, 예외가 발생한다.")
    void validateInteger_purchase_amount(String money) {
        //when //then
        assertThatThrownBy(() -> new BuyerRequest(money, "1000"))
                .isInstanceOf(NumberFormatException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"열장", "10장", "1000.0"})
    @DisplayName("티켓 수가 정수 타입이 아닐 경우, 예외가 발생한다.")
    void validateInteger_tickets_count(String money) {
        //when //then
        assertThatThrownBy(() -> new BuyerRequest(money, "1000"))
                .isInstanceOf(NumberFormatException.class);
    }

    @Test
    @DisplayName("구매자를 반환한다.")
    void getBuyer() {
        //given
        BuyerRequest buyerRequest = new BuyerRequest("1000", "1");

        //when
        Buyer buyer = buyerRequest.getBuyer();

        //then
        assertThat(buyer).isNotNull();
    }
}
