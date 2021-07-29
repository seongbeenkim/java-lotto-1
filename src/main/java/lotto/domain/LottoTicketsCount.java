package lotto.domain;

import java.util.Objects;

import static lotto.domain.LottoTicket.LOTTO_TICKET_PRICE;

public class LottoTicketsCount {
    private static final int NUMBER_OF_TICKETS_MIN_BOUND = 0;

    private final int numberOfTickets;

    public LottoTicketsCount(final int numberOfTickets) {
        validatePositive(numberOfTickets);
        this.numberOfTickets = numberOfTickets;
    }

    private void validatePositive(final int numberOfTickets) {
        if (numberOfTickets < NUMBER_OF_TICKETS_MIN_BOUND) {
            throw new IllegalArgumentException("티켓은 0장 이상이여야 합니다.");
        }
    }

    public int intValue() {
        return numberOfTickets;
    }

    public int getPaidPurchaseAmount() {
        return numberOfTickets * LOTTO_TICKET_PRICE;
    }

    public LottoTicketsCount add(LottoTicketsCount lottoTicketsCount) {
        return new LottoTicketsCount(this.numberOfTickets + lottoTicketsCount.intValue());
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTicketsCount that = (LottoTicketsCount) o;
        return numberOfTickets == that.numberOfTickets;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfTickets);
    }
}
