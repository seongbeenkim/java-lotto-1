package lotto.domain;

public class Buyer {
    private final PurchaseAmount currentAmount;
    private final NumberOfTickets manualNumberOfTicket;

    public Buyer(final PurchaseAmount currentAmount, final NumberOfTickets manualNumberOfTickets) {
        validateMaxedOut(currentAmount, manualNumberOfTickets);
        this.currentAmount = currentAmount;
        this.manualNumberOfTicket = manualNumberOfTickets;
    }

    private void validateMaxedOut(final PurchaseAmount currentAmount, final NumberOfTickets manualNumberOfTickets) {
        if (currentAmount.isLessThan(manualNumberOfTickets.getPaidPurchaseAmount())) {
            throw new IllegalArgumentException("구매하려는 수동 로또 티켓의 금액은 가지고 있는 금액보다 작아야 합니다.");
        }
    }
}
