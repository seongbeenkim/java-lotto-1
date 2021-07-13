package lotto.domain;

import java.util.Objects;

public class PurchaseAmount {
    private static final int PURCHASE_AMOUNT_MIN_BOUND = 1_000;

    private final int purchaseAmount;

    public PurchaseAmount(String inputPurchaseAmount) {
        this(Integer.parseInt(inputPurchaseAmount));
    }

    public PurchaseAmount(final int purchaseAmount) {
        validateBoundOf(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    private void validateBoundOf(int purchaseAmount) {
        if (purchaseAmount < PURCHASE_AMOUNT_MIN_BOUND) {
            throw new IllegalArgumentException("최소 구입 금액은 1,000원 이상이여야 합니다.");
        }
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
