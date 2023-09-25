import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Calculate division tests (long)")
@Execution(ExecutionMode.CONCURRENT)
@ExtendWith(CalculatorParameterResolver.class)
public class CalculateLongDivTest {

    @BeforeAll
    public static void prepTestBeforeAll() {
        System.out.println("Tests division method with long numbers are started");
    }
    @ParameterizedTest
    @DisplayName("Tests division method with long numbers")
    @CsvFileSource(resources = "testDataForLongDiv.csv")
    public void testLongDiv(long a, long b, long result, Calculator calculator) {
        assertEquals(result, calculator.div(a, b));
    }
    @Test
    @DisplayName("Test division by zero")
    public void testLongDivByZero(Calculator calculator) {
        assertThrows(RuntimeException.class, () -> calculator.div(1,0));
    }
    @AfterAll
    public static void prepTestAfterAll() {
        System.out.println("Tests division method with long numbers are finished");
    }
}
