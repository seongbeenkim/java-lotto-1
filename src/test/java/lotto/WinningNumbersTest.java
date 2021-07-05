package lotto;

import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class WinningNumbersTest {

    @Test
    @DisplayName("6개의 로또 당첨 번호를 입력받아 당첨 번호를 객체를 생성한다")
    void create() {
        //given
        List<Integer> inputNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        //when
        WinningNumbers winningNumbers = new WinningNumbers(inputNumbers, bonusNumber);

        //then
        assertThat(winningNumbers).isEqualTo(new WinningNumbers(inputNumbers, bonusNumber));
    }

    @Test
    @DisplayName("당첨 번호가 중복되는 경우 예외가 발생한다")
    void validate_duplication_winning_number() {
        //given
        List<Integer> inputNumbers = Arrays.asList(1, 2, 3, 4, 5, 5);
        int bonusNumber = 6;

        //when //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningNumbers(inputNumbers, bonusNumber))
                .withMessage("당첨 번호가 중복됩니다.");
    }

    @Test
    @DisplayName("당첨 번호와 보너스 번호가 중복되는 경우 예외가 발생한다")
    void validate_duplication_bonus_number() {
        //given
        List<Integer> inputNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 6;

        //when //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningNumbers(inputNumbers, bonusNumber))
                .withMessage("당첨 번호가 중복됩니다.");
    }
}
