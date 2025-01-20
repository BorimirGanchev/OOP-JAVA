import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car("Toyota", "Corolla", 90));
        vehicles.add(new Car("sdsad", "adssa", 120));
        vehicles.add(new Car("BMWsad", "dsas", 150));
        vehicles.add(new Van("nf", "jdj", 300));
        vehicles.add(new Van("sajd", "aksd", 200));
        vehicles.add(new Van("alsmd", "askd", 400));
        vehicles.add(new Van("alskd", "aslkdm", 250));

        System.out.println("nad 100 lv");

        vehicles.stream()
                .filter(v -> v.calculateDailyRate() > 100)
                .forEach(v -> System.out.println(v.brand + " " + v.model + " " + v.calculateDailyRate()));

        System.out.println("\nSorta :");
        vehicles.stream()
                .sorted(Comparator.comparingDouble(Vehicle::calculateDailyRate).reversed())
                .forEach(v -> System.out.println(v));

        System.out.println("\nПревърнете всяко превозно средство в низ от вида::");
        List<String> vehicleStrings = vehicles.stream()
                .map(Vehicle::toString)
                .collect(Collectors.toList());
        vehicleStrings.forEach(System.out::println);

        double averageRate = vehicles.stream().mapToDouble(Vehicle::calculateDailyRate).average().orElse(0);
        System.out.println("\nsredna " + averageRate);
        double minRate = vehicles.stream().mapToDouble(Vehicle::calculateDailyRate).min().orElse(0);

        System.out.println("minimalna  " + minRate);
        double maxRate = vehicles.stream().mapToDouble(Vehicle::calculateDailyRate).max().orElse(0);
        System.out.println("maksimalna: " + maxRate);
        double totalRate = vehicles.stream().mapToDouble(Vehicle::calculateDailyRate).sum();
        System.out.println("suma ot taksite: " + totalRate);



        System.out.println("brojkata na sredstwata " + vehicles.size());

        boolean anyAbove100 = vehicles.stream().anyMatch(v -> v.calculateDailyRate() > 100);
        System.out.println("\nПроверете дали има превозно средство с дневна такса над 100." + anyAbove100);
        boolean allAbove30 = vehicles.stream().allMatch(v -> v.calculateDailyRate() > 30);
        System.out.println("Проверете дали всички превозни средства имат дневна такса над 30." + allAbove30);
        boolean noneBelow20 = vehicles.stream().noneMatch(v -> v.calculateDailyRate() < 20);
        System.out.println("Проверете дали няма превозно средство с дневна такса под 20." + noneBelow20);

        System.out.println("\nИзведете вторите 2, най-евтино превозно средство (т.е. 3то и 4то) –");
        vehicles.stream()
                .sorted(Comparator.comparingDouble(Vehicle::calculateDailyRate))
                .skip(2)
                .limit(2)
                .forEach(System.out::println);
    }
}
