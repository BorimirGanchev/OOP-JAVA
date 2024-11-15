public class CompanyManagement {

    public static void main(String[] args) {
        Company company = new Company();

        for (String arg : args) {
            String[] tokens = arg.split(",");
            String name = tokens[0];
            double baseSalary = Double.parseDouble(tokens[1]);
            JobLevel jobLevel = JobLevel.valueOf(tokens[2]);
            String type = tokens[3];
            if (type.equals("Employee")) {
                company.addEmployee(new Employee(name, baseSalary, jobLevel));
            } else {
                double bonus = Double.parseDouble(tokens[4]);
                company.addEmployee(new Manager(name, baseSalary, jobLevel, bonus));
            }
        }
        company.printSalaries();
    }
}
