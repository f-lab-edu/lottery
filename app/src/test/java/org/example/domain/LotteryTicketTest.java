package org.example.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.example.constant.LotteryRule.MAX_LOTTERY_NUMBER;
import static org.example.constant.LotteryRule.MIN_LOTTERY_NUMBER;
import static org.example.exception.LotteryTicketException.LOTTERY_NUMBERS_OUT_OF_BOUNDS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LotteryTicketTest {

    private final List<LotteryNumber> lotteryNumberList = new ArrayList<>();


    @Nested
    class 성공케이스 {
        @Test
        @DisplayName("로또번호 45개")
        void 로또번호_1개_입력() {
            // Given
            for(int i = MIN_LOTTERY_NUMBER.getNumber(); i <= MAX_LOTTERY_NUMBER.getNumber(); i++) {
                lotteryNumberList.add(new LotteryNumber(i));
            }

            // When
            List<LotteryNumber> lotteryTicket = new LotteryTicket().generateLotteryTicket(lotteryNumberList);
            int resultTicketSize = lotteryTicket.size();

            // Then
            assertEquals(6, resultTicketSize);
        }
    }


    @Nested
    class 실패케이스 {

        @Test
        @DisplayName("로또번호 범위 0개")
        void 로또번호_범위_0개() {
            // When
            Exception exception = assertThrows(
                    IndexOutOfBoundsException.class,
                    () -> new LotteryTicket().generateLotteryTicket(lotteryNumberList)
            );

            // Then
            assertEquals(exception.getMessage(), LOTTERY_NUMBERS_OUT_OF_BOUNDS.getMessage());
        }


        @Test
        @DisplayName("로또번호 1개")
        void 로또번호_범위_1개() {
            // Given
            lotteryNumberList.add(new LotteryNumber(1));

            // When
            Exception exception = assertThrows(
                    IndexOutOfBoundsException.class,
                    () -> new LotteryTicket().generateLotteryTicket(lotteryNumberList)
            );

            // Then
            assertEquals(exception.getMessage(), LOTTERY_NUMBERS_OUT_OF_BOUNDS.getMessage());
        }
    }
}