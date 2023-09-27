import com.epam.tat.module4.Timeout;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertTimeout;
@DisplayName("Timeout sleep tests")
public class TimeoutSleepTest {
    @BeforeAll
    public static void prepTestBeforeAll() {
        System.out.println("Timeout tests are started");
    }

    @Test
    @DisplayName("Test timeout ")
    public void testTimeoutSleep() {
        assertTimeout(Duration.ofSeconds(3), () -> Timeout.sleep(2));
    }

    @AfterAll
    public static void testAfterAll() {
        System.out.println("Timeout tests are finished");
    }
}
