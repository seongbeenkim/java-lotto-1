package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    @DisplayName("전달받은 숫자의 로또 번호 객체를 반환한다.")
    void valueOf(int number) {
        //given //when
        LottoNumber lottoNumber = LottoNumber.valueOf(number);

        //then
        assertThat(lottoNumber.value()).isEqualTo(number);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    @DisplayName("번호가 1 ~ 45가 아닐 경우, 예외가 발생한다.")
    void validate(int invalidLottoNumber) {
        //given //when //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoNumber.valueOf(invalidLottoNumber))
                .withMessage("로또 번호는 1 ~ 45여야 합니다.");
    }
}

