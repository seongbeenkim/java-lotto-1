package lotto.domain.number;

import lotto.domain.result.LottoResult;
import lotto.domain.ticket.LottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

public class WinningNumbersTest {

    @ParameterizedTest
    @CsvSource(value = {"1, 2, 3, 4, 5, 5 : 6", "1, 2, 3, 4, 5, 6 : 6"}, delimiter = ':')
    @DisplayName("보너스 볼 포함 서로 다른 번호가 7개가 아닐 경우, 예외가 발생한다.")
    void validateCountOf(String winningNumbers, int bonusNumber) {
        // given
        List<Integer> splitWinningNumber = Arrays.stream(winningNumbers.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        // when //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningNumbers(splitWinningNumber, bonusNumber))
                .withMessage("서로 다른 번호가 7개여야 합니다.");
    }

    @Test
    @DisplayName("당첨 번호를 인자로 받아 각 로또 티켓과 비교한 결과를 반환한다.")
    void match() {
        //given
        List<LottoNumber> firstRankLottoNumbers = LottoNumber.of(1, 2, 3, 4, 5, 6);
        LottoNumber bonusNumber = LottoNumber.valueOf(7);
        WinningNumbers winningNumbers = new WinningNumbers(firstRankLottoNumbers, bonusNumber);

        List<LottoNumber> secondRankLottoNumbers = LottoNumber.of(1, 2, 3, 4, 5, 7);
        LottoTicket firstRankTicket = new LottoTicket(firstRankLottoNumbers);
        LottoTicket secondRankTicket = new LottoTicket(secondRankLottoNumbers);

        //when
        LottoResult firstRank = winningNumbers.match(firstRankTicket);
        LottoResult secondRank = winningNumbers.match(secondRankTicket);

        //then
        assertAll(
                () -> assertThat(firstRank.getMatchedCount()).isEqualTo(6),
                () -> assertThat(firstRank.hasBonusNumber()).isFalse(),
                () -> assertThat(secondRank.getMatchedCount()).isEqualTo(5),
                () -> assertThat(secondRank.hasBonusNumber()).isTrue()
        );
    }
}