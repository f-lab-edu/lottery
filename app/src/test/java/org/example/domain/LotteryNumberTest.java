package org.example.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.example.exception.LotteryNumberException.NUMBER_OUT_OF_RANGE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LotteryNumberTest {

    @Nested
    class 성공케이스 {

        @Test
        @DisplayName("로또번호 20 입력")
        void 로또번호_20() {
            // Given
            int inputLotteryNumber = 20;

            // When
            LotteryNumber lotteryNumber = new LotteryNumber(inputLotteryNumber);
            int outputLotteryNumber = lotteryNumber.getLotteryNumber();

            // Then
            assertEquals(inputLotteryNumber, outputLotteryNumber);
        }
    }

    @Nested
    class 실패케이스 {

        @Test
        @DisplayName("로또번호 범위 초과")
        void 로또번호_47() {
            // Given
            int inputLotteryNumber = 47;

            // When
            Exception exception = assertThrows(
                    IllegalArgumentException.class,
                    () -> new LotteryNumber(inputLotteryNumber)
            );

            // Then
            assertEquals(exception.getMessage(), NUMBER_OUT_OF_RANGE.getMessage());
        }
    }
}