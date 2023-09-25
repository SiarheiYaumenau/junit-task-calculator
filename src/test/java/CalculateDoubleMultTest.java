import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Calculate multiplication tests (double)")
@Execution(ExecutionMode.CONCURRENT)
@ExtendWith(CalculatorParameterResolver.class)
public class CalculateDoubleMultTest {
    @BeforeAll
    public static void prepTestBeforeAll() {
        System.out.println("Tests multiplication method with double numbers are started");
    }
    @ParameterizedTest
    @DisplayName("Tests multiplication method with double numbers")
    @CsvFileSource(resources = "testDataForDoubleMult.csv")
    public void testDoubleMult(double a, double b, double result, Calculator calculator) {
        assertEquals(result, calculator.mult(a, b), 0.0000001);
    }

    @Test
    @DisplayName("Test multiplication method with max double number")
    public void testDoubleMultWithMaxValues (Calculator calculator) {
        assertEquals(0, calculator.mult(0, Double.MAX_VALUE));
    }
    @AfterAll
    public static void prepTestAfterAll() {
        System.out.println("Tests multiplication method with double numbers are finished");
    }
}

