package lotto.domain.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    @DisplayName("전달받은 숫자의 로또 번호 객체를 반환한다.")
    void valueOf(int number) {
        //when
        LottoNumber lottoNumber = LottoNumber.valueOf(number);

        //then
        assertThat(lottoNumber.value()).isEqualTo(number);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    @DisplayName("번호가 1 ~ 45가 아닐 경우, 예외가 발생한다.")
    void validate(int invalidLottoNumber) {
        //when //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoNumber.valueOf(invalidLottoNumber))
                .withMessage("로또 번호는 1 ~ 45여야 합니다.");
    }

    @Test
    @DisplayName("여러 숫자를 인자로 받아, 인자의 수 만큼의 로또 번호를 반환한다.")
    void of() {
        //when
        List<LottoNumber> firstLottoNumbers = LottoNumber.of(1, 2, 3, 4, 5, 6);

        //then
        assertThat(firstLottoNumbers).hasSize(6);
    }
}
