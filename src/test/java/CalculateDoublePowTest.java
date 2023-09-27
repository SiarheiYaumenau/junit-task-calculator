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

@DisplayName("Calculate exponentiation tests (double)")
@Execution(ExecutionMode.CONCURRENT)
@ExtendWith(CalculatorParameterResolver.class)
public class CalculateDoublePowTest {
    @BeforeAll
    public static void prepTestBeforeAll() {
        System.out.println("Tests exponentiation method with double numbers are started");
    }

    @ParameterizedTest
    @DisplayName("Tests exponentiation method with double numbers")
    @CsvSource({"5.0, 3.0, 125.0", "0.651, 0.111, 0.9534710", "-9.4, 7.2, 10151273.898183526"})
    public void testDoublePow(double a, double b, double result, Calculator calculator) {
        assertEquals(result, calculator.pow(a, b), 0.0000001);
    }

    @Test
    @DisplayName("Test exponentiation method with max double number")
    public void testDoublePowWithMaxValues(Calculator calculator) {
        assertEquals(1.0, calculator.pow(Double.MAX_VALUE, 0));
    }

    @AfterAll
    public static void prepTestAfterAll() {
        System.out.println("Tests exponentiation method with double numbers are finished");
    }
}

