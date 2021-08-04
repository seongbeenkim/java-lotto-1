package lotto.domain.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ManualLottoNumbersTest {

    @Test
    @DisplayName("서로 다른 로또 번호가 6개가 아닐 경우, 예외가 발생한다.")
    void validateCountOf() {
        //given
        List<LottoNumber> lottoNumbers = LottoNumber.of(1, 2, 3, 4, 5, 5);

        //when //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new ManualLottoNumbers(lottoNumbers))
                .withMessage("서로 다른 로또 번호가 6개여야 합니다.");
    }
}
