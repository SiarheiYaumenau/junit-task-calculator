import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Calculate multiplication tests (long)")
@Execution(ExecutionMode.CONCURRENT)
@ExtendWith(CalculatorParameterResolver.class)
public class CalculateLongMultTest {
    @BeforeAll
    public static void prepTestBeforeAll() {
        System.out.println("Tests multiplication method with long numbers are started");
    }
    @ParameterizedTest
    @DisplayName("Tests multiplication method with long numbers")
    @CsvFileSource(resources = "testDataForLongMult.csv")
    public void testLongMult(long a, long b, long result, Calculator calculator) {
        assertEquals(result, calculator.mult(a, b));
    }
    @AfterAll
    public static void prepTestAfterAll() {
        System.out.println("Tests multiplication method with long numbers are finished");
    }
}
