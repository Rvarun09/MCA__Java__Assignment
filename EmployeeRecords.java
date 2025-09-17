class Employee {
    public int employeeID;
    protected String department;
    private double salary;

    Employee(int id, String dept, double sal) {
        employeeID = id;
        department = dept;
        salary = sal;
    }

    public void setSalary(double newSalary) {
        if (newSalary >= 0) {
            salary = newSalary;
        } else {
            System.out.println("Salary cannot be negative");
        }
    }

    public double getSalary() {
        return salary;
    }

    public void displayEmployee() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + salary);
        System.out.println();
    }
}

class Manager extends Employee {
    String teamName;

    Manager(int id, String dept, double sal, String team) {
        super(id, dept, sal);
        teamName = team;
    }

    public void displayManager() {
        System.out.println("Manager ID: " + employeeID);
        System.out.println("Department: " + department);
        System.out.println("Team Name: " + teamName);
        System.out.println("Salary: " + getSalary());
        System.out.println();
    }
}

public class EmployeeRecords {
    public static void main(String[] args) {
        Employee e1 = new Employee(101, "Finance", 50000);
        e1.displayEmployee();
        e1.setSalary(55000);
        e1.displayEmployee();

        Manager m1 = new Manager(201, "IT", 80000, "Development");
        m1.displayManager();
        m1.setSalary(85000);
        m1.displayManager();
    }
}
