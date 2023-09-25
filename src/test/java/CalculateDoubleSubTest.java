import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Calculate subtract tests (double)")
@Execution(ExecutionMode.CONCURRENT)
@ExtendWith(CalculatorParameterResolver.class)
public class CalculateDoubleSubTest {
    @BeforeAll
    public static void prepTestBeforeAll() {
        System.out.println("Tests subtract method with double numbers are started");
    }
    @ParameterizedTest
    @DisplayName("Tests subtract method with double numbers")
    @CsvSource({"165.65123, -651.526955, 817.178185", "0.651, 0.111, 0.54", "68691.189456, 8499815.651592, -8431124.462136"})
    public void testDoubleSub(double a, double b, double result, Calculator calculator) {
        assertEquals(result, calculator.sub(a, b), 0.0000001);
    }

    @Test
    @DisplayName("Test subtract method with max double number")
    public void testDoubleSubWithMaxValues (Calculator calculator) {
        assertEquals(Double.MAX_VALUE, calculator.sub(Double.MAX_VALUE,0));
    }
    @AfterAll
    public static void prepTestAfterAll() {
        System.out.println("Tests subtract method with double numbers are finished");
    }
}

