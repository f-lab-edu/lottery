package org.example.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.example.constant.LotteryRule.MAX_LOTTERY_NUMBER;
import static org.example.constant.LotteryRule.MIN_LOTTERY_NUMBER;
import static org.example.exception.LotteryTicketException.LOTTERY_NUMBERS_OUT_OF_BOUNDS;

public class LotteryTicket {

    private final List<LotteryNumber> resultLotteryTicket;

    public LotteryTicket() {
        List<LotteryNumber> lotteryNumbers = new ArrayList<>();
        for(int i = MIN_LOTTERY_NUMBER.getNumber(); i <= MAX_LOTTERY_NUMBER.getNumber(); i++) {
            lotteryNumbers.add(new LotteryNumber(i));
        }
        this.resultLotteryTicket = generateLotteryTicket(lotteryNumbers);
    }

    public List<LotteryNumber> generateLotteryTicket(List<LotteryNumber> lotteryNumbers) {
        validateLotteryNumbers(lotteryNumbers);
        Collections.shuffle(lotteryNumbers);
        List<LotteryNumber> tempLotteryTicket = new ArrayList<>(lotteryNumbers.subList(0, 6));
        Collections.sort(tempLotteryTicket);
        return tempLotteryTicket;
    }

    private void validateLotteryNumbers(List<LotteryNumber> lotteryNumbers) {
        if(isTicketSizeOutOfBounds(lotteryNumbers)) {
            throw new IndexOutOfBoundsException(LOTTERY_NUMBERS_OUT_OF_BOUNDS.getMessage());
        }
    }
    private boolean isTicketSizeOutOfBounds(List<LotteryNumber> lotteryNumbers) {
        int lotteryNumbersSize = lotteryNumbers.size();
        return lotteryNumbersSize != MAX_LOTTERY_NUMBER.getNumber();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        sb.append(resultLotteryTicket.stream()
                .map(LotteryNumber::getLotteryNumber)
                .map(String::valueOf)
                .collect(Collectors.joining(", ")));
        sb.append("]");
        return sb.toString();
    }
}
