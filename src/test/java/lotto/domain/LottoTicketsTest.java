package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketsTest {

    @Test
    @DisplayName("로또 티켓들을 인자로 가진 로또 티켓 목록 객체를 생성한다.")
    void create() {
        //given
        LottoTicket firstLottoTicket = new LottoTicket(LottoNumber.of(1, 2, 3, 4, 5, 6));
        LottoTicket secondLottoTicket = new LottoTicket(LottoNumber.of(1, 2, 3, 4, 5, 7));

        //when
        LottoTickets lottoTickets = new LottoTickets(Arrays.asList(firstLottoTicket, secondLottoTicket));

        //then
        assertThat(lottoTickets.list()).hasSize(2);
    }
}
