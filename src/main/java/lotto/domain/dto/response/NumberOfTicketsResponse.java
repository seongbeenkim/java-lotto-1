package lotto.domain.dto.response;

public class NumberOfTicketsResponse {
    private final int numberOfTickets;

    public NumberOfTicketsResponse(final int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }
}
