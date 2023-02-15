package org.example.controller;

import org.example.domain.LotteryShop;
import org.example.domain.LotteryTicket;
import org.example.domain.LotteryTotalTicket;
import org.example.view.InputView;

import java.util.List;

public class LotteryController {
    private final InputView inputView;


    public LotteryController() {
        this.inputView = new InputView();
    }

    public void start() {
        // 로또 구매 금액 처리
        int lotteryQuantity = getLotteryQuantity();

        // 구매 금액에 맞게 랜덤 로또 번호 발급
        List<LotteryTicket> lotteryTotalTicket = new LotteryTotalTicket().getLotteryTotalTickets(lotteryQuantity);
    }

    private int getLotteryQuantity() {
        LotteryShop lotteryShop = new LotteryShop(inputView.inputMoney());
        return lotteryShop.getLotteryQuantity();
    }

}
