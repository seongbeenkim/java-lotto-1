package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;
import static org.assertj.core.api.Assertions.tuple;

public class WinningStatisticsTest {

    @Test
    @DisplayName("당첨 등수와 당첨 등수에 해당하는 개수를 반환한다.")
    void ranksCount() {

        //given
        WinningStatistics winningStatistics = new WinningStatistics(createLottoResults());

        //when
        Map<LottoRank, Integer> ranks = winningStatistics.ranksCount();

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
