package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String DEFAULT_DELIMITER = ",";

    private InputView() {
    }

    public static String inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextLine().trim();
    }

    public static List<String> inputWinningNumbers() {
        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        return Arrays.stream(scanner.nextLine().split(DEFAULT_DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public static String inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextLine().trim();
    }
}
