package org.example.exception;

public enum LotteryTicketException {
    LOTTERY_NUMBERS_OUT_OF_BOUNDS("로또티켓을 생성하기 위해서는 45개의 숫자가 필요합니다.");


    private final String message;

    LotteryTicketException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
