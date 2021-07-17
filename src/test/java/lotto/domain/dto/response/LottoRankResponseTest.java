package lotto.domain.dto.response;

import lotto.enums.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

public class LottoRankResponseTest {

    @Test
    @DisplayName("한 개의 등수에 대한 통계를 인자로 전달받아 dto 객체를 생성한다.")
    void create() {
        //given
        int matchedRankCount = 4;
        Map.Entry<LottoRank, Integer> firstRank = entry(LottoRank.FIRST, matchedRankCount);

        //when
        LottoRankResponse lottoRankResponse = new LottoRankResponse(firstRank);

        //then
        assertThat(lottoRankResponse.getMatchedLottoNumbersCount()).isEqualTo(LottoRank.FIRST.getMatchedCount());
        assertThat(lottoRankResponse.getPrize()).isEqualTo(LottoRank.FIRST.getPrize());
        assertThat(lottoRankResponse.getMatchedRankCount()).isEqualTo(matchedRankCount);
        assertThat(lottoRankResponse.hasBouns()).isFalse();
    }
}
