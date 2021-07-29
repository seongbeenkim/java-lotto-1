package lotto.view;

import lotto.domain.dto.response.LottoTicketsCountResponse;

import java.util.List;

public interface InputView {
    String inputPurchaseAmount();

    String inputNumberOfManualTickets();

    List<List<String>> inputManualLottoNumbers(LottoTicketsCountResponse numberOfManualTickets);

    List<String> inputWinningNumbers();

    String inputBonusNumber();
}
