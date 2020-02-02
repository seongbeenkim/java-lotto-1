package view;

import domain.Prize;
import domain.Tickets;

import java.util.Map;

public class OutputView {

    private static final String MESSAGE_GAME_RESULT = "당첨 통계\n------------";
    private static final String MESSAGE_SIX_MATCHED = "6개일치 ("+Prize.SIX_MATCHED.getWinningMoney()+")-";
    private static final String MESSAGE_FIVE_MATCHED_WITH_BONUS = "5개일치, 보너스 볼 일치("+Prize.FIVE_MATCHED_WITH_BONUS.getWinningMoney()+")-";
    private static final String MESSAGE_FIVE_MATCHED = "5개일치("+Prize.FIVE_MATCHED.getWinningMoney()+")-";
    private static final String MESSAGE_FOUR_MATCHED = "4개일치("+Prize.FOUR_MATCHED.getWinningMoney()+")-";
    private static final String MESSAGE_THREE_MATCHED = "3개일치("+Prize.THREE_MATCHED.getWinningMoney()+")-";

    public void printResult(Tickets tickets) {

        System.out.println(MESSAGE_GAME_RESULT);
        Map<Prize, Integer> prizeResult = tickets.getPrizeResult();
        System.out.println(MESSAGE_THREE_MATCHED+prizeResult.get(Prize.THREE_MATCHED)+"개");
        System.out.println(MESSAGE_FOUR_MATCHED+prizeResult.get(Prize.FOUR_MATCHED)+"개");
        System.out.println(MESSAGE_FIVE_MATCHED+prizeResult.get(Prize.FIVE_MATCHED)+"개");
        System.out.println(MESSAGE_FIVE_MATCHED_WITH_BONUS+prizeResult.get(Prize.FIVE_MATCHED_WITH_BONUS)+"개");
        System.out.println(MESSAGE_SIX_MATCHED+prizeResult.get(Prize.SIX_MATCHED)+"개");
        System.out.println("총 수익률은 "+ tickets.calculateProfitRatio()+"입니다.");
    }
}
