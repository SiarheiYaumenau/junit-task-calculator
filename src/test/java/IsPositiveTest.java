import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.junit.jupiter.api.Assertions.*;
@DisplayName("Is positive tests")
@Execution(ExecutionMode.CONCURRENT)
@ExtendWith(CalculatorParameterResolver.class)
public class IsPositiveTest {
    @BeforeAll
    public static void prepTestBeforeAll() {
        System.out.println("Tests IsPositive function are started");
    }
    @Test
    @DisplayName("Test IsPositive function with positive numbers")
    public void testIsPositiveTrue(Calculator calculator) {
        assertTrue(calculator.isPositive(Long.MAX_VALUE));
    }
    @Test
    @DisplayName("Test IsPositive function with negative numbers")
    public void testIsPositiveFalse(Calculator calculator) {
        assertFalse(calculator.isPositive(-1));
    }
    @Test
    @DisplayName("Test IsPositive function with zero")
    public void testIsPositiveZero(Calculator calculator) {
        assertFalse(calculator.isPositive(0));
    }
    @AfterAll
    public static void prepTestAfterAll() {
        System.out.println("Tests IsPositive function are finished");
    }

}