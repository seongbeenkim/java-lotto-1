package lotto.enums;

import lotto.domain.result.LottoResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

public class LottoRankTest {

    @ParameterizedTest
    @CsvSource(value = {"6, false, FIRST", "5, true, SECOND", "5, false, THIRD", "4, false, FOURTH",
            "4, true, FOURTH", "3, false, FIFTH", "3, true, FIFTH", "2, false, NONE", "2, true, NONE"})
    @DisplayName("로또 비교 결과 객체에 해당하는 로또 등수를 반환한다.")
    void findBy(int matchedCount, boolean hasBonusNumber, String rankName) {
        //given
        LottoResult lottoResult = new LottoResult(entry(matchedCount, hasBonusNumber));

        //when
        LottoRank rank = LottoRank.findBy(lottoResult);

        //then
        assertThat(rank).isEqualTo(LottoRank.valueOf(rankName));
    }

    @ParameterizedTest
    @CsvSource(value = {"FIRST, 2000000000", "SECOND, 30000000", "THIRD, 1500000", "FOURTH, 50000", "FIFTH, 5000", "NONE, 0"})
    @DisplayName("당첨 등수에 맞는 상금을 반환하는 기능")
    void getPrize(String rankName, int expectedPrize) {
        //given
        LottoRank lottoRank = LottoRank.valueOf(rankName);

        //when
        int prize = lottoRank.getPrize();

        //then
        assertThat(prize).isEqualTo(expectedPrize);
    }
}
