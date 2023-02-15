package org.example.domain;

import static org.example.constant.LotteryRule.MIN_INPUT_MONEY;
import static org.example.exception.LotteryShopException.INVALID_INPUT_MONEY;

public class LotteryShop {

    private final int inputMoney;
    private final int lotteryQuantity;

    public LotteryShop(int inputMoney) {
        validateInputMoney(inputMoney);
        this.inputMoney = inputMoney;
        this.lotteryQuantity = calculateLotteryCount(inputMoney);
    }

    private void validateInputMoney(int inputMoney) {
        if(isInvalidInputMoney(inputMoney)) {
            throw new IllegalArgumentException(INVALID_INPUT_MONEY.getMessage());
        }
    }

    private boolean isInvalidInputMoney(int inputMoney) {
        int lotteryMinMoney = MIN_INPUT_MONEY.getNumber();
        return inputMoney < lotteryMinMoney || inputMoney % lotteryMinMoney != 0;
    }

    private int calculateLotteryCount(int inputMoney) {
        return inputMoney / MIN_INPUT_MONEY.getNumber();
    }

    public int getLotteryQuantity() {
        return lotteryQuantity;
    }

    public int getInputMoney() {
        return inputMoney;
    }
}
