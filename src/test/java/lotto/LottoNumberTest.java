package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberTest {

    @Test
    @DisplayName("로또 번호를 생성한다.")
    void create() {
        //given
        LottoNumber lottoNumber = new LottoNumber(1);

        //when //then
        assertThat(lottoNumber).isEqualTo(new LottoNumber(1));
    }
}