import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class FindKeywordStrategy implements LogAnalysisStrategy {
    private final String keyword;
    private final Queue<LogEntry> matches = new ConcurrentLinkedQueue<>();

    public FindKeywordStrategy(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public void process(LogEntry entry) {
        if (entry.getMessage().toLowerCase().contains(keyword.toLowerCase())) {
            matches.add(entry);
        }
    }

    @Override
    public Object getResult() {
        return matches;
    }
}
