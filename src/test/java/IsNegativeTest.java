import com.epam.tat.module4.Calculator;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.junit.jupiter.api.Assertions.*;
@DisplayName("Is negative tests")
@Execution(ExecutionMode.CONCURRENT)
@ExtendWith(CalculatorParameterResolver.class)
public class IsNegativeTest {
    @BeforeAll
    public static void prepTestBeforeAll() {
        System.out.println("Tests IsNegative function are started");
    }
    @Test
    @DisplayName("Test IsNegative function with positive numbers")
    public void testIsNegativeTrue(Calculator calculator) {
        assertTrue(calculator.isNegative(Long.MIN_VALUE));
    }
    @Test
    @DisplayName("Test IsNegative function with negative numbers")
    public void testIsNegativeFalse(Calculator calculator) {
        assertFalse(calculator.isNegative(1));
    }
    @Test
    @DisplayName("Test IsNegative function with zero")
    public void testIsNegativeZero(Calculator calculator) {
        assertFalse(calculator.isNegative(0));
    }
    @AfterAll
    public static void prepTestAfterAll() {
        System.out.println("Tests IsPositive function are finished");
    }

}