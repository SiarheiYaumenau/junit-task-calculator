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

@DisplayName("Calculate sine tests")
@Execution(ExecutionMode.CONCURRENT)
@ExtendWith(CalculatorParameterResolver.class)
public class CalculateSinTest {
    @BeforeAll
    public static void prepTestBeforeAll() {
        System.out.println("Tests sine method are started");
    }

    @ParameterizedTest
    @DisplayName("Tests sine method")
    @CsvSource({"90.0, 1.0", "-45.0, -0.707106781", "180.0, 0"})
    public void testDoubleSin(double a, double result, Calculator calculator) {
        assertEquals(result, calculator.sin(Math.toRadians(a)), 0.0000001);
    }

    @AfterAll
    public static void prepTestAfterAll() {
        System.out.println("Tests sine method are finished");
    }
}