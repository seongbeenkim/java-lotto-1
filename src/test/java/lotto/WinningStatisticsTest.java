package lotto;

import lotto.domain.LottoPrize;
import lotto.domain.LottoTicket;
import lotto.domain.WinningNumbers;
import lotto.domain.WinningStatistics;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningStatisticsTest {
    private WinningNumbers winningNumbers = generateWinningNumber();

    private WinningNumbers generateWinningNumber() {
        List<Integer> inputNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 45;
        return new WinningNumbers(inputNumbers, bonusNumber);
    }

    @Test
    @DisplayName("당첨 번호 개수가 같은 로또 티켓 개수를 반환한다")
    void group_by_matched_count() {
        //given
        WinningStatistics winningStatistics = new WinningStatistics(winningNumbers);
        List<LottoTicket> lottoTickets = generateLottoTicketList();

        //when
        Map<LottoPrize, Integer> ranks = winningStatistics.groupByWinningNumber(lottoTickets);

        //then
        assertThat(ranks.get(LottoPrize.FIFTH)).isEqualTo(1);
        assertThat(ranks.get(LottoPrize.FOURTH)).isEqualTo(1);
        assertThat(ranks.get(LottoPrize.THIRD)).isZero();
        assertThat(ranks.get(LottoPrize.FIRST)).isZero();
    }

    @Test
    @DisplayName("당첨 순위의 수익률을 계산한다")
    void profit_rate() {
        //given
        WinningStatistics winningStatistics = new WinningStatistics(winningNumbers);
        Map<LottoPrize, Integer> ranks = winningStatistics.groupByWinningNumber(generateLottoTicketList());

        //when
        float profit = winningStatistics.profitRate(5, ranks);

        //then
        assertThat(profit).isEqualTo(11.0f);
    }

    private ArrayList<LottoTicket> generateLottoTicketList() {
        ArrayList<LottoTicket> lottoTicketList = new ArrayList<>();
        lottoTicketList.add(new LottoTicket(3, 4, 5, 6, 7, 8)); // 4개 일치 - 1
        lottoTicketList.add(new LottoTicket(4, 5, 6, 7, 8, 9)); // 3개 일치 - 1
        lottoTicketList.add(new LottoTicket(5, 6, 7, 8, 9, 10)); // 2개 일치
        lottoTicketList.add(new LottoTicket(6, 7, 8, 9, 10, 11)); // 1개 일치
        lottoTicketList.add(new LottoTicket(7, 8, 9, 10, 11, 12)); // 0개 일치
        return lottoTicketList;
    }
}
