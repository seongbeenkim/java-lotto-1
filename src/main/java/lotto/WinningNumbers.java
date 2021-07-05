package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class WinningNumbers {
    private static final int WINNING_NUMBER_SIZE = 7;

    private final List<LottoNumber> winningNumbers;
    private final LottoNumber bonusNumber;


    public WinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        this(winningNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList()), new LottoNumber(bonusNumber));
    }

    public WinningNumbers(List<LottoNumber> winningNumbers, LottoNumber bonusNumber) {
        validateDuplication(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplication(List<LottoNumber> winningNumbers, LottoNumber bonusNumber) {
        winningNumbers.add(bonusNumber);
        HashSet<LottoNumber> lottoNumbers = new HashSet<>(winningNumbers);

        if (lottoNumbers.size() < WINNING_NUMBER_SIZE) {
            throw new IllegalArgumentException("당첨 번호가 중복됩니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningNumbers that = (WinningNumbers) o;
        return Objects.equals(winningNumbers, that.winningNumbers) &&
                Objects.equals(bonusNumber, that.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningNumbers, bonusNumber);
    }
}
