package lotto.view;

import lotto.domain.dto.response.LottoTicketsCountResponse;

import java.util.List;

public interface InputView {
    String inputPurchaseAmount();

    String inputManualTicketsCount();

    List<List<String>> inputManualLottoNumbers(LottoTicketsCountResponse lottoTicketsCount);

    List<String> inputWinningNumbers();

    String inputBonusNumber();
}
