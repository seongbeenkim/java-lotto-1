package lotto;

import lotto.domain.LottoPrize;
import lotto.domain.LottoTicket;
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

    @ParameterizedTest
    @MethodSource("generateLottoTicket")
    @DisplayName("당첨 번호와 일치하는 로또 티켓 개수를 반환한다")
    void winning_number_match_count_statistics(int[] numbers, int expectedCount) {
        //given
        LottoTicket lottoTicket = new LottoTicket(numbers);

        List<Integer> inputNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 45;
        WinningNumbers winningNumbers = new WinningNumbers(inputNumbers, bonusNumber);

        //when
        WinningStatistics winningStatistics = new WinningStatistics();
        int matchedCount = winningStatistics.matchedCount(lottoTicket, winningNumbers);

        //then
        assertThat(matchedCount).isEqualTo(expectedCount);
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
        WinningStatistics winningStatistics = new WinningStatistics();
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
