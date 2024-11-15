public class Manager extends Employee{

    private double bonus;

    public Manager(String name, double baseSalary, JobLevel jobLevel, double bonus) {
        super(name, baseSalary, jobLevel);
    }

    public double calculatePay(){
        return super.calculatePay() + bonus;
    }

    @Override
    public String toString() {
        return "Manager:" + super.getName() + "Level:" + super.getJobLevel() + "Salary:" + super.getBaseSalary() + "Bonus:" + bonus;
    }


}
