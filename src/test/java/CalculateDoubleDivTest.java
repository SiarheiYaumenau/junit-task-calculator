import com.epam.tat.module4.Calculator;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Calculate division tests (double)")
@Execution(ExecutionMode.CONCURRENT)
@ExtendWith(CalculatorParameterResolver.class)
public class CalculateDoubleDivTest {
    @BeforeAll
    public static void prepTestBeforeAll() {
        System.out.println("Tests division method with double numbers are started");
    }
    @ParameterizedTest
    @DisplayName("Tests division method with double numbers")
    @CsvFileSource(resources = "testDataForDoubleDiv.csv")
    public void testDoubleDiv(double a, double b, double result, Calculator calculator) {
        assertEquals(result, calculator.div(a, b), 0.0000001);
    }
    @Test
    @DisplayName("Test division by zero")
    public void testDoubleDivByZero(Calculator calculator) {
        assertThrows(RuntimeException.class, () -> calculator.div(1.2,0));
    }
    @AfterAll
    public static void prepTestAfterAll() {
        System.out.println("Tests division method with double numbers are finished");
    }
}

