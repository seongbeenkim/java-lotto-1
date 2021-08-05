package lotto.domain;

import java.util.Objects;

public class PurchaseAmount {
    private static final int PURCHASE_AMOUNT_MIN_BOUND = 1_000;

    private final int purchaseAmount;

    public PurchaseAmount(final int purchaseAmount) {
        validate(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    private void validate(final int purchaseAmount) {
        validateMinimum(purchaseAmount);
        validateUnit(purchaseAmount);
    }

    private void validateMinimum(final int purchaseAmount) {
        if (purchaseAmount < PURCHASE_AMOUNT_MIN_BOUND) {
            throw new IllegalArgumentException("최소 구입 금액은 1,000원 이상이여야 합니다.");
        }
    }

    private void validateUnit(final int purchaseAmount) {
        if ((purchaseAmount % PURCHASE_AMOUNT_MIN_BOUND) != 0) {
            throw new IllegalArgumentException("구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    public boolean isLessThan(final int purchaseAmount) {
        return this.purchaseAmount < purchaseAmount;
    }

    public int subtract(final int paidPurchaseAmount) {
        return this.purchaseAmount - paidPurchaseAmount;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
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
