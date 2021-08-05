package lotto.controller.dto.request;

import lotto.domain.number.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningStatisticsRequestTest {

    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5, 6.0", "일, 2, 3, 4, 5, 6"})
    @DisplayName("인자로 받은 당첨 번호 모두가 정수 타입이 아닐 경우, 예외가 발생한다.")
    void validateIntegers_winning_numbers(String winningNumbers) {
        //given
        String bonusNumber = "7";
        List<String> splitWinningNumber = Arrays.stream(winningNumbers.split(","))
                .map(String::trim)
                .collect(Collectors.toList());

        //when //then
        assertThatThrownBy(() -> new WinningStatisticsRequest(splitWinningNumber, bonusNumber))
                .isInstanceOf(NumberFormatException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"일", "45.0"})
    @DisplayName("인자로 받은 보너스 번호가 정수 타입이 아닐 경우, 예외가 발생한다.")
    void validateInteger_(String bonusNumber) {
        //given
        String winningNumbers = "1, 2, 3, 4, 5, 6";
        List<String> splitWinningNumber = Arrays.stream(winningNumbers.split(","))
                .map(String::trim)
                .collect(Collectors.toList());

        //when //then
        assertThatThrownBy(() -> new WinningStatisticsRequest(splitWinningNumber, bonusNumber))
                .isInstanceOf(NumberFormatException.class);
    }

    @Test
    @DisplayName("당첨 번호를 반환한다.")
    void getWinningNumbers() {
        //given
        List<String> splitWinningNumber = Arrays.stream("1, 2, 3, 4, 5, 6".split(","))
                .map(String::trim)
                .collect(Collectors.toList());
        WinningStatisticsRequest winningStatisticsRequest = new WinningStatisticsRequest(splitWinningNumber, "7");

        //when
        WinningNumbers winningNumbers = winningStatisticsRequest.getWinningNumbers();

        //then
        assertThat(winningNumbers).isNotNull();
    }
}
