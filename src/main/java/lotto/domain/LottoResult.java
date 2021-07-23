package lotto.domain;

import java.util.AbstractMap;
import java.util.Map.Entry;

public class LottoResult {
    private final Entry<Integer, Boolean> lottoResult;

    public LottoResult(final Entry<Integer, Boolean> lottoResult) {
        this.lottoResult = new AbstractMap.SimpleEntry<>(lottoResult);
    }

    public int getMatchedCount() {
        return lottoResult.getKey();
    }

    public boolean hasBonusNumber() {
        return lottoResult.getValue();
    }

    public boolean hasSame(int matchedCount) {
        return lottoResult.getKey() == matchedCount;
    }
}
