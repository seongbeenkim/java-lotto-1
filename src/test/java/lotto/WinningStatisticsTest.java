package lotto;

import lotto.domain.LottoPrize;
import lotto.domain.WinningNumbers;
import lotto.domain.WinningStatistics;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningStatisticsTest {
    private static WinningNumbers winningNumbers = generateWinningNumber();
    private static WinningStatistics winningStatistics = new WinningStatistics(winningNumbers);

    private static WinningNumbers generateWinningNumber() {
        List<Integer> inputNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 45;
        return new WinningNumbers(inputNumbers, bonusNumber);
    }

    @ParameterizedTest
    @MethodSource("generateProfit")
    @DisplayName("당첨 순위의 수익률을 계산한다")
    void profit_rate(int[] matchedCounts, boolean matchedBonusNumber, float expectedProfit) {
        //given
        int totalPrize = Arrays.stream(matchedCounts)
                .map(matchedCount -> LottoPrize.prize(matchedCount, matchedBonusNumber))
                .sum();

        //when
        float profit = winningStatistics.profitRate(matchedCounts.length, totalPrize);

        //then
        assertThat(profit).isEqualTo(expectedProfit);
    }

    private static Stream<Arguments> generateProfit() {
        return Stream.of(
                Arguments.of(new int[]{0, 1, 2}, false, 0.0f),
                Arguments.of(new int[]{1, 1, 1, 3}, false, 1.25f),
                Arguments.of(new int[]{1, 2, 2, 3, 3}, false, 2.0f),
                Arguments.of(new int[]{0, 1, 0, 0, 4}, false, 10.0f),
                Arguments.of(new int[]{0, 1, 0, 0, 5}, false, 300.0f),
                Arguments.of(new int[]{0, 1, 0, 0, 5}, true, 6000.0f),
                Arguments.of(new int[]{0, 1, 0, 0, 6}, false, 400000.0f)
        );
    }
}
