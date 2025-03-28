package Task2;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.*;

public class SalesProcessor {
    static  int THREAD = 4;
    static  String INPUT = "sales.txt";
    static  String REVENUE = "revenue.txt";
    static  String TOP_PRODUCTS = "tproducts.txt";

    static  ConcurrentHashMap<String, Double> revenueMap = new ConcurrentHashMap<>();
    static  ConcurrentHashMap<String, Integer> quantityMap = new ConcurrentHashMap<>();

    public static void main(String[] args) throws IOException, InterruptedException {
        processSalesData();
        writeResults();
    }

    private static void processSalesData() throws IOException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD);
        List<Future<?>> futures = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(INPUT))) {
            String line;
            while ((line = reader.readLine()) != null) {
                final String data = line;
                futures.add(executor.submit(() -> processLine(data)));
            }
        }

        for (Future<?> future : futures) {
            try {
                future.get();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
    }

    private static void processLine(String line) {
        String[] parts = line.split(",");
        if (parts.length != 4) return;

        String productId = parts[0];
        int quantity = Integer.parseInt(parts[2]);
        double price = Double.parseDouble(parts[3]);

        revenueMap.merge(productId, quantity * price, Double::sum);
        quantityMap.merge(productId, quantity, Integer::sum);
    }

    private static void writeResults() throws IOException {
        writeTotalRevenue();
        writeTopProducts();
    }

    private static void writeTotalRevenue() throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(REVENUE))) {
            for (var entry : revenueMap.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue());
                writer.newLine();
            }
        }
    }

    private static void writeTopProducts() throws IOException {
        PriorityQueue<Map.Entry<String, Integer>> topProducts = new PriorityQueue<>(
                Comparator.comparingInt(Map.Entry::getValue)
        );

        for (var entry : quantityMap.entrySet()) {
            topProducts.offer(entry);
            if (topProducts.size() > 10) {
                topProducts.poll();
            }
        }

        List<Map.Entry<String, Integer>> sortedTopProducts = new ArrayList<>(topProducts);
        sortedTopProducts.sort((a, b) -> Integer.compare(b.getValue(), a.getValue()));

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(TOP_PRODUCTS))) {
            for (var entry : sortedTopProducts) {
                writer.write(entry.getKey() + "," + entry.getValue());
                writer.newLine();
            }
        }
    }
}

