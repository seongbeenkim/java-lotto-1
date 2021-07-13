package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.AbstractMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    @Test
    @DisplayName("당첨 번호와 로또 티켓 번호 비교한 결과를 담는 객체를 생성한다.")
    void create() {
        //given
        int matchedCount = 1;
        Map.Entry<Integer, Boolean> matchedResult = new AbstractMap.SimpleEntry<>(matchedCount, true);

        //when
        LottoResult lottoResult = new LottoResult(matchedResult);

        //then
        assertThat(lottoResult.matchedCount()).isEqualTo(matchedCount);
        assertThat(lottoResult.hasBonusNumber()).isTrue();
    }

    @Test
    @DisplayName("전달받은 일치 갯수가 같을 경우, 참을 반환한다.")
    void hasSame() {
        //given
        int matchedCount = 10;
        Map.Entry<Integer, Boolean> matchedResult = new AbstractMap.SimpleEntry<>(matchedCount, true);
        LottoResult lottoResult = new LottoResult(matchedResult);

        //when
        boolean hasSameMatchedCount = lottoResult.hasSame(matchedCount);

        //then
        assertThat(hasSameMatchedCount).isTrue();
    }
}
