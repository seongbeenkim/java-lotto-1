package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.LottoNumber.MAX_LOTTO_BOUND;
import static lotto.LottoNumber.MIN_LOTTO_BOUND;

public class LottoGenerator {

    private static final List<LottoNumber> lottoNumberContainer = create();

    private static List<LottoNumber> create() {
        return IntStream.rangeClosed(MIN_LOTTO_BOUND, MAX_LOTTO_BOUND)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public List<LottoNumber> lottoNumbers() {
        Collections.shuffle(lottoNumberContainer);
        return lottoNumberContainer.subList(0, 6);
    }

}