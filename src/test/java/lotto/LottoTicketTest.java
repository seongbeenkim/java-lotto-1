package lotto;

import lotto.domain.LottoGenerator;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {

    @Test
    @DisplayName("로또 넘버 6개를 인자로 받아 로또 티켓 객체를 생성한다")
    void create() {
        //given
        LottoGenerator lottoGenerator = new LottoGenerator();
        List<LottoNumber> lottoNumbers = lottoGenerator.issueAutoLottoNumbers();

        //when
        LottoTicket lottoTicket = new LottoTicket(lottoNumbers);

        //then
        assertThat(lottoTicket.lottoNumbers()).hasSize(6);
    }
}
