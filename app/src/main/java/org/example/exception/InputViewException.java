package org.example.exception;

public enum InputViewException {
    EMPTY_INPUT("[Error] 값을 제대로 입력하지 않으셔서 프로그램이 종료됩니다.");

    private final String message;

    InputViewException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
