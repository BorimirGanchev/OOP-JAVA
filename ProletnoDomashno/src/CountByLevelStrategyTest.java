import org.junit.jupiter.api.Test;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

public class CountByLevelStrategyTest {
    @Test
    public void testCountByLevel() {
        CountByLevelStrategy strategy = new CountByLevelStrategy();
        strategy.process(new LogEntry("2023-10-26 10:00", "INFO", "TestClass", "Info msg"));
        strategy.process(new LogEntry("2023-10-26 10:01", "ERROR", "TestClass", "Error msg"));
        strategy.process(new LogEntry("2023-10-26 10:02", "INFO", "TestClass", "Info msg 2"));

        Map<String, ?> result = (Map<String, ?>) strategy.getResult();
        assertEquals("2", result.get("INFO").toString());
        assertEquals("1", result.get("ERROR").toString());
    }
}
