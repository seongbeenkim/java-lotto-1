package lotto.controller.dto.response;

import lotto.domain.WinningStatistics;
import lotto.domain.result.LottoResult;
import lotto.domain.result.LottoResults;
import lotto.domain.ticket.LottoTicketsCount;
import lotto.enums.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

public class WinningStatisticsResponseTest {

    @Test
    @DisplayName("등수별 개수, 총 수익률을 인자로 받아 dto 객체를 생성한다.")
    void create() {
        //given
        LottoTicketsCount lottoTicketsCount = new LottoTicketsCount(3);
        LottoResult firstRank = new LottoResult(entry(6, false));
        LottoResult secondRank = new LottoResult(entry(5, true));
        LottoResult thirdRank = new LottoResult(entry(5, false));
        LottoResults lottoResults = new LottoResults(Arrays.asList(firstRank, secondRank, thirdRank));
        WinningStatistics winningStatistics = new WinningStatistics(lottoResults);

        //when
        WinningStatisticsResponse winningStatisticsResponse = new WinningStatisticsResponse(winningStatistics.getRanks(), winningStatistics.calculateProfit(lottoTicketsCount));

        //then
        assertThat(winningStatisticsResponse.list()).hasSize(5)
                .extracting("rank")
                .contains(entry(LottoRank.FIRST, 1),
                        entry(LottoRank.SECOND, 1),
                        entry(LottoRank.THIRD, 1),
                        entry(LottoRank.FOURTH, 0),
                        entry(LottoRank.FIFTH, 0));
        assertThat(winningStatisticsResponse.getProfit()).isEqualTo(677166.7f);
    }
}
