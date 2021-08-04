package lotto.enums;

import lotto.domain.LottoResult;

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

    public static LottoRank findBy(final LottoResult lottoResult) {
        LottoRank rank = Arrays.stream(values())
                .filter(lottoRank -> lottoResult.hasSame(lottoRank.matchedCount))
                .findFirst()
                .orElse(NONE);

        if (isThirdRank(lottoResult, rank)) {
            return THIRD;
        }

        return rank;
    }

    private static boolean isThirdRank(final LottoResult lottoResult, final LottoRank rank) {
        return (rank.matchedCount == SECOND.matchedCount) && !lottoResult.hasBonusNumber();
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public int multiplyPrizeBy(final int rankCount) {
        return prize * rankCount;
    }

    public boolean isNotNoneRank() {
        return !this.equals(LottoRank.NONE);
    }
}
