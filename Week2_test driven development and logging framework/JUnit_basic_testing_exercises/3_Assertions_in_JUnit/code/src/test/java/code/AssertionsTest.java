package code;

 

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*; 
public class AssertionsTest {

    @Test
    public void testAssertions() {
        System.out.println("Running testAssertions...");

        
        assertEquals(5, 2 + 3, "2 + 3 should be equal to 5");
        System.out.println("assertEquals passed: 2 + 3 == 5");

        
        assertTrue(5 > 3, "5 should be greater than 3");
        System.out.println("assertTrue passed: 5 > 3");

        
        assertFalse(5 < 3, "5 should not be less than 3");
        System.out.println("assertFalse passed: 5 < 3");

        Object obj = null;
        assertNull(obj, "The object should be null");
        System.out.println("assertNull passed: obj is null");

        Object anotherObj = new Object();
        assertNotNull(anotherObj, "The object should not be null");
        System.out.println("assertNotNull passed: anotherObj is not null");

        
        String str1 = new String("hello");
        String str2 = new String("hello");
        
        String str3 = str1;
        assertSame(str1, str3, "str1 and str3 should refer to the same object");
        System.out.println("assertSame passed: str1 and str3 are the same object");

        
        assertNotSame(str1, str2, "str1 and str2 should not refer to the same object");
        System.out.println("assertNotSame passed: str1 and str2 are different objects");

        
        int[] expectedArray = {1, 2, 3};
        int[] actualArray = {1, 2, 3};
        assertArrayEquals(expectedArray, actualArray, "Arrays should be equal");
        System.out.println("assertArrayEquals passed: arrays are equal");

        
        assertThrows(ArithmeticException.class, () -> {
            int result = 10 / 0; 
        }, "Dividing by zero should throw ArithmeticException");
        System.out.println("assertThrows passed: ArithmeticException caught for division by zero");

        
        assertDoesNotThrow(() -> {
            int result = 10 / 2; 
        }, "This operation should not throw an exception");
        System.out.println("assertDoesNotThrow passed: No exception for 10 / 2");
    }
}
