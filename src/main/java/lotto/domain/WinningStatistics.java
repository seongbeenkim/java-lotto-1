package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class WinningStatistics {
    private static final int EMPTY = 0;

    private final Map<LottoRank, Integer> ranks = new LinkedHashMap<>();

    public WinningStatistics(final List<LottoResult> lottoResults) {
        validateNull(lottoResults);
        initRanks();
        countRanks(new ArrayList<>(lottoResults));
    }

    private void validateNull(List<LottoResult> lottoResults) {
        if (lottoResults == null) {
            throw new IllegalArgumentException("1개 이상의 로또 결과 목록이 존재해야 합니다.");
        }
    }

    private void initRanks() {
        Arrays.stream(LottoRank.values())
                .sorted(Comparator.reverseOrder())
                .filter(LottoRank::isNotNoneRank)
                .forEach(lottoRank -> ranks.put(lottoRank, EMPTY));
    }

    private void countRanks(final List<LottoResult> lottoResults) {
        lottoResults.stream()
                .map(LottoRank::findBy)
                .filter(LottoRank::isNotNoneRank)
                .forEach(lottoRank -> ranks.put(lottoRank, ranks.get(lottoRank) + 1));
    }

    public Map<LottoRank, Integer> getRanks() {
        return ranks;
    }

    public float calculateProfit(final NumberOfTickets numberOfTickets) {
        int totalPrize = ranks.keySet()
                .stream()
                .mapToInt(rank -> rank.multiplyPrizeBy(ranks.get(rank)))
                .sum();

        return (float) totalPrize / numberOfTickets.getPaidPurchaseAmount();
    }
}
