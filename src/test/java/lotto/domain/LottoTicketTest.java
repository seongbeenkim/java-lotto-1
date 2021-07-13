package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTicketTest {

    @Test
    @DisplayName("6개의 서로 다른 로또 번호를 인자로 받아 로또 티켓을 생성한다.")
    void create() {
        //given
        List<LottoNumber> lottoNumbers = LottoNumber.of(1, 2, 3, 4, 5, 6);

        //when
        LottoTicket lottoTicket = new LottoTicket(lottoNumbers);

        //then
        assertThat(lottoTicket.lottoNumbers())
                .hasSize(6)
                .extracting("value")
                .containsExactly(lottoNumbers);
    }

    @Test
    @DisplayName("서로 다른 로또 번호가 6개가 아닐 경우, 예외가 발생한다.")
    void validateCountOf() {
        //given
        List<LottoNumber> lottoNumbers = LottoNumber.of(1, 2, 3, 4, 5, 5);

        //when //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoTicket(lottoNumbers))
                .withMessage("서로 다른 로또 번호가 6개여야 합니다.");
    }
}
