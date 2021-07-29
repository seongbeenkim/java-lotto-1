package lotto.domain.dto.request;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoTicketsRequestTest {

    @Test
    @DisplayName("인자로 받은 수동 번호 모두가 정수 타입이 아닐 경우, 예외가 발생한다.")
    void validateNumbers() {
        //given
        List<String> inputManualLottoNumbers = Arrays.asList("1, 2, 3, 4, 5, 6.0", "일, 2, 3, 4, 5, 6");
        List<List<String>> allManualLottoNumbers = inputManualLottoNumbers.stream()
                .map(manualLottoNumbers -> Arrays.stream(manualLottoNumbers.split(",")))
                .map(lottoNumbers -> lottoNumbers.map(String::trim).collect(Collectors.toList()))
                .collect(Collectors.toList());

        //when //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoTicketsRequest(allManualLottoNumbers))
                .withMessage("로또 번호는 모두 정수 타입이여야 합니다.");
    }
}
