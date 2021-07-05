package lotto;

import lotto.domain.LottoNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @ParameterizedTest()
    @ValueSource(ints = {0, 46})
    @DisplayName("로또 번호가 1 ~ 45이 아닐 경우 예외가 발생한다")
    void validate_lotto_number(int invalidLottoNumber) {
        //given //when //then
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumber(invalidLottoNumber))
                .withMessage("로또 번호는 1 ~ 45 까지 입니다.");
    }
}