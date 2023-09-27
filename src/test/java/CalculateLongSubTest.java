import com.epam.tat.module4.Calculator;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Calculate subtract tests (long)")
@Execution(ExecutionMode.CONCURRENT)
@ExtendWith(CalculatorParameterResolver.class)
public class CalculateLongSubTest {
    @BeforeAll
    public static void prepTestBeforeAll() {
        System.out.println("Tests subtract method with long numbers are started");
    }
    @ParameterizedTest
    @DisplayName("Tests subtract method with long numbers")
    @CsvSource({"33, 22, 11", "1054, 55, 999", "8988022187, 8987787865, 234322"})
    public void testLongSub(long a, long b, long result, Calculator calculator) {
        assertEquals(result, calculator.sub(a, b));
    }
    @AfterAll
    public static void prepTestAfterAll() {
        System.out.println("Tests subtract method with long numbers are finished");
    }
}
