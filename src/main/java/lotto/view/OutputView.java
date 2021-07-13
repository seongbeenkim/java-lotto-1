package lotto.view;

import lotto.domain.NumberOfTickets;

public class OutputView {

    private OutputView() {
    }

    public static void printNumberOfTickets(NumberOfTickets numberOfTickets) {
        System.out.printf("%d개를 구매했습니다.", numberOfTickets.value());
    }
}
