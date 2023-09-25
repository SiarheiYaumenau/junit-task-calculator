import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Calculate sum tests (long)")
@Execution(ExecutionMode.CONCURRENT)
@ExtendWith(CalculatorParameterResolver.class)
public class CalculateLongSumTest {

    @BeforeAll
    public static void prepTestBeforeAll() {
        System.out.println("Tests sum method with long numbers are started");
    }
    @ParameterizedTest
    @DisplayName("Tests sum method with long numbers")
    @CsvFileSource(resources = "testDataForLongSum.csv")
    public void testLongSum(long a, long b, long result, Calculator calculator) {
        assertEquals(result, calculator.sum(a, b));
    }
    @AfterAll
    public static void prepTestAfterAll() {
        System.out.println("Tests sum method with long numbers are finished");
    }
}