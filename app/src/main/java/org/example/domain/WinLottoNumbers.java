package app.src.main.java.org.example.domain;

import app.src.main.java.org.example.constant.Rank;
import app.src.main.java.org.example.exception.DuplicateLottoNumberException;
import app.src.main.java.org.example.exception.InvalidRangeLottoNumberException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinLottoNumbers {

    private static final Integer MIN_RANGE = 1;
    private static final Integer MAX_RANGE = 45;
    private static final Integer WINNING_LOTTO_SIZE = 7;
    private final List<Integer> lottoNumbers;
    private final int bonus;

    private WinLottoNumbers(List<Integer> winLottoNumber, int bonus) {
        validateBonusNumber(winLottoNumber, bonus);
        this.lottoNumbers = winLottoNumber;
        this.bonus = bonus;
    }

    private void validateBonusNumber(List<Integer> winningLotto, Integer bonusNumber) {
        validateDuplicate(winningLotto, bonusNumber);

        winningLotto.forEach(this::validateRange);

        validateRange(bonusNumber);
    }

    private void validateDuplicate(List<Integer> winningLotto, Integer number) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(winningLotto);
        nonDuplicateNumbers.add(number);
        if (nonDuplicateNumbers.size() != WINNING_LOTTO_SIZE) {
            throw new DuplicateLottoNumberException();
        }
    }

    private void validateRange(Integer number) {
        if (!(MIN_RANGE <= number && number <= MAX_RANGE)) {
            throw new InvalidRangeLottoNumberException();
        }
    }

    public static WinLottoNumbers of(List<Integer> winLottoNumber, int bonus) {
        return new WinLottoNumbers(winLottoNumber, bonus);
    }

    public Rank match(List<Integer> lottoTicket) {
        int sameNumber = countSameNumber(lottoTicket);
        boolean containBonus = isContainsBonus(lottoTicket);
        return Rank.of(sameNumber, containBonus);
    }

    private int countSameNumber(List<Integer> lottoTicket) {
        return (int) lottoNumbers.stream()
                .filter(lottoTicket::contains)
                .count();
    }

    private boolean isContainsBonus(List<Integer> lottoTicket) {
        return lottoTicket.contains(bonus);
    }
}
