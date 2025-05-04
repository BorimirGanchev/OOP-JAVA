import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class CountByLevelStrategy implements LogAnalysisStrategy {
    private final ConcurrentHashMap<String, AtomicInteger> counts = new ConcurrentHashMap<>();

    @Override
    public void process(LogEntry entry) {
        counts.computeIfAbsent(entry.getLevel(), k -> new AtomicInteger()).incrementAndGet();
    }

    @Override
    public Object getResult() {
        return counts;
    }
}
