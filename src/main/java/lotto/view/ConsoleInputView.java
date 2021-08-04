package lotto.view;

import lotto.domain.dto.response.LottoTicketsCountResponse;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConsoleInputView implements InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String DEFAULT_DELIMITER = ",";

    @Override
    public String inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextLine().trim();
    }

    @Override
    public String inputManualTicketsCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return scanner.nextLine().trim();
    }

    @Override
    public List<List<String>> inputManualLottoNumbers(final LottoTicketsCountResponse lottoTicketsCount) {
        if (lottoTicketsCount.getManualTicketsCount() == 0) {
            return Collections.emptyList();
        }

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        return IntStream.range(0, lottoTicketsCount.getManualTicketsCount())
                .mapToObj(i -> Arrays.stream(scanner.nextLine().split(DEFAULT_DELIMITER)))
                .map(lottoNumbers -> lottoNumbers.map(String::trim).collect(Collectors.toList()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> inputWinningNumbers() {
        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        return Arrays.stream(scanner.nextLine().split(DEFAULT_DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    @Override
    public String inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextLine().trim();
    }
}
