package lotto;

public class LottoTicketVendingMachine {
    public static final int TICKET_PRICE = 1000;

    public int divide(BuyingPrice buyingPrice) {
        return (buyingPrice.value() / TICKET_PRICE);
    }
}
