package org.example.exception;

public enum LotteryNumberException {
    NUMBER_OUT_OF_RANGE("로또 숫자 범위를 벗어났습니다.");

    private final String message;

    LotteryNumberException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
