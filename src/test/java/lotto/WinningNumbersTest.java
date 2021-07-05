package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
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

    @Test
    @DisplayName("당첨 번호와 일치하는 로또 번호 개수를 반환한다")
    void matched_winning_numbers_count() {
        //given
        LottoTicket lottoTicket = createLottoTicket();

        List<Integer> inputNumbers = Arrays.asList(4, 5, 6, 7, 8, 9);
        int bonusNumber = 10;
        WinningNumbers winningNumbers = new WinningNumbers(inputNumbers, bonusNumber);

        //when
        int matchedWinningNumber = winningNumbers.matchedWinningNumberCount(lottoTicket);

        //then
        assertThat(matchedWinningNumber).isEqualTo(3);
    }

    @Test
    @DisplayName("보너스 번호와 일치하는 로또 번호가 있는지 확인한다")
    void matched_bonus_number() {
        //given
        LottoTicket lottoTicket = createLottoTicket();

        List<Integer> inputNumbers = Arrays.asList(4, 5, 6, 7, 8, 9);
        int bonusNumber = 1;
        WinningNumbers winningNumbers = new WinningNumbers(inputNumbers, bonusNumber);

        //when
        boolean isMatchedBonusNumber = winningNumbers.isMatchedBonusNumber(lottoTicket);

        //then
        assertThat(isMatchedBonusNumber).isTrue();
    }

    private LottoTicket createLottoTicket() {
        List<LottoNumber> lottoNumbers = Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        return new LottoTicket(lottoNumbers);
    }
}
