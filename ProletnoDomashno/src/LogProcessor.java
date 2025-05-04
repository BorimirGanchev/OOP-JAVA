import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.*;

public class LogProcessor {
    public static void main(String[] args) throws Exception {
        if (args.length < 2) {
            System.out.println("Usage: java LogProcessor <log1.txt> <log2.txt> ... <strategy>");
            return;
        }

        String strategyArg = args[args.length - 1];
        String[] files = Arrays.copyOfRange(args, 0, args.length - 1);

        LogAnalysisStrategy strategy;
        if (strategyArg.equals("count_by_level")) {
            strategy = new CountByLevelStrategy();
        } else if (strategyArg.startsWith("find_keyword")) {
            String[] parts = strategyArg.split(" ");
            String keyword = parts.length > 1 ? parts[1] : "exception";
            strategy = new FindKeywordStrategy(keyword);
        } else {
            System.out.println("Unknown strategy.");
            return;
        }

        ExecutorService executor = Executors.newFixedThreadPool(files.length);
        List<Future<?>> futures = new ArrayList<>();

        for (String file : files) {
            futures.add(executor.submit(() -> {
                try (BufferedReader reader = Files.newBufferedReader(Paths.get(file))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        strategy.process(LogEntry.parse(line));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }));
        }

        for (Future<?> future : futures) {
            future.get(); // wait for all
        }

        executor.shutdown();

        System.out.println("Res: ");
        Object result = strategy.getResult();
        if (result instanceof Map) {
            ((Map<?, ?>) result).forEach((k, v) -> System.out.println(k + ": " + v));
        } else if (result instanceof Collection) {
            ((Collection<?>) result).forEach(System.out::println);
        }
    }
}
