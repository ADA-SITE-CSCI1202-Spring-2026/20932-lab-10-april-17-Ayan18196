import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

class Employee {
    private String firstName;
    private String lastName;
    private double salary;

    public Employee(String firstName, String lastName, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public double getSalary() { return salary; }
}

public class Mapping {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Ayan", "Isgandarova", 3000.0));
        employees.add(new Employee("Nijat", "Gochiyev", 4500.0));
        employees.add(new Employee("Isgandar", "Isgandarli", 2800.0));

        Function<Employee, String> formatCard = e -> 
            "Name: [" + e.getLastName() + ", " + e.getFirstName() + "] - Salary: $" + e.getSalary();

        Function<Employee, Double> salaryPicker = Employee::getSalary;

        for (Employee emp : employees) {
            String card = formatCard.apply(emp);
            Double salary = salaryPicker.apply(emp);
            
            System.out.println(card);
            System.out.println("Extracted Salary: " + salary);
        }
    }
}