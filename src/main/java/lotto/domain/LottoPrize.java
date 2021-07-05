package lotto.domain;

import java.util.Arrays;

public enum LottoPrize {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000), // 보너스볼 일치
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    private final int matchedWinningNumberCount;
    private final boolean isMatchedBonusNumber;
    private final int prizeMoney;

    LottoPrize(int matchedWinningNumberCount, boolean isMatchedBonusNumber, int prizeMoney) {
        this.matchedWinningNumberCount = matchedWinningNumberCount;
        this.isMatchedBonusNumber = isMatchedBonusNumber;
        this.prizeMoney = prizeMoney;
    }

    public static int prize(int matchedWinningNumberCount, boolean isMatchedBonusNumber) {
        return Arrays.stream(LottoPrize.values())
                .filter(lottoPrize -> lottoPrize.isMatchedWith(matchedWinningNumberCount, isMatchedBonusNumber))
                .mapToInt(LottoPrize::prizeMoney)
                .findFirst()
                .orElse(NONE.prizeMoney);
    }

    private boolean isMatchedWith(int matchedWinningNumberCount, boolean isMatchedBonusNumber) {
        return (this.matchedWinningNumberCount == matchedWinningNumberCount)
                && (this.isMatchedBonusNumber == isMatchedBonusNumber);
    }

    public int prizeMoney() {
        return prizeMoney;
    }
}

