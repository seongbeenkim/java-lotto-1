package lotto.domain.dto.response;

import lotto.domain.LottoTicketsCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketsCountResponseTest {

    @Test
    @DisplayName("로또 티켓의 수를 인자로 받아 dto 객체를 생성한다.")
    void create() {
        //given
        int amount = 10;
        LottoTicketsCount numberOfManualTickets = new LottoTicketsCount(amount);
        LottoTicketsCount numberOfAutoTickets = new LottoTicketsCount(amount);

        //when
        LottoTicketsCountResponse lottoTicketsCountResponse = new LottoTicketsCountResponse(numberOfManualTickets.intValue(), numberOfAutoTickets.intValue());

        //then
        assertThat(lottoTicketsCountResponse.getNumberOfManualTickets()).isEqualTo(amount);
        assertThat(lottoTicketsCountResponse.getNumberOfAutoTickets()).isEqualTo(amount);
    }
}
