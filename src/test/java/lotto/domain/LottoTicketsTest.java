package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketsTest {

    @Test
    @DisplayName("로또 티켓들을 인자로 가진 로또 티켓 목록 객체를 생성한다.")
    void create() {
        //given
        LottoTicket firstLottoTicket = new LottoTicket(LottoNumber.of(1, 2, 3, 4, 5, 6));
        LottoTicket secondLottoTicket = new LottoTicket(LottoNumber.of(1, 2, 3, 4, 5, 7));

        //when
        LottoTickets lottoTickets = new LottoTickets(Arrays.asList(firstLottoTicket, secondLottoTicket));

        //then
        assertThat(lottoTickets.list()).hasSize(2);
    }

    @Test
    @DisplayName("당첨번호와 각 로또 티켓의 번호를 비교하여, 보너스 번호 제외하고 3개 이상 일치하는 결과들을 반환한다.")
    void match() {
        //given
        List<LottoNumber> firstRankLottoNumbers = LottoNumber.of(1, 2, 3, 4, 5, 6);
        LottoNumber bonusNumber = LottoNumber.valueOf(7);
        WinningNumbers winningNumbers = new WinningNumbers(firstRankLottoNumbers, bonusNumber);

        List<LottoNumber> noneRankLottoNumbers = LottoNumber.of(5, 6, 7, 8, 9, 10);
        LottoTicket firstRankTicket = new LottoTicket(firstRankLottoNumbers);
        LottoTicket noneRankTicket = new LottoTicket(noneRankLottoNumbers);
        LottoTickets lottoTickets = new LottoTickets(Arrays.asList(firstRankTicket, noneRankTicket));

        //when
        LottoResults lottoResults = lottoTickets.match(winningNumbers);

        //then
        assertThat(lottoResults.list()).hasSize(1);
    }

    @Test
    @DisplayName("인자로 받은 로또 티켓들을 추가한 새로운 로또 티켓을 반환한다.")
    void add() {
        //given
        List<LottoNumber> firstRankLottoNumbers = LottoNumber.of(1, 2, 3, 4, 5, 6);
        List<LottoNumber> noneRankLottoNumbers = LottoNumber.of(5, 6, 7, 8, 9, 10);
        LottoTicket firstRankTicket = new LottoTicket(firstRankLottoNumbers);
        LottoTicket noneRankTicket = new LottoTicket(noneRankLottoNumbers);
        LottoTickets lottoTickets1 = new LottoTickets(Collections.singletonList(firstRankTicket));
        LottoTickets lottoTickets2 = new LottoTickets(Collections.singletonList(noneRankTicket));

        //when
        LottoTickets combinedLottoTickets = lottoTickets1.add(lottoTickets2);

        //then
        assertThat(combinedLottoTickets.list())
                .hasSize(2)
                .extracting("lottoNumbers")
                .contains(firstRankLottoNumbers, noneRankLottoNumbers);
    }
}
