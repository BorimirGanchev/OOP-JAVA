import org.junit.jupiter.api.Test;
import java.util.Collection;
import static org.junit.jupiter.api.Assertions.*;

public class FindKeywordStrategyTest {
    @Test
    public void testFindKeyword() {
        FindKeywordStrategy strategy = new FindKeywordStrategy("error");
        strategy.process(new LogEntry("2023-10-26", "INFO", "Class", "No issues"));
        strategy.process(new LogEntry("2023-10-26", "ERROR", "Class", "Critical error occurred"));

        Collection<?> result = (Collection<?>) strategy.getResult();
        assertEquals(1, result.size());
    }
}
