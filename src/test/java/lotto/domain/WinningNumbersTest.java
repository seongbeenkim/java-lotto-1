package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class WinningNumbersTest {

    @Test
    @DisplayName("6개의 당첨 번호와 1개의 보너스 번호를 인자로 받아 당첨 번호 객체를 생성한다.")
    void create() {
        //given
        List<LottoNumber> winningNumbers = LottoNumber.of(1, 2, 3, 4, 5, 6);
        LottoNumber bonusNumber = LottoNumber.valueOf(10);

        //when
        WinningNumbers result = new WinningNumbers(winningNumbers, bonusNumber);

        //then
        assertThat(result).isEqualTo(new WinningNumbers(winningNumbers, bonusNumber));
    }

    @ParameterizedTest
    @CsvSource(value = {"1, 2, 3, 4, 5, 5 : 6", "1, 2, 3, 4, 5, 6 : 6"}, delimiter = ':')
    @DisplayName("보너스 볼 포함 서로 다른 번호가 7개가 아닐 경우, 예외가 발생한다.")
    void validateCountOf(String winningNumbers, int bonusNumber) {
        //given //when //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningNumbers(winningNumbers, bonusNumber))
                .withMessage("서로 다른 번호가 7개여야 합니다.");
    }
}
