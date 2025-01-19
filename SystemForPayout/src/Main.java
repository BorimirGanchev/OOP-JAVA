import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new FullTimeEmployee("Bori", 1, 60000),
                new FullTimeEmployee("Ili", 2, 72000),
                new FullTimeEmployee("Rado", 3, 48000),
                new FullTimeEmployee("Sami", 4, 54000),
                new PartTimeEmployee("Ivo", 5, 20, 160),
                new PartTimeEmployee("Marti", 6, 25, 120),
                new PartTimeEmployee("Simo", 7, 30, 100),
                new PartTimeEmployee("Alex", 8, 15, 200)
        );

        List<Employee> highEarners = employees.stream()
                .filter(e -> e.calculateMonthlyPay() > 3000)
                .collect(Collectors.toList());
        highEarners.forEach(e -> System.out.println(e.getName() + ": " + e.calculateMonthlyPay()));

        List<Employee> sortedEmployees = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::calculateMonthlyPay).reversed())
                .collect(Collectors.toList());
        sortedEmployees.forEach(e -> System.out.println(e.getName() + ": " + e.calculateMonthlyPay()));

        List<String> employeeStrings = employees.stream()
                .map(e -> "ID:" + e.getId() + ", Име:" + e.getName() + ", Месечна заплата:" + e.calculateMonthlyPay())
                .collect(Collectors.toList());
        employeeStrings.forEach(System.out::println);

        DoubleSummaryStatistics stats = employees.stream()
                .mapToDouble(Employee::calculateMonthlyPay)
                .summaryStatistics();
        System.out.println("Средна месечна заплата: " + stats.getAverage());
        System.out.println("Минимална заплата: " + stats.getMin());
        System.out.println("Максимална заплата: " + stats.getMax());
        System.out.println("Сума на всички месечни заплати: " + stats.getSum());
        System.out.println("Брой служители: " + stats.getCount());

        boolean anyHighEarner = employees.stream().anyMatch(e -> e.calculateMonthlyPay() > 6000);
        boolean allAbove2000 = employees.stream().allMatch(e -> e.calculateMonthlyPay() > 2000);
        boolean noneBelow500 = employees.stream().noneMatch(e -> e.calculateMonthlyPay() < 500);
        System.out.println("над 6000: " + anyHighEarner);
        System.out.println("Всички над 2000: " + allAbove2000);
        System.out.println("Няма под 500: " + noneBelow500);

        List<Employee> middleClass = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::calculateMonthlyPay).reversed())
                .skip(2)
                .limit(3)
                .collect(Collectors.toList());
        middleClass.forEach(e -> System.out.println(e.getName() + ": " + e.calculateMonthlyPay()));

        double totalSalary = employees.stream()
                .map(Employee::calculateMonthlyPay)
                .reduce(0.0, Double::sum);
        System.out.println("Обща сума: " + totalSalary);

        Map<String, List<Employee>> groupedByRole = employees.stream()
                .collect(Collectors.groupingBy(Employee::getRole));
        groupedByRole.forEach((role, empList) -> {
            System.out.println("Роля: " + role);
            empList.forEach(e -> System.out.println(e.getName() + ": " + e.calculateMonthlyPay()));
        });
    }
}