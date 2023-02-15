package org.example.controller;

import app.src.main.java.org.example.domain.Result;
import app.src.main.java.org.example.domain.WinLottoNumbers;
import app.src.main.java.org.example.view.OutputView;
import org.example.view.InputView;

import java.util.List;


public class LottoController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void start() {
        // 임시 - 구매 한 로또  내역
        List<List<Integer>> lottoTickets = List.of(List.of(1, 2, 3, 4, 5, 6)
                , List.of(2, 3, 4, 5, 6, 7)
                , List.of(3, 4, 5, 6, 7, 8));

        WinLottoNumbers winLottoNumbers = getWinNumbers();

        Result result = makeResult(lottoTickets, winLottoNumbers);

        printResult(result);
    }

    private WinLottoNumbers getWinNumbers() {
        try {
            List<Integer> winLottoNumber = inputView.inputWinNumbers();
            int bonus = inputView.inputBonusNumber();
            return WinLottoNumbers.of(winLottoNumber, bonus);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinNumbers();
        }
    }

    private Result makeResult(List<List<Integer>> lottoTickets, WinLottoNumbers winLottoNumbers) {
        Result result = new Result();
        lottoTickets.stream()
                .map(winLottoNumbers::match)
                .forEach(result::add);
        return result;
    }


    private void printResult(Result result) {
        outputView.printResult(result);
    }

}
