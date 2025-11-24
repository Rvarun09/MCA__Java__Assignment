import java.util.ArrayList;
import java.util.List;

class Employee {
    private String name;
    private String role;

    public Employee(String name, String role) {
        this.name = name;
        this.role = role;
    }

    @Override
    public String toString() {
        return "   -> " + name + " (" + role + ")";
    }
}

class Department {
    private String name;
    private List<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addEmployee(String empName, String empRole) {
        Employee newEmp = new Employee(empName, empRole);
        employees.add(newEmp);
    }

    public void displayDepartment() {
        System.out.println("  Dept: " + name);
        for (Employee e : employees) {
            System.out.println(e);
        }
    }
}


class Company {
    private String name;
    private List<Department> departments;

    public Company(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    public void createDepartment(String deptName) {
        Department newDept = new Department(deptName);
        departments.add(newDept);
    }

    public void addEmployeeToDept(String deptName, String empName, String role) {
        for (Department d : departments) {
            if (d.getName().equals(deptName)) {
                d.addEmployee(empName, role);
                return;
            }
        }
        System.out.println("Department " + deptName + " not found.");
    }

    public void displayCompany() {
        System.out.println("=== Company: " + name + " ===");
        if (departments.isEmpty()) {
            System.out.println("No active departments.");
        } else {
            for (Department d : departments) {
                d.displayDepartment();
            }
        }
        System.out.println("===========================\n");
    }
}


public class CompanySystem {
    public static void main(String[] args) {
        
        Company techCorp = new Company("Tech Solutions Inc.");

        techCorp.createDepartment("Engineering");
        techCorp.createDepartment("HR");


        techCorp.addEmployeeToDept("Engineering", "Alice", "Frontend Dev");
        techCorp.addEmployeeToDept("Engineering", "Bob", "Backend Dev");
        techCorp.addEmployeeToDept("HR", "Carol", "Recruiter");

        
        techCorp.displayCompany();


        
        techCorp = null; 

        System.out.println(">> Company object destroyed (set to null).");
        System.out.println(">> Trying to access 'Engineering' department...");
        System.out.println(">> Error: We have no variable reference to it. It is gone.");
        
    }
}