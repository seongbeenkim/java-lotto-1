package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketGeneratorTest {

    @Test
    @DisplayName("자동으로 추출한 번호 6개가 담긴 로또 티켓을 반환한다.")
    void autoTicket() {
        //given //when
        LottoTicket lottoTicket = LottoTicketGenerator.autoTicket();

        //then
        assertThat(lottoTicket.lottoNumbers()).hasSize(6);
    }
}
