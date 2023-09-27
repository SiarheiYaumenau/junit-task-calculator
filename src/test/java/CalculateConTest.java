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

@DisplayName("Calculate cotangent tests")
@Execution(ExecutionMode.CONCURRENT)
@ExtendWith(CalculatorParameterResolver.class)
public class CalculateConTest {
    @BeforeAll
    public static void prepTestBeforeAll() {
        System.out.println("Tests cotangent method are started");
    }

    @ParameterizedTest
    @DisplayName("Tests cotangent method")
    @CsvSource({"-45.0, -1.0", "100.0, -0.17632698"})
    public void testDoubleCon(double a, double result, Calculator calculator) {
        assertEquals(result, calculator.ctg(Math.toRadians(a)), 0.0000001);
    }

    @Test
    @DisplayName("Test cotangent method with 180 degree")
    public void testLongDivideByZero(Calculator calculator) {
        assertThrows(RuntimeException.class, () -> calculator.ctg(Math.toRadians(180)));
    }
    @AfterAll
    public static void prepTestAfterAll() {
        System.out.println("Tests cotangent method are finished");
    }
}


