package lotto.domain;

import java.util.Map;

public class LottoResult {
    private final Map.Entry<Integer, Boolean> lottoResult;

    public LottoResult(final Map.Entry<Integer, Boolean> lottoResult) {
        this.lottoResult = lottoResult;
    }

    public int matchedCount() {
        return lottoResult.getKey();
    }

    public boolean hasBonusNumber() {
        return lottoResult.getValue();
    }

    public boolean hasSame(int matchedCount) {
        return lottoResult.getKey() == matchedCount;
    }
}
