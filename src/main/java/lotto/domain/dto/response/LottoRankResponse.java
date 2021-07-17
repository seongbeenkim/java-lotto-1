package lotto.domain.dto.response;

import lotto.enums.LottoRank;

import java.util.AbstractMap;
import java.util.Map;

public class LottoRankResponse {
    private final Map.Entry<LottoRank, Integer> rank;

    public LottoRankResponse(final Map.Entry<LottoRank, Integer> rank) {
        this.rank = new AbstractMap.SimpleEntry<>(rank);
    }

    public int getMatchedLottoNumbersCount() {
        return rank.getKey().getMatchedCount();
    }

    public long getPrize() {
        return rank.getKey().getPrize();
    }

    public int getMatchedRankCount() {
        return rank.getValue();
    }

    public boolean hasBouns() {
        return rank.getKey().equals(LottoRank.SECOND);
    }
}
