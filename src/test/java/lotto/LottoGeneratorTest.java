package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {

    @Test
    @DisplayName("6개의 로또 번호를 반환한다")
    void lotto_generator() {
        //given
        LottoGenerator lottoGenerator = new LottoGenerator();

        //when
        List<LottoNumber> lottoNumbers = lottoGenerator.issueAutoLottoNumbers();

        //then
        assertThat(lottoNumbers).hasSize(6);
    }
}
