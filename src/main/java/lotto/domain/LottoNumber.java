package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber {
    static final int LOTTO_NUMBER_MIN_BOUND = 1;
    static final int LOTTO_NUMBER_MAX_BOUND = 45;
    private static final Map<Integer, LottoNumber> lottoNumbers = generateLottoNumbers();

    private final int lottoNumber;

    private static Map<Integer, LottoNumber> generateLottoNumbers() {
        return IntStream.rangeClosed(LOTTO_NUMBER_MIN_BOUND, LOTTO_NUMBER_MAX_BOUND)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toMap(LottoNumber::value, Function.identity()));
    }

    public int value() {
        return lottoNumber;
    }

    private LottoNumber(final int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber valueOf(final int lottoNumber) {
        validateBoundOf(lottoNumber);
        return lottoNumbers.get(lottoNumber);
    }

    public static List<LottoNumber> of(final int... lottoNumbers) {
        return Arrays.stream(lottoNumbers)
                .mapToObj(LottoNumber::valueOf)
                .collect(Collectors.toList());
    }

    private static void validateBoundOf(final int lottoNumber) {
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
