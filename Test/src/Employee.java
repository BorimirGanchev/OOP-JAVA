public class Employee implements Payable {
    private String name;
    private double baseSalary;
    private JobLevel jobLevel;

    public Employee(String name, double baseSalary, JobLevel jobLevel) {
        this.name = name;
        this.baseSalary = baseSalary;
        this.jobLevel = jobLevel;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    @Override
    public double calculatePay() {
        return baseSalary;
    }

    public JobLevel getJobLevel() {
        return jobLevel;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Employee: " + name + ", Level: " + jobLevel + ", Salary: " + baseSalary;
    }
}