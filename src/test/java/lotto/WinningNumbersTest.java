package lotto;

import lotto.domain.LottoTicket;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

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

    @ParameterizedTest
    @MethodSource("generateLottoTicket")
    @DisplayName("당첨 번호와 일치하는 로또 번호 개수를 반환한다")
    void matched_winning_numbers_count(int[] numbers, int expectedCount) {
        //given
        LottoTicket lottoTicket = new LottoTicket(numbers);
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6), 45);

        //when
        int matchedWinningNumber = winningNumbers.matchedWinningNumberCount(lottoTicket);

        //then
        assertThat(matchedWinningNumber).isEqualTo(expectedCount);
    }

    @Test
    @DisplayName("보너스 번호와 일치하는 로또 번호가 있는지 확인한다")
    void matched_bonus_number() {
        //given
        LottoTicket lottoTicket = new LottoTicket(1, 2, 3, 4, 5, 6);
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(4, 5, 6, 7, 8, 9), 1);

        //when
        boolean isMatchedBonusNumber = winningNumbers.isMatchedBonusNumber(lottoTicket);

        //then
        assertThat(isMatchedBonusNumber).isTrue();
    }

    private static Stream<Arguments> generateLottoTicket() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6}, 6),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 7}, 5),
                Arguments.of(new int[]{1, 2, 3, 4, 7, 8}, 4),
                Arguments.of(new int[]{1, 2, 3, 7, 8, 9}, 3),
                Arguments.of(new int[]{1, 2, 7, 8, 9, 10}, 2),
                Arguments.of(new int[]{1, 7, 8, 9, 10, 11}, 1),
                Arguments.of(new int[]{8, 9, 10, 11, 12, 13}, 0)
        );
    }
}
