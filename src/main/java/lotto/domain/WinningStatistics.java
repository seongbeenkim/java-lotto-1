package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static lotto.domain.LottoRank.FIFTH;

public class WinningStatistics {
    private static final int EMPTY = 0;

    private final List<LottoResult> lottoResults;
    private final Map<LottoRank, Integer> ranks = new LinkedHashMap<>();

    public WinningStatistics(final List<LottoResult> lottoResults) {
        this.lottoResults = new ArrayList<>(lottoResults);
        countRanks();
    }

    private void countRanks() {
        Arrays.stream(LottoRank.values())
                .sorted(Comparator.reverseOrder())
                .filter(lottoRank -> lottoRank.matchedCount() >= FIFTH.matchedCount())
                .forEach(lottoRank -> ranks.put(lottoRank, EMPTY));

        lottoResults.stream()
                .map(LottoRank::findBy)
                .forEach(lottoRank -> ranks.put(lottoRank, ranks.getOrDefault(lottoRank, EMPTY) + 1));
    }

    public Map<LottoRank, Integer> ranks() {
        return ranks;
    }

    public float profit(final NumberOfTickets numberOfTickets) {
        int totalPrize = ranks.entrySet()
                .stream()
                .mapToInt(entry -> entry.getKey().multiplyPrizeBy(entry.getValue()))
                .sum();

        return totalPrize / numberOfTickets.purchaseAmount();
    }
}
