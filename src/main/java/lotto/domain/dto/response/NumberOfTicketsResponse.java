package lotto.domain.dto.response;

public class NumberOfTicketsResponse {
    private final int numberOfManualTickets;
    private final int numberOfAutoTickets;

    public NumberOfTicketsResponse(final int numberOfManualTickets, int numberOfAutoTickets) {
        this.numberOfManualTickets = numberOfManualTickets;
        this.numberOfAutoTickets = numberOfAutoTickets;
    }

    public int getNumberOfManualTickets() {
        return numberOfManualTickets;
    }

    public int getNumberOfAutoTickets() {
        return numberOfAutoTickets;
    }
}
