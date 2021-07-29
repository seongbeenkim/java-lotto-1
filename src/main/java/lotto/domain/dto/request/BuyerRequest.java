package lotto.domain.dto.request;

public class BuyerRequest {
    private final int purchaseAmount;

    public BuyerRequest(final String purchaseAmount) {
        this.purchaseAmount = convertToInteger(purchaseAmount);
    }

    private int convertToInteger(final String purchaseAmount) {
        try {
            return Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("구매 금액은 정수여야 합니다.");
        }
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
