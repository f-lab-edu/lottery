package app.src.main.java.org.example.view;

import app.src.main.java.org.example.constant.Rank;
import app.src.main.java.org.example.domain.Result;

public class OutputView {

    public void printResult(Result result) {

        System.out.println("당첨 통계");
        System.out.println("=============");
        for (Rank rank : Rank.values()) {
            System.out.println(rank.getMatchNumber() + "개 일치 (" + rank.getMoney() + "원) - " + result.getRankCount(rank) + "개");
        }
        System.out.println("총 수익률은 " + result.getProfit() + "% 입니다.");
    }
}
