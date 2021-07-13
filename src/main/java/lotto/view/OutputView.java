package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.domain.NumberOfTickets;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private OutputView() {
    }

    public static void printNumberOfTickets(NumberOfTickets numberOfTickets) {
        System.out.printf("%d개를 구매했습니다.", numberOfTickets.value());
    }

    public static void printLottoTickets(LottoTickets lottoTickets) {
        lottoTickets.list()
                .stream()
                .map(LottoTicket::lottoNumbers)
                .forEach(OutputView::printLottoTicket);
    }

    private static void printLottoTicket(List<LottoNumber> lottoNumbers) {
        System.out.println();

        String result = lottoNumbers.stream()
                .mapToInt(LottoNumber::value)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.printf("[" + "%s" + "]", result);
    }
}