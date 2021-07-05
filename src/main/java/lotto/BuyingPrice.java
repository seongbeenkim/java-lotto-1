package lotto;

import java.util.Objects;

import static lotto.LottoTicketVendingMachine.TICKET_PRICE;

public class BuyingPrice {
    private final int buyingPrice;

    public BuyingPrice(final int buyingPrice) {
        validate(buyingPrice);
        this.buyingPrice = buyingPrice;
    }

    private void validate(int buyingPrice) {
        validateMinimum(buyingPrice);
        validateFactor(buyingPrice);
    }

    private void validateMinimum(int buyingPrice) {
        if (buyingPrice < TICKET_PRICE) {
            throw new IllegalArgumentException("구입 금액은 1,000원 이상이여야 합니다.");
        }
    }

    private void validateFactor(int buyingPrice) {
        if ((buyingPrice % TICKET_PRICE) != 0) {
            throw new IllegalArgumentException("구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    public int value() {
        return buyingPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BuyingPrice that = (BuyingPrice) o;
        return buyingPrice == that.buyingPrice;
    }

    @Override
    public int hashCode() {
        return Objects.hash(buyingPrice);
    }
}
