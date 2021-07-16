package lotto.domain.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class WinningStatisticsRequestTest {

    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5, 6.0", "일, 2, 3, 4, 5, 6"})
    @DisplayName("인자로 받은 당첨 번호 모두가 정수 타입이 아닐 경우, 예외가 발생한다.")
    void validateNumbers(String winningNumbers) {
        //given
        String bonusNumber = "7";
        List<String> splitWinningNumber = Arrays.stream(winningNumbers.split(","))
                .map(String::trim)
                .collect(Collectors.toList());

        //when //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningStatisticsRequest(splitWinningNumber, bonusNumber))
                .withMessage("당첨 번호는 모두 정수 타입이여야 합니다.");
    }
}
