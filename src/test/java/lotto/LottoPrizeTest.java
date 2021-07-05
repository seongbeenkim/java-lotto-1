package lotto;

import lotto.domain.LottoPrize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoPrizeTest {

    @ParameterizedTest
    @CsvSource(value = {"6, false, 2000000000", "5, true, 30000000", "5, false, 1500000", "4, false, 50000", "3, false, 5000"})
    @DisplayName("로또 당첨 순위를 확인한다")
    void lotto_prizes(int matchedWinningNumberCount, boolean isMatchedBonusNumber, int prizeMoney) {
        //given

        //when
        int prize = LottoPrize.prize(matchedWinningNumberCount, isMatchedBonusNumber);

        //then
        assertThat(prize).isEqualTo(prizeMoney);
    }
}
