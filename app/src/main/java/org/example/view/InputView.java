package app.src.main.java.org.example.view;

import app.src.main.java.org.example.exception.InvalidLottoInputFormatException;
import app.src.main.java.org.example.exception.SingleNumberFormatException;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Pattern PATTERN = Pattern.compile("(\\d{1,2},){5}\\d{1,2}");
    private static final Pattern BONUS_PATTERN = Pattern.compile("\\d+");
    private static final String INPUT_MESSAGE = "지난주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";

    static String inputValue() {
        return scanner.nextLine();
    }

    String result;


    public List<Integer> inputWinNumbers() {
        System.out.println(INPUT_MESSAGE);
        result = inputValue();
        System.out.println(result);
        validateWinNumbers(result);
        return Stream.of(result.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public Integer inputBonusNumber() {
        System.out.println(BONUS_INPUT_MESSAGE);
        String result = inputValue();
        validateBonus(result);
        return Integer.parseInt(result);
    }

    private void validateWinNumbers(String inputValue) {
        if (!PATTERN.matcher(inputValue).matches()) {
            throw new InvalidLottoInputFormatException();
        }
    }

    private void validateBonus(String inputValue) {

        if (!BONUS_PATTERN.matcher(inputValue).matches()) {
            throw new SingleNumberFormatException();
        }
    }
}
