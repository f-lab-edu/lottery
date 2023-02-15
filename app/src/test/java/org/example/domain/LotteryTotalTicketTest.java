package org.example.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.example.exception.LotteryTotalTicketException.TOTAL_TICKET_OUT_OF_BOUNDS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LotteryTotalTicketTest {


    @Nested
    class 성공케이스 {

        @Test
        @DisplayName("로또 갯수 4개 입력")
        void 로또_갯수_4개() {
            // Given
            int inputLotteryQuantity = 4;

            // When
            List<LotteryTicket> lotteryTotalTicket = new LotteryTotalTicket()
                                                        .getLotteryTotalTickets(inputLotteryQuantity);
            int totalTicketSize = lotteryTotalTicket.size();


            // Then
            assertEquals(inputLotteryQuantity, totalTicketSize);
        }
    }

    @Nested
    class 실패케이스 {

        @Test
        @DisplayName("로또 개수 0개 입력")
        void 로또_갯수_0개() {
            // Given
            int inputLotteryQuantity = 0;

            // When
            Exception exception = assertThrows(IllegalArgumentException.class,
                    () -> new LotteryTotalTicket()
                            .getLotteryTotalTickets(inputLotteryQuantity)
            );

            // Then
            assertEquals(exception.getMessage(), TOTAL_TICKET_OUT_OF_BOUNDS.getMessage());

        }
    }

}