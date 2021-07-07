package lotto;

import lotto.domain.LottoPrize;
import lotto.domain.LottoTicket;
import lotto.domain.WinningNumbers;
import lotto.domain.WinningStatistics;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
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

    @Test
    @DisplayName("당첨 번호 개수가 같은 로또 티켓 개수를 반환한다")
    void group_by_matched_count() {
        //given
        ArrayList<LottoTicket> lottoTickets = generateLottoTicketList();

        //when
        Map<Integer, Long> matchedCountStatistic = winningStatistics.groupByWinningNumber(lottoTickets);

        //then
        assertThat(matchedCountStatistic.get(3)).isEqualTo(1);
        assertThat(matchedCountStatistic.get(4)).isEqualTo(1);
        assertThat(matchedCountStatistic.get(5)).isNull();
        assertThat(matchedCountStatistic.get(6)).isNull();
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

    private ArrayList<LottoTicket> generateLottoTicketList() {
        ArrayList<LottoTicket> lottoTicketList = new ArrayList<>();
        lottoTicketList.add(new LottoTicket(3, 4, 5, 6, 7, 8)); // 4개 일치
        lottoTicketList.add(new LottoTicket(4, 5, 6, 7, 8, 9)); // 3개 일치
        lottoTicketList.add(new LottoTicket(5, 6, 7, 8, 9, 10)); // 2개 일치
        lottoTicketList.add(new LottoTicket(6, 7, 8, 9, 10, 11)); // 1개 일치
        lottoTicketList.add(new LottoTicket(7, 8, 9, 10, 11, 12)); // 0개 일치
        lottoTicketList.add(new LottoTicket(8, 9, 10, 11, 12, 13)); //0개 일치
        return lottoTicketList;
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
