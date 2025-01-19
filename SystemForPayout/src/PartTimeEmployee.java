public class PartTimeEmployee extends Employee {
    double hourlyRate;
    int hoursPerMonth;

    public PartTimeEmployee(String name, int id, double rate, int hours) {
        super(name, id);
        this.hourlyRate = rate;
        this.hoursPerMonth = hours;
    }

    @Override
    public double calculateMonthlyPay() {
        return hourlyRate * hoursPerMonth;
    }

    @Override
    public String getRole() {
        return "FullTime";
    }
}
