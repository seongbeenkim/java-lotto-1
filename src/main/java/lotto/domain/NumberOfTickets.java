package lotto.domain;

import java.util.Objects;

public class NumberOfTickets {
    private static final int NUMBER_OF_TICKETS_MIN_BOUND = 1;

    private final int numberOfTickets;

    public NumberOfTickets(final int numberOfTickets) {
        validatePositive(numberOfTickets);
        this.numberOfTickets = numberOfTickets;
    }

    private void validatePositive(final int numberOfTickets) {
        if (numberOfTickets < NUMBER_OF_TICKETS_MIN_BOUND) {
            throw new IllegalArgumentException("티켓은 1장 이상이여야 합니다.");
        }
    }

    public int value() {
        return numberOfTickets;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NumberOfTickets that = (NumberOfTickets) o;
        return numberOfTickets == that.numberOfTickets;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfTickets);
    }
}
