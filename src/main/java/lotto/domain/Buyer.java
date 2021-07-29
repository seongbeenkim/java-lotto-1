package lotto.domain;

import static lotto.domain.LottoTicket.LOTTO_TICKET_PRICE;

public class Buyer {
    private final PurchaseAmount currentAmount;
    private final NumberOfTickets numberOfManualTickets;
    private final NumberOfTickets numberOfAutoTickets;

    public Buyer(final PurchaseAmount currentAmount, final NumberOfTickets numberOfManualTickets) {
        validateMaxedOut(currentAmount, numberOfManualTickets);
        this.currentAmount = currentAmount;
        this.numberOfManualTickets = numberOfManualTickets;
        this.numberOfAutoTickets = extractNumberOfAutoTickets();
    }

    private void validateMaxedOut(final PurchaseAmount currentAmount, final NumberOfTickets numberOfManualTickets) {
        if (currentAmount.isLessThan(numberOfManualTickets.getPaidPurchaseAmount())) {
            throw new IllegalArgumentException("구매하려는 수동 로또 티켓의 금액은 가지고 있는 금액보다 작아야 합니다.");
        }
    }

    private NumberOfTickets extractNumberOfAutoTickets() {
        int leftAmount = currentAmount.deduct(numberOfManualTickets.getPaidPurchaseAmount());
        return new NumberOfTickets(leftAmount / LOTTO_TICKET_PRICE);
    }

    public NumberOfTickets getNumberOfManualTickets() {
        return numberOfManualTickets;
    }

    public NumberOfTickets getNumberOfAutoTickets() {
        return numberOfAutoTickets;
    }

    public NumberOfTickets getTotalNumberOfTickets() {
        return numberOfManualTickets.add(numberOfAutoTickets);
    }
}
