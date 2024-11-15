import java.util.List;

public class Company {
    private List<Employee> employees;

    public void addEmployee(Employee employee){
        employees.add(employee);
    }

    public void printSalaries(){
        for(Employee employee : employees){
            System.out.println(employee.calculatePay());
            System.out.println(employee.toString());
        }
    }
}
