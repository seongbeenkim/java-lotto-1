package lotto;

import java.util.Objects;

public class LottoNumber {
    public static final int MIN_LOTTO_BOUND = 1;
    public static final int MAX_LOTTO_BOUND = 45;

    private final int lottoNumber;

    public LottoNumber(final int lottoNumber) {
        validateBound(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void validateBound(int lottoNumber) {
        if (lottoNumber < MIN_LOTTO_BOUND || lottoNumber > MAX_LOTTO_BOUND) {
            throw new IllegalArgumentException("로또 번호는 1 ~ 45 까지 입니다.");
        }
    }

    public int value() {
        return lottoNumber;
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
