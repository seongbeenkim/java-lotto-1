package lotto.domain.dto.response;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketsResponseTest {

    @Test
    @DisplayName("로또 티켓의 번호들을 인자로 받아 dto 객체를 생성한다.")
    void create() {
        //given
        List<LottoNumber> firstLottoNumbers = LottoNumber.of(1, 2, 3, 4, 5, 6);
        List<LottoNumber> secondLottoNumbers = LottoNumber.of(7, 8, 9, 10, 11, 12);
        LottoTickets lottoTickets = new LottoTickets(Arrays.asList(new LottoTicket(firstLottoNumbers), new LottoTicket(secondLottoNumbers)));

        //when
        LottoTicketsResponse lottoTicketsResponse = new LottoTicketsResponse(lottoTickets.list());

        //then
        assertThat(lottoTicketsResponse.list()).hasSize(2)
                .extracting("lottoNumbers")
                .contains(firstLottoNumbers, secondLottoNumbers);
    }
}
