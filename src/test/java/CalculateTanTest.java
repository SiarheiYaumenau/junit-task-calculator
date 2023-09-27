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

@DisplayName("Calculate tangent tests")
@Execution(ExecutionMode.CONCURRENT)
@ExtendWith(CalculatorParameterResolver.class)
public class CalculateTanTest {
    @BeforeAll
    public static void prepTestBeforeAll() {
        System.out.println("Tests tangent method are started");
    }

    @ParameterizedTest
    @DisplayName("Tests tangent method")
    @CsvSource({"-45.0, -1.0", "270.0, 0.0"})
    public void testDoubleTan(double a, double result, Calculator calculator) {
        assertEquals(result, calculator.tg(Math.toRadians(a)), 0.0000001);
    }
    @Test
    @DisplayName("Test tangent method with positive infinity result")
    public void testDoubleTanWithInfinityResult(Calculator calculator) {
        assertEquals(Double.POSITIVE_INFINITY, calculator.tg(Math.toRadians(90.0)));
    }
    @AfterAll
    public static void prepTestAfterAll() {
        System.out.println("Tests tangent method are finished");
    }
}

