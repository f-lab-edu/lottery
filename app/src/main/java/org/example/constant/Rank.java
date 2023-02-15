package app.src.main.java.org.example.constant;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum Rank {

    FIRST(2_000_000_000
            , 6
            , (matchLottoNumber, containBonusNumber) -> matchLottoNumber == 6),
    SECOND(30_000_000
            , 5
            , (matchLottoNumber, containBonusNumber) -> matchLottoNumber == 5 && containBonusNumber),
    THIRD(1_500_000
            , 5
            , (matchLottoNumber, containBonusNumber) -> matchLottoNumber == 5 && !containBonusNumber),
    FOURTH(50_000
            , 4
            , (matchLottoNumber, containBonusNumber) -> matchLottoNumber == 4),
    FIFTH(5_000
            , 3
            , (matchLottoNumber, containBonusNumber) -> matchLottoNumber == 3),
    EMPTY(0
            , 0
            , (matchLottoNumber, containBonusNumber) -> matchLottoNumber < 3);

    private final int money;
    private final int matchNumber;
    private final BiPredicate<Integer, Boolean> isMatch;

    Rank(final int money, final int matchLottoNumber, final BiPredicate<Integer, Boolean> isMatch) {
        this.money = money;
        this.matchNumber = matchLottoNumber;
        this.isMatch = isMatch;
    }

    public static Rank of(final int matchLottoNumber, final boolean containBonusNumber) {
        return Arrays.stream(Rank.values())
                .filter(reward -> reward.isMatch.test(matchLottoNumber, containBonusNumber))
                .findAny()
                .orElse(EMPTY);
    }

    public int getMatchNumber() {
        return matchNumber;
    }

    public int getMoney() {
        return money;
    }
}
