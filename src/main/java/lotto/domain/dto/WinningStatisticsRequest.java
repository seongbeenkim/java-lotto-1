package lotto.domain.dto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class WinningStatisticsRequest {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningStatisticsRequest(final List<String> winningNumbers, final String bonusNumber) {
        this.winningNumbers = convertToIntegers(winningNumbers);
        this.bonusNumber = convertToInteger(bonusNumber);
    }

    private List<Integer> convertToIntegers(final List<String> winningNumbers) {
        try {
            return winningNumbers.stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("당첨 번호는 모두 정수 타입이여야 합니다.");
        }
    }

    private int convertToInteger(final String bonusNumber) {
        try {
            return Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("보너스 번호는 정수 타입이여야 합니다.");
        }
    }

    public List<Integer> getWinningNumbers() {
        return Collections.unmodifiableList(winningNumbers);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
