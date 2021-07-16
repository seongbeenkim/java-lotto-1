package lotto.domain;

import java.util.Objects;

import static lotto.domain.LottoTicket.LOTTO_TICKET_PRICE;

public class PurchaseAmount {
    private static final int PURCHASE_AMOUNT_MIN_BOUND = 1_000;

    private final int purchaseAmount;

    public PurchaseAmount(final int purchaseAmount) {
        validateBoundOf(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    private void validateBoundOf(final int purchaseAmount) {
        if (purchaseAmount < PURCHASE_AMOUNT_MIN_BOUND) {
            throw new IllegalArgumentException("최소 구입 금액은 1,000원 이상이여야 합니다.");
        }
    }

    public NumberOfTickets convertToNumberOfTickets() {
        return new NumberOfTickets(purchaseAmount / LOTTO_TICKET_PRICE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseAmount that = (PurchaseAmount) o;
        return purchaseAmount == that.purchaseAmount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(purchaseAmount);
    }
}
