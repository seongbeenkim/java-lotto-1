package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.AbstractMap;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRankTest {

    @ParameterizedTest
    @CsvSource(value = {"6, false, FIRST", "5, true, SECOND", "5, false, THIRD", "4, false, FOURTH",
            "4, true, FOURTH", "3, false, FIFTH", "3, true, FIFTH", "2, false, NONE", "2, true, NONE"})
    @DisplayName("로또 비교 결과 객체에 해당하는 로또 등수를 반환한다.")
    void findBy(int matchedCount, boolean hasBonusNumber, String rankName) {
        //given
        LottoResult lottoResult = new LottoResult(new AbstractMap.SimpleEntry<>(matchedCount, hasBonusNumber));

        //when
        LottoRank rank = LottoRank.findBy(lottoResult);

        //then
        assertThat(rank).isEqualTo(LottoRank.valueOf(rankName));
    }
}
