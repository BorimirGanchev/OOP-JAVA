public abstract class Employee {
    String name;
    int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public abstract double calculateMonthlyPay();
    public abstract String getRole();

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
