package lotto.controller.dto.response;

import lotto.domain.number.LottoNumber;
import lotto.domain.ticket.LottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumbersResponseTest {

    @Test
    @DisplayName("로또 티켓의 번호들을 인자로 받아 dto 객체를 생성한다.")
    void create() {
        //given
        List<LottoNumber> lottoNumbers = LottoNumber.of(1, 2, 3, 4, 5, 6);
        LottoTicket lottoTicket = new LottoTicket(lottoNumbers);

        //when
        LottoNumbersResponse lottoNumbersResponse = new LottoNumbersResponse(lottoTicket.getLottoNumbers());

        //then
        assertThat(lottoNumbersResponse.list()).isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6));
    }
}
