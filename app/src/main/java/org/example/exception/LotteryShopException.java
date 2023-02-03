package org.example.exception;

public enum LotteryShopException {
    INVALID_INPUT_MONEY("금액은 1000원 이상, 1000원 단위로 입력해주세요");

    private final String message;

    LotteryShopException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
