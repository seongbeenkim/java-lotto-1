package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static lotto.domain.LottoRank.FIFTH;

public class WinningStatistics {
    private final List<LottoResult> lottoResults;
    private final Map<LottoRank, Integer> ranks = new LinkedHashMap<>();

    public WinningStatistics(final List<LottoResult> lottoResults) {
        this.lottoResults = new ArrayList<>(lottoResults);
        initialize();
    }

    private void initialize() {
        Arrays.stream(LottoRank.values())
                .sorted(Comparator.reverseOrder())
                .filter(lottoRank -> lottoRank.matchedCount() >= FIFTH.matchedCount())
                .forEach(lottoRank -> ranks.put(lottoRank, 0));
    }

    public Map<LottoRank, Integer> ranksCount() {
        lottoResults.stream()
                .map(LottoRank::findBy)
                .forEach(lottoRank -> ranks.put(lottoRank, ranks.get(lottoRank) + 1));

        return ranks;
    }
}
