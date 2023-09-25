import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Calculate sum tests (double)")
@Execution(ExecutionMode.CONCURRENT)
@ExtendWith(CalculatorParameterResolver.class)
public class CalculateDoubleSumTest {
    @BeforeAll
    public static void prepTestBeforeAll() {
        System.out.println("Tests sum method with double numbers are started");
    }
    @ParameterizedTest
    @DisplayName("Tests sum method with double numbers")
    @CsvFileSource(resources = "testDataForDoubleSum.csv")
    public void testDoubleSum(double a, double b, double result, Calculator calculator) {
        assertEquals(result, calculator.sum(a, b), 0.0000001);
    }

    @Test
    @DisplayName("Test sum method with max double number")
    public void testDoubleSumWithMaxValues (Calculator calculator) {
        assertEquals(Double.MAX_VALUE, calculator.sum(0, Double.MAX_VALUE));
    }
    @AfterAll
    public static void prepTestAfterAll() {
        System.out.println("Tests sum method with double numbers are finished");
    }
}
