package lotto.controller;

import lotto.domain.PurchaseAmount;
import lotto.view.InputView;

public class LottoController {

    public void run() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(InputView.inputPurchaseAmount());
    }
}
