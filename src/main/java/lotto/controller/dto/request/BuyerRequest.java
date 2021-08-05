package lotto.controller.dto.request;

import lotto.domain.Buyer;

public class BuyerRequest {
    private final int purchaseAmount;
    private final int manualTicketsCount;

    public BuyerRequest(final String purchaseAmount, final String manualTicketsCount) {
        this.purchaseAmount = Integer.parseInt(purchaseAmount);
        this.manualTicketsCount = Integer.parseInt(manualTicketsCount);
    }

    public Buyer getBuyer() {
        return new Buyer(purchaseAmount, manualTicketsCount);
    }
}
