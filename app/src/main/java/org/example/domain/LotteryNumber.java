package org.example.domain;

import static org.example.constant.LotteryRule.MAX_LOTTERY_NUMBER;
import static org.example.constant.LotteryRule.MIN_LOTTERY_NUMBER;
import static org.example.exception.LotteryNumberException.NUMBER_OUT_OF_RANGE;

public class LotteryNumber implements Comparable<LotteryNumber> {
    private final int lotteryNumber;

    public LotteryNumber(int lotteryNumber) {
        validateLotteryNumber(lotteryNumber);
        this.lotteryNumber = lotteryNumber;
    }

    private void validateLotteryNumber(int lotteryNumber) {
        if(isLotteryNumberOutOfRange(lotteryNumber)) {
            throw new IllegalArgumentException(NUMBER_OUT_OF_RANGE.getMessage());
        }
    }

    private boolean isLotteryNumberOutOfRange(int lotteryNumber) {
        return lotteryNumber < MIN_LOTTERY_NUMBER.getNumber()
                || MAX_LOTTERY_NUMBER.getNumber() < lotteryNumber;
    }

    @Override
    public String toString() {
        return Integer.toString(lotteryNumber);
    }

    @Override
    public int compareTo(LotteryNumber o) {
        return Integer.compare(this.lotteryNumber, o.lotteryNumber);
    }

    public int getLotteryNumber() {
        return lotteryNumber;
    }
}