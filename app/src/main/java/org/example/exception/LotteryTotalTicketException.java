package org.example.exception;

public enum LotteryTotalTicketException {
    TOTAL_TICKET_OUT_OF_BOUNDS("[Error] 구매한 로또 갯수가 0 이거나 0보다 작습니다.");

    private final String message;

    LotteryTotalTicketException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
