package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {

    @Test
    @DisplayName("1 ~ 45 사이의 로또 번호를 생성한다.")
    void lotto_generator() {
        //given
        LottoGenerator lottoGenerator = new LottoGenerator();

        //when
        LottoNumber lottoNumber = lottoGenerator.lottoNumber();

        //then
        assertThat(lottoNumber.value()).isLessThanOrEqualTo(45);
        assertThat(lottoNumber.value()).isGreaterThanOrEqualTo(1);
    }
}
