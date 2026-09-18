package com.satvik.fundamentals.basics;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Core Java fundamentals")
class BasicsTest {

    @Nested
    @DisplayName("MaxOfThree")
    class MaxOfThreeTest {

        @Test
        void picksTheLargest() {
            assertEquals(9, MaxOfThree.max(3, 9, 5));
            assertEquals(9, MaxOfThree.max(9, 3, 5));
            assertEquals(9, MaxOfThree.max(3, 5, 9));
        }

        @Test
        void handlesTiesAndNegatives() {
            assertEquals(7, MaxOfThree.max(7, 7, 7));
            assertEquals(-2, MaxOfThree.max(-5, -2, -9));
        }
    }

    @Nested
    @DisplayName("ReverseNumber")
    class ReverseNumberTest {

        @Test
        void reversesDigits() {
            assertEquals(4321, ReverseNumber.reverse(1234));
            assertEquals(1, ReverseNumber.reverse(1000));
        }

        @Test
        void keepsTheSignAndHandlesZero() {
            assertEquals(-321, ReverseNumber.reverse(-123));
            assertEquals(0, ReverseNumber.reverse(0));
        }
    }

    @Nested
    @DisplayName("DigitOccurrence")
    class DigitOccurrenceTest {

        @Test
        void countsRepeatedDigits() {
            assertEquals(3, DigitOccurrence.count(121_31, 1));
            assertEquals(0, DigitOccurrence.count(456, 9));
        }

        @Test
        void handlesZeroAndNegatives() {
            assertEquals(1, DigitOccurrence.count(0, 0));
            assertEquals(0, DigitOccurrence.count(0, 5));
            assertEquals(2, DigitOccurrence.count(-1010, 1));
        }

        @Test
        void rejectsNonDigits() {
            assertThrows(IllegalArgumentException.class, () -> DigitOccurrence.count(123, 10));
        }
    }

    @Nested
    @DisplayName("Fibonacci")
    class FibonacciTest {

        @Test
        void producesTheSeries() {
            assertArrayEquals(new long[]{0, 1, 1, 2, 3, 5, 8, 13}, Fibonacci.series(8));
        }

        @Test
        void handlesTinyCounts() {
            assertArrayEquals(new long[]{}, Fibonacci.series(0));
            assertArrayEquals(new long[]{0}, Fibonacci.series(1));
        }

        @Test
        void passesTheIntCeilingWithoutOverflow() {
            assertEquals(4_807_526_976L, Fibonacci.nth(48));
        }

        @Test
        void rejectsNegativeCounts() {
            assertThrows(IllegalArgumentException.class, () -> Fibonacci.series(-1));
        }
    }

    @Nested
    @DisplayName("PrimeNumber")
    class PrimeNumberTest {

        @Test
        void identifiesPrimes() {
            assertTrue(PrimeNumber.isPrime(2));
            assertTrue(PrimeNumber.isPrime(97));
            assertTrue(PrimeNumber.isPrime(7919));
        }

        @Test
        void rejectsCompositesAndEdgeCases() {
            assertFalse(PrimeNumber.isPrime(1));
            assertFalse(PrimeNumber.isPrime(0));
            assertFalse(PrimeNumber.isPrime(-7));
            assertFalse(PrimeNumber.isPrime(91));
        }
    }

    @Nested
    @DisplayName("Armstrong")
    class ArmstrongTest {

        @Test
        void identifiesArmstrongNumbers() {
            assertTrue(Armstrong.isArmstrong(153));
            assertTrue(Armstrong.isArmstrong(9474));
            assertTrue(Armstrong.isArmstrong(5));
        }

        @Test
        void rejectsOthers() {
            assertFalse(Armstrong.isArmstrong(154));
            assertFalse(Armstrong.isArmstrong(-153));
        }
    }

    @Nested
    @DisplayName("Swap")
    class SwapTest {

        @Test
        void returnsThePairReversed() {
            assertArrayEquals(new double[]{2.5, 1.5}, Swap.swap(1.5, 2.5));
        }

        @Test
        void swapsArrayPositionsInPlace() {
            int[] arr = {1, 2, 3};
            Swap.swap(arr, 0, 2);
            assertArrayEquals(new int[]{3, 2, 1}, arr);
        }
    }

    @Nested
    @DisplayName("DayOfWeek")
    class DayOfWeekTest {

        @Test
        void normalisesCasingAndWhitespace() {
            assertEquals("Monday", DayOfWeek.normalise("monday"));
            assertEquals("Sunday", DayOfWeek.normalise("  SUNDAY  "));
        }

        @Test
        void classifiesWeekends() {
            assertTrue(DayOfWeek.isWeekend("saturday"));
            assertFalse(DayOfWeek.isWeekend("Wednesday"));
        }

        @Test
        void rejectsUnknownDays() {
            assertThrows(IllegalArgumentException.class, () -> DayOfWeek.normalise("Funday"));
            assertThrows(IllegalArgumentException.class, () -> DayOfWeek.normalise(null));
        }
    }

    @Nested
    @DisplayName("Calculator")
    class CalculatorTest {

        private final Calculator calculator = new Calculator();

        @Test
        void performsArithmetic() {
            assertEquals(7, calculator.add(3, 4));
            assertEquals(-1, calculator.subtract(3, 4));
            assertEquals(12, calculator.multiply(3, 4));
            assertEquals(2, calculator.divide(8, 4));
        }

        @Test
        void rejectsDivisionByZero() {
            assertThrows(ArithmeticException.class, () -> calculator.divide(1, 0));
        }
    }
}
