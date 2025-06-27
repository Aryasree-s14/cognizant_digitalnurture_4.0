package demo; // This line declares the package for this class

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*; // Static import for easy access to assertion methods

public class Maintest { // This is the opening brace for your Maintest class

    private main calculator; // Declare an instance of the Calculator

    // This method will be executed before each test method.
    // It's useful for setting up common objects needed by multiple tests.
    @BeforeEach
    void setUp() {
        calculator = new Calculator(); // Initialize a new Calculator object for each test
    }

    @Test
    @DisplayName("Test for add method: positive numbers")
    void testAddPositiveNumbers() {
        int expected = 5;
        int actual = calculator.add(2, 3);
        assertEquals(expected, actual, "The add method should correctly sum positive numbers.");
    }

    @Test
    @DisplayName("Test for add method: negative numbers")
    void testAddNegativeNumbers() {
        int expected = -5;
        int actual = calculator.add(-2, -3);
        assertEquals(expected, actual, "The add method should correctly sum negative numbers.");
    }

    @Test
    @DisplayName("Test for add method: positive and negative number")
    void testAddPositiveAndNegative() {
        int expected = 1;
        int actual = calculator.add(5, -4);
        assertEquals(expected, actual, "The add method should correctly sum positive and negative numbers.");
    }

    @Test
    @DisplayName("Test for subtract method: basic subtraction")
    void testSubtract() {
        assertEquals(5, calculator.subtract(10, 5), "10 - 5 should be 5");
    }

    @Test
    @DisplayName("Test for multiply method: positive numbers")
    void testMultiplyPositiveNumbers() {
        assertEquals(15, calculator.multiply(3, 5), "3 * 5 should be 15");
    }

    @Test
    @DisplayName("Test for multiply method: by zero")
    void testMultiplyByZero() {
        assertEquals(0, calculator.multiply(10, 0), "Any number multiplied by zero should be zero");
    }

    @Test
    @DisplayName("Test for divide method: regular division")
    void testDivide() {
        assertEquals(2.5, calculator.divide(5, 2), 0.001, "5 / 2 should be 2.5"); // Third argument for double delta
    }

    @Test
    @DisplayName("Test for divide method: division by zero should throw IllegalArgumentException")
    void testDivideByZero() {
        // We expect an IllegalArgumentException to be thrown
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(10, 0),
                "Dividing by zero should throw an IllegalArgumentException.");
    }

    @Test
    @DisplayName("Test for isEven method: even number")
    void testIsEvenTrue() {
        assertTrue(calculator.isEven(4), "4 should be considered an even number.");
    }

    @Test
    @DisplayName("Test for isEven method: odd number")
    void testIsEvenFalse() {
        assertFalse(calculator.isEven(7), "7 should be considered an odd number.");
    }
} // This is the correct closing brace for your Maintest class