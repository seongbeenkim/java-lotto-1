package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketVendingMachineTest {
    @Test
    @DisplayName("구입 금액을 티켓 가격으로 나누어 티켓 장수를 반환한다")
    void divide_buying_price_to_ticket_amount() {
        //given
        BuyingPrice buyingPrice = new BuyingPrice(10000);
        LottoTicketVendingMachine lottoTicketVendingMachine = new LottoTicketVendingMachine();

        //when
        int ticketAmount = lottoTicketVendingMachine.divide(buyingPrice);

        //then
        assertThat(ticketAmount).isEqualTo(10);
    }

}
