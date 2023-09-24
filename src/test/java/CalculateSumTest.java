import com.epam.tat.module4.Calculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class CalculateSumTest {
    private Calculator calculator;

    @BeforeEach
    public void initTest() {
        calculator = new Calculator();
    }

    @Test
    public void testSum() {
        assertEquals(10, calculator.sum(5,5));
    }

}