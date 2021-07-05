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
    @DisplayName("로또 티켓 장수만큼 로또 티켓을 생성한다.")
    void issue_tickets_from_buying_price() {
        //given
        BuyingPrice buyingPrice = new BuyingPrice(5000);
        LottoTicketVendingMachine lottoTicketVendingMachine = new LottoTicketVendingMachine();

        //when
        List<LottoTicket> tickets = lottoTicketVendingMachine.issueTickets(buyingPrice);

        //then
        assertThat(tickets).hasSize(5);
    }

}
