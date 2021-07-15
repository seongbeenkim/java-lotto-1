package lotto.domain;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import static lotto.domain.LottoTicket.LOTTO_NUMBERS_COUNT;

public class WinningNumbers {
    private static final String DEFUALT_DELIMITER = ",";

    private final List<LottoNumber> winningNumbers;
    private final LottoNumber bonusNumber;

    public WinningNumbers(final String winningNumbers, final String bonusNumber) {
        this(toLottoNumbers(winningNumbers), LottoNumber.valueOf(Integer.parseInt(bonusNumber)));
    }

    public WinningNumbers(final String winningNumbers, final int bonusNumber) {
        this(toLottoNumbers(winningNumbers), LottoNumber.valueOf(bonusNumber));
    }

    private static List<LottoNumber> toLottoNumbers(final String winningNumbers) {
        return Arrays.stream(winningNumbers.split(DEFUALT_DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .map(LottoNumber::valueOf)
                .collect(Collectors.toList());
    }

    public WinningNumbers(final List<LottoNumber> winningNumbers, final LottoNumber bonusNumber) {
        validateCountOf(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateCountOf(final List<LottoNumber> winningNumbers, final LottoNumber bonusNumber) {
        Set<LottoNumber> deduplicatedWinningNumbers = new HashSet<>(winningNumbers);

        if (deduplicatedWinningNumbers.contains(bonusNumber) || (deduplicatedWinningNumbers.size() != LOTTO_NUMBERS_COUNT)) {
            throw new IllegalArgumentException("서로 다른 번호가 7개여야 합니다.");
        }
    }

    public LottoResult match(final LottoTicket lottoTicket) {
        List<LottoNumber> lottoNumbers = lottoTicket.getLottoNumbers();

        int matchedCount = (int) lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count();

        boolean hasBonusNumber = lottoNumbers.contains(bonusNumber);
        return new LottoResult(new AbstractMap.SimpleEntry<>(matchedCount, hasBonusNumber));
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
