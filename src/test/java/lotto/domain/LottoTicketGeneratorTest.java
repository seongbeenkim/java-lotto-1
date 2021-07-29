package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketGeneratorTest {

    @Test
    @DisplayName("입력받은 티켓 장수 만큼 자동으로 생성한 로또 티켓들을 반환한다.")
    void createAutoTicket() {
        //given
        LottoTicketsCount lottoTicketsCount = new LottoTicketsCount(10);

        //when
        LottoTickets lottoTickets = LottoTicketGenerator.createAutoTickets(lottoTicketsCount);

        //then
        assertThat(lottoTickets.list()).hasSize(10);
    }
    
    @Test
    @DisplayName("입력받은 로또 번호를 가지고 생성한 로또 티켓들을 반환한다.")
    void createManualTickets() {
        //given
        List<LottoNumber> firstLottoNumbers = LottoNumber.of(1, 2, 3, 4, 5, 6);
        List<LottoNumber> secondLottoNumbers = LottoNumber.of(7, 8, 9, 10, 11, 12);

        //when
        LottoTickets lottoTickets = LottoTicketGenerator.createManualTickets(Arrays.asList(firstLottoNumbers, secondLottoNumbers));

        //then
        assertThat(lottoTickets.list())
                .extracting("lottoNumbers")
                .contains(firstLottoNumbers, secondLottoNumbers);
    }
}
