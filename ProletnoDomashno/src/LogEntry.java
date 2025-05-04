public class LogEntry {
    private final String timestamp;
    private final String level;
    private final String className;
    private final String message;

    public LogEntry(String timestamp, String level, String className, String message) {
        this.timestamp = timestamp;
        this.level = level;
        this.className = className;
        this.message = message;
    }

    public String getLevel() { return level; }
    public String getMessage() { return message; }
    public String getClassName() { return className; }
    public String getTimestamp() { return timestamp; }

    @Override
    public String toString() {
        return timestamp + " " + level + " " + className + " " + message;
    }

    public static LogEntry parse(String line) {
        String[] parts = line.split(" ", 5);
        return new LogEntry(parts[0] + " " + parts[1], parts[2], parts[3], parts[4]);
    }
}
