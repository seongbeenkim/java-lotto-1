package lotto;

import java.util.Objects;

public class LottoNumber {
    private final int lottoNumber;

    public LottoNumber(final int lottoNumber) {
        this.lottoNumber = lottoNumber;
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
