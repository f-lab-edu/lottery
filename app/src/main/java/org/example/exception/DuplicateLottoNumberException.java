package app.src.main.java.org.example.exception;

public class DuplicateLottoNumberException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 중복되는 번호가 존재합니다.";

    public DuplicateLottoNumberException() {
        super(ERROR_MESSAGE);
    }
}
