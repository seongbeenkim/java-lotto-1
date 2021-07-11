package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumberTest {

    @Test
    @DisplayName("하나의 로또 번호를 생성한다.")
    void create() {
        //given
        int number = 1;

        //when
        LottoNumber lottoNumber = new LottoNumber(number);

        //then
        assertThat(lottoNumber).isEqualTo(new LottoNumber(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    @DisplayName("번호가 1 ~ 45가 아닐 경우, 예외가 발생한다.")
    void validate(int invalidLottoNumber) {
        //given //when //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumber(invalidLottoNumber))
                .withMessage("로또 번호는 1 ~ 45여야 합니다.");
    }
}

