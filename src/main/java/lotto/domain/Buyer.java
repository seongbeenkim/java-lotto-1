package lotto.domain;

import static lotto.domain.LottoTicket.LOTTO_TICKET_PRICE;

public class Buyer {
    private final PurchaseAmount currentAmount;
    private final LottoTicketsCount numberOfManualTickets;
    private final LottoTicketsCount numberOfAutoTickets;

    public Buyer(final int purchaseAmount, final int manualTicketsCount) {
        this(new PurchaseAmount(purchaseAmount), new LottoTicketsCount(manualTicketsCount));
    }

    public Buyer(final PurchaseAmount currentAmount, final LottoTicketsCount numberOfManualTickets) {
        validateMaxedOut(currentAmount, numberOfManualTickets);
        this.currentAmount = currentAmount;
        this.numberOfManualTickets = numberOfManualTickets;
        this.numberOfAutoTickets = extractNumberOfAutoTickets();
    }

    private void validateMaxedOut(final PurchaseAmount currentAmount, final LottoTicketsCount numberOfManualTickets) {
        if (currentAmount.isLessThan(numberOfManualTickets.getPaidPurchaseAmount())) {
            throw new IllegalArgumentException("구매하려는 수동 로또 티켓의 금액은 가지고 있는 금액보다 작아야 합니다.");
        }
    }

    private LottoTicketsCount extractNumberOfAutoTickets() {
        int leftAmount = currentAmount.deduct(numberOfManualTickets.getPaidPurchaseAmount());
        return new LottoTicketsCount(leftAmount / LOTTO_TICKET_PRICE);
    }

    public LottoTicketsCount getNumberOfManualTickets() {
        return numberOfManualTickets;
    }

    public LottoTicketsCount getNumberOfAutoTickets() {
        return numberOfAutoTickets;
    }

    public LottoTicketsCount getTotalNumberOfTickets() {
        return numberOfManualTickets.add(numberOfAutoTickets);
    }
}
