package org.example.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.example.exception.LotteryTotalTicketException.TOTAL_TICKET_OUT_OF_BOUNDS;

public class LotteryTotalTicket {

    private final List<LotteryTicket> lotteryTotalTicket = new ArrayList<>();

    public List<LotteryTicket> getLotteryTotalTickets(int lotteryQuantity) {
        validateLotteryQuantity(lotteryQuantity);
        IntStream.range(0, lotteryQuantity)
                 .forEach(i -> lotteryTotalTicket
                 .add(new LotteryTicket()));

        return lotteryTotalTicket;
    }

    private void validateLotteryQuantity(int lotteryQuantity) {
        if(lotteryQuantity <= 0) {
            throw new IllegalArgumentException(TOTAL_TICKET_OUT_OF_BOUNDS.getMessage());
        }
    }


}
