package lotto.domain;

import java.util.Objects;

public class NumberOfTickets {
    private final int numberOfTickets;

    public NumberOfTickets(final int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
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
