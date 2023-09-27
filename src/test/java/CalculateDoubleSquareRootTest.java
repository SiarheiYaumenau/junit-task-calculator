import com.epam.tat.module4.Calculator;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Calculate square root tests (double)")
@Execution(ExecutionMode.CONCURRENT)
@ExtendWith(CalculatorParameterResolver.class)
public class CalculateDoubleSquareRootTest {
    @BeforeAll
    public static void prepTestBeforeAll() {
        System.out.println("Tests square root method with double numbers are started");
    }

    @ParameterizedTest
    @DisplayName("Tests square root method with double numbers")
    @CsvSource({"5.0, 2.236067977", "0.0, 0.0", "144.0, 12.0"})
    public void testDoubleSqrt(double a, double result, Calculator calculator) {
        assertEquals(result, calculator.sqrt(a), 0.0000001);
    }
    @Test
    @DisplayName("Test square root by negative")
    public void testDoubleDivideByNegative(Calculator calculator) {
        assertThrows(RuntimeException.class, () -> calculator.sqrt(-0.01));
    }

    @AfterAll
    public static void prepTestAfterAll() {
        System.out.println("Tests square root method with double numbers are finished");
    }
}


