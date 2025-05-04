public interface LogAnalysisStrategy {
    void process(LogEntry entry);
    Object getResult();
}
