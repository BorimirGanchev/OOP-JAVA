public class FullTimeEmployee extends Employee {
    double annualSalary;


    public FullTimeEmployee(String name, int id, double salary) {
        super(name, id);
        this.annualSalary = salary;
    }

    public double calculateMonthlyPay() {
        return annualSalary / 12;
    }

    @Override
    public String getRole() {
        return "FullTime";
    }
}
