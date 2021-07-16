package lotto.domain.dto;

import lotto.domain.LottoRank;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WinningStatisticsResponse {
    private final Map<LottoRank, Integer> ranks;
    private final float profit;

    public WinningStatisticsResponse(final Map<LottoRank, Integer> ranks, final float profit) {
        this.ranks = new LinkedHashMap<>(ranks);
        this.profit = profit;
    }

    public List<LottoRankResponse> list() {
        return Collections.unmodifiableList(ranks.entrySet()
                .stream()
                .map(LottoRankResponse::new)
                .collect(Collectors.toList()));
    }

    public float getProfit() {
        return profit;
    }
}
