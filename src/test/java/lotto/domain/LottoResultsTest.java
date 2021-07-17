package lotto.domain;

import lotto.enums.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

public class LottoResultsTest {

    @Test
    @DisplayName("로또 티켓들의 등수를 반환한다.")
    void findAllRanks() {
        //given
        LottoResult firstRank = new LottoResult(entry(6, false));
        LottoResult secondRank = new LottoResult(entry(5, true));
        LottoResult thirdRank = new LottoResult(entry(5, false));
        LottoResults lottoResults = new LottoResults(Arrays.asList(firstRank, secondRank, thirdRank));

        //when
        List<LottoRank> ranks = lottoResults.findAllRanks();
        //then
        assertThat(ranks).hasSize(3)
                .extracting("name")
                .contains("FIRST",
                        "SECOND",
                        "THIRD");
    }
}
