package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    private final int matchedCount;
    private final int prize;

    LottoRank(int matchedCount, int prize) {
        this.matchedCount = matchedCount;
        this.prize = prize;
    }

    public static LottoRank findBy(LottoResult lottoResult) {
        LottoRank rank = Arrays.stream(values())
                .filter(lottoRank -> lottoResult.hasSame(lottoRank.matchedCount))
                .findFirst()
                .orElse(NONE);

        if ((rank.matchedCount == SECOND.matchedCount) && !lottoResult.hasBonusNumber()) {
            return THIRD;
        }

        return rank;
    }
}
