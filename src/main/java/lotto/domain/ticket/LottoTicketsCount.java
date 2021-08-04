package lotto.domain.ticket;

import java.util.Objects;

public class LottoTicketsCount {
    public static final int LOTTO_TICKET_PRICE = 1000;
    private static final int NUMBER_OF_TICKETS_MIN_BOUND = 0;

    private final int lottoTicketsCount;

    public LottoTicketsCount(final int lottoTicketsCount) {
        validatePositive(lottoTicketsCount);
        this.lottoTicketsCount = lottoTicketsCount;
    }

    private void validatePositive(final int lottoTicketsCount) {
        if (lottoTicketsCount < NUMBER_OF_TICKETS_MIN_BOUND) {
            throw new IllegalArgumentException("티켓은 0장 이상이여야 합니다.");
        }
    }

    public int intValue() {
        return lottoTicketsCount;
    }

    public int getPaidPurchaseAmount() {
        return lottoTicketsCount * LOTTO_TICKET_PRICE;
    }

    public LottoTicketsCount add(LottoTicketsCount lottoTicketsCount) {
        return new LottoTicketsCount(this.lottoTicketsCount + lottoTicketsCount.intValue());
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTicketsCount that = (LottoTicketsCount) o;
        return lottoTicketsCount == that.lottoTicketsCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoTicketsCount);
    }
}
