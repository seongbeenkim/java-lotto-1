package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;
import static org.assertj.core.api.Assertions.tuple;

public class WinningStatisticsTest {
    private WinningStatistics winningStatistics;

    @BeforeEach
    void setUp() {
        winningStatistics = new WinningStatistics(createLottoResults());
    }

    @Test
    @DisplayName("당첨 등수와 당첨 등수에 해당하는 갯수를 반환한다.")
    void ranksCount() {
        //given //when
        Map<LottoRank, Integer> ranks = winningStatistics.ranks();

        //then
        assertThat(ranks).hasSize(5)
                .extractingFromEntries(entry -> tuple(entry.getKey(), entry.getValue()))
                .contains(
                        tuple(LottoRank.FIRST, 1),
                        tuple(LottoRank.SECOND, 1),
                        tuple(LottoRank.THIRD, 1),
                        tuple(LottoRank.FOURTH, 2),
                        tuple(LottoRank.FIFTH, 2)
                );

    }

    @ParameterizedTest
    @CsvSource(value = {"6, false, 2000000.0f", "5, true, 30000.0f", "5, false, 1500.f", "4, false, 50.0f", "3, false, 5.0f", "2, false, 0.0f"})
    @DisplayName("총 수익률을 반환한다.")
    void profit(int matchedCount, boolean hasBonus, float expectedProfit) {
        //given
        LottoResult lottoResult = new LottoResult(entry(matchedCount, hasBonus));
        NumberOfTickets numberOfTickets = new NumberOfTickets(1);
        WinningStatistics winningStatistics = new WinningStatistics(Collections.singletonList(lottoResult));

        //when
        double profit = winningStatistics.profit(numberOfTickets);

        //then
        assertThat(profit).isEqualTo(expectedProfit);
    }

    private List<LottoResult> createLottoResults() {
        List<Entry<Integer, Boolean>> lottoResults = new ArrayList<>();
        lottoResults.add(entry(6, false));
        lottoResults.add(entry(5, true));
        lottoResults.add(entry(5, false));
        lottoResults.add(entry(4, true));
        lottoResults.add(entry(4, false));
        lottoResults.add(entry(3, true));
        lottoResults.add(entry(3, false));

        return lottoResults
                .stream()
                .map(LottoResult::new)
                .collect(Collectors.toList());
    }
}
