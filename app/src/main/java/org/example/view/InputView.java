package org.example.view;

import java.util.Scanner;

import static org.example.exception.InputViewException.EMPTY_INPUT;

public class InputView {
    private final Scanner SCANNER = new Scanner(System.in);

    public int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(validate());
    }

    private String validate() {
        String inputString = SCANNER.nextLine();
        validateNumber(inputString);
        return inputString;
    }

    private static void validateNumber(String inputString) {
        if(!inputString.matches("^[0-9]+$")) {
            throw new IllegalArgumentException(EMPTY_INPUT.getMessage());
        }
    }
}