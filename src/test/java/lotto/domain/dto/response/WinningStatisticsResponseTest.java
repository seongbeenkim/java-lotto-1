package lotto.domain.dto.response;

import lotto.domain.LottoResult;
import lotto.domain.NumberOfTickets;
import lotto.domain.WinningStatistics;
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
        NumberOfTickets numberOfTickets = new NumberOfTickets(3);
        LottoResult firstRank = new LottoResult(entry(6, false));
        LottoResult secondRank = new LottoResult(entry(5, true));
        LottoResult thirdRank = new LottoResult(entry(5, false));
        WinningStatistics winningStatistics = new WinningStatistics(Arrays.asList(firstRank, secondRank, thirdRank));

        //when
        WinningStatisticsResponse winningStatisticsResponse = new WinningStatisticsResponse(winningStatistics.getRanks(), winningStatistics.calculateProfit(numberOfTickets));

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
