package lotto.domain;

import java.util.Map;

public class LottoResult {
    private final Map.Entry<Integer, Boolean> lottoResult;

    public LottoResult(final Map.Entry<Integer, Boolean> lottoResult) {
        this.lottoResult = lottoResult;
    }

    public Integer matchedCount() {
        return lottoResult.getKey();
    }

    public Boolean hasBonusNumber() {
        return lottoResult.getValue();
    }
}
