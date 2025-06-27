package code;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorATATest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        System.out.println("  @BeforeEach: Calculator initialized.");
    }

    @AfterEach
    void tearDown() {
        calculator = null;
        System.out.println("  @AfterEach: Calculator set to null.");
    }

    @Test
    @DisplayName("Test: Adding two positive numbers")
    void testAddPositiveNumbers() {
        System.out.println("Executing testAddPositiveNumbers...");

        int number1 = 5;
        int number2 = 3;
        int expectedSum = 8;

        int actualSum = calculator.add(number1, number2);

        assertEquals(expectedSum, actualSum, "The sum of " + number1 + " and " + number2 + " should be " + expectedSum);
        System.out.println("  Assertion passed for adding positive numbers.");
    }

    @Test
    @DisplayName("Test: Subtracting a smaller number from a larger one")
    void testSubtractPositiveNumbers() {
        System.out.println("Executing testSubtractPositiveNumbers...");

        int minuend = 10;
        int subtrahend = 4;
        int expectedDifference = 6;

        int actualDifference = calculator.subtract(minuend, subtrahend);

        assertEquals(expectedDifference, actualDifference, "10 - 4 should be 6");
        System.out.println("  Assertion passed for subtracting positive numbers.");
    }

    @Test
    @DisplayName("Test: Division by a non-zero number")
    void testDivideByNonZero() {
        System.out.println("Executing testDivideByNonZero...");

        int dividend = 10;
        int divisor = 2;
        double expectedQuotient = 5.0;
        double delta = 0.0001;

        double actualQuotient = calculator.divide(dividend, divisor);

        assertEquals(expectedQuotient, actualQuotient, delta, "10 / 2 should be 5.0");
        System.out.println("  Assertion passed for division by non-zero.");
    }

    @Test
    @DisplayName("Test: Division by zero should throw IllegalArgumentException")
    void testDivideByZeroThrowsException() {
        System.out.println("Executing testDivideByZeroThrowsException...");

        int dividend = 10;
        int divisor = 0;

        assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(dividend, divisor);
        }, "Dividing by zero should throw an IllegalArgumentException.");
        System.out.println("  Assertion passed: IllegalArgumentException was correctly thrown.");
    }
}

