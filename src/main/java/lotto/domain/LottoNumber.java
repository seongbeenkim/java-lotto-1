package lotto.domain;

import java.util.Objects;

public class LottoNumber {
    private static final int LOTTO_NUMBER_MIN_BOUND = 1;
    private static final int LOTTO_NUMBER_MAX_BOUND = 45;

    private int lottoNumber;

    public LottoNumber(final int lottoNumber) {
        validateBoundOf(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void validateBoundOf(int lottoNumber) {
        if (lottoNumber < LOTTO_NUMBER_MIN_BOUND || lottoNumber > LOTTO_NUMBER_MAX_BOUND) {
            throw new IllegalArgumentException("로또 번호는 1 ~ 45여야 합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }
}
