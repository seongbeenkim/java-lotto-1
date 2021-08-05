package lotto.controller.dto.request;

import lotto.domain.number.WinningNumbers;

import java.util.List;
import java.util.stream.Collectors;

public class WinningStatisticsRequest {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningStatisticsRequest(final List<String> winningNumbers, final String bonusNumber) {
        this.winningNumbers = convertToIntegers(winningNumbers);
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    private List<Integer> convertToIntegers(final List<String> winningNumbers) {
        return winningNumbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public WinningNumbers getWinningNumbers() {
        return new WinningNumbers(winningNumbers, bonusNumber);
    }
}
