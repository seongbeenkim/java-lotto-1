package lotto.view;

import lotto.domain.dto.response.NumberOfTicketsResponse;

import java.util.List;

public interface InputView {
    String inputPurchaseAmount();

    String inputNumberOfManualTickets();

    List<List<String>> inputManualLottoNumbers(NumberOfTicketsResponse numberOfManualTickets);

    List<String> inputWinningNumbers();

    String inputBonusNumber();
}
