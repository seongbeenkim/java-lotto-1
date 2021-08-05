package lotto.domain;

import lotto.domain.ticket.LottoTicketsCount;

public class Buyer {
    private final LottoTicketsCount manualTicketsCount;
    private final LottoTicketsCount autoTicketsCount;

    public Buyer(final int purchaseAmount, final int manualTicketsCount) {
        this(new PurchaseAmount(purchaseAmount), new LottoTicketsCount(manualTicketsCount));
    }

    public Buyer(final PurchaseAmount currentAmount, final LottoTicketsCount manualTicketsCount) {
        validateMaxedOut(currentAmount, manualTicketsCount);
        this.manualTicketsCount = manualTicketsCount;
        this.autoTicketsCount = LottoTicketsCount.createBy(currentAmount.subtract(manualTicketsCount.getPaidPurchaseAmount()));
    }

    private void validateMaxedOut(final PurchaseAmount currentAmount, final LottoTicketsCount manualTicketsCount) {
        if (currentAmount.isLessThan(manualTicketsCount.getPaidPurchaseAmount())) {
            throw new IllegalArgumentException("구매하려는 수동 로또 티켓의 금액은 가지고 있는 금액보다 작아야 합니다.");
        }
    }

    public LottoTicketsCount getManualTicketsCount() {
        return manualTicketsCount;
    }

    public LottoTicketsCount getAutoTicketsCount() {
        return autoTicketsCount;
    }

    public LottoTicketsCount getTotalTicketsCount() {
        return manualTicketsCount.add(autoTicketsCount);
    }
}
