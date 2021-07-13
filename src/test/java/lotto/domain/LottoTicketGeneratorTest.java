package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketGeneratorTest {

    @Test
    @DisplayName("입력받은 티켓 장수 만큼 자동으로 생성한 로또 티켓들을 반환한다.")
    void autoTicket() {
        //given
        NumberOfTickets numberOfTickets = new NumberOfTickets(10);

        //when
        LottoTickets lottoTicket = LottoTicketGenerator.autoTicket(numberOfTickets);

        //then
        assertThat(lottoTicket.list()).hasSize(10);
    }
}
