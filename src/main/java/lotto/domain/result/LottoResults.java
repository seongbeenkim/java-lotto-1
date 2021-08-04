package lotto.domain.result;

import lotto.enums.LottoRank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoResults {
    private final List<LottoResult> lottoResults;

    public LottoResults(final List<LottoResult> lottoResults) {
        this.lottoResults = new ArrayList<>(lottoResults);
    }

    public List<LottoRank> findAllRanks() {
        return Collections.unmodifiableList(lottoResults.stream()
                .map(LottoRank::findBy)
                .collect(Collectors.toList()));
    }

    public List<LottoResult> list() {
        return Collections.unmodifiableList(lottoResults);
    }
}
