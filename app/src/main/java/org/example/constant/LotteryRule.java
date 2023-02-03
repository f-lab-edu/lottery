package org.example.constant;

public enum LotteryRule {
    MIN_LOTTERY_NUMBER(1),
    MAX_LOTTERY_NUMBER(45),
    MIN_INPUT_MONEY(1000);

    private int number;

    LotteryRule(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
