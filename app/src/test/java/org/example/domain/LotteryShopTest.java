package org.example.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.example.constant.LotteryRule.MIN_INPUT_MONEY;
import static org.example.exception.LotteryShopException.INVALID_INPUT_MONEY;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LotteryShopTest {

    @Nested
    class 성공케이스 {

        @Test
        @DisplayName("입력금액 1000원")
        void 입력금액_1000원() {
            // Given
            int inputMoney = 1000;

            // When
            LotteryShop lotteryShop = new LotteryShop(inputMoney);
            int validatedInputMoney = lotteryShop.getInputMoney();

            // Then
            assertEquals(validatedInputMoney, inputMoney);
        }


        @Test
        @DisplayName("입력금액 2000원 티켓 갯수 확인")
        void 입력금액_2000원() {
            // Given
            int inputMoney = 2000;
            int ticketQuantity = 2000 / MIN_INPUT_MONEY.getNumber();

            // When
            LotteryShop lotteryShop = new LotteryShop(inputMoney);
            int resultLotteryQuantity = lotteryShop.getLotteryQuantity();

            // Then
            assertEquals(resultLotteryQuantity, ticketQuantity);
        }
    }

    @Nested
    class 실패케이스 {

        @Test
        @DisplayName("입력금액 0원")
        void 입력금액_0원() {
            // Given
            int inputMoney = 0;

            // When
            Throwable exception = assertThrows(
                    IllegalArgumentException.class,
                    () -> new LotteryShop(inputMoney)
            );

            // Then
            assertEquals(exception.getMessage(), INVALID_INPUT_MONEY.getMessage());
        }


        @Test
        @DisplayName("입력금액 1000원 이하")
        void 입력금액_1000원_이하() {
            // Given
            int inputMoney = 111;

            // When
            Throwable exception = assertThrows(
                    IllegalArgumentException.class,
                    () -> new LotteryShop(inputMoney)
            );

            // Then
            assertEquals(exception.getMessage(), INVALID_INPUT_MONEY.getMessage());
        }

        @Test
        @DisplayName("입력금액 단위가 1000원 단위가 아닐 때")
        void 입력금액_단위() {
            // Given
            int inputMoney = 1004;

            // When
            Throwable exception = assertThrows(
                    IllegalArgumentException.class,
                    () -> new LotteryShop(inputMoney)
            );

            // Then
            assertEquals(exception.getMessage(), INVALID_INPUT_MONEY.getMessage());
        }
    }
}