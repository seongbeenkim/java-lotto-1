package lotto;

import lotto.domain.BuyingPrice;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTicketVendingMachine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    @Test
    @DisplayName("로또 티켓 장수만큼 로또 티켓을 생성한다.")
    void issue_tickets() {
        //given
        int ticketAmount = 5;
        LottoTicketVendingMachine lottoTicketVendingMachine = new LottoTicketVendingMachine();

        //when
        List<LottoTicket> tickets = lottoTicketVendingMachine.issueTickets(ticketAmount);

        //then
        assertThat(tickets).hasSize(ticketAmount);
    }

}
