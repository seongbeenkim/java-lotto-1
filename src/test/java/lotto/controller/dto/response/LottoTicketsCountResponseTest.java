package lotto.controller.dto.response;

import lotto.domain.ticket.LottoTicketsCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketsCountResponseTest {

    @Test
    @DisplayName("로또 티켓의 수를 인자로 받아 dto 객체를 생성한다.")
    void create() {
        //given
        int amount = 10;
        LottoTicketsCount manualTicketsCount = new LottoTicketsCount(amount);
        LottoTicketsCount autoTicketsCount = new LottoTicketsCount(amount);

        //when
        LottoTicketsCountResponse lottoTicketsCountResponse = new LottoTicketsCountResponse(manualTicketsCount.intValue(), autoTicketsCount.intValue());

        //then
        assertThat(lottoTicketsCountResponse.getManualTicketsCount()).isEqualTo(amount);
        assertThat(lottoTicketsCountResponse.getAutoTicketsCount()).isEqualTo(amount);
    }
}
