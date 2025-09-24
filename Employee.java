public class Employee {
    String name;
    int id;
    double salary;
    Employee(String name , int id, double salary){
        this.name=name;
        this.id=id;
        this.salary=salary;
    }
    public void displaydetail(){
        System.out.println("Name: "+name);
        System.out.println("ID: "+id);
        System.out.println("Salary: "+salary);
    }
}
class Manager extends Employee{
    int teamsize;
    Manager(String name, int id , double salary,int teamsize){
        super(name, id, salary);
        this.teamsize = teamsize;
    }
    @Override
    public void displaydetail(){
        super.displaydetail();
        System.out.println("Team Size: "+teamsize);
        System.out.println("Role : Manager");
    }
}
class Developer extends Employee{
    String programmingLanguage;
    Developer(String name , int id , double salary , String programmingLanguage){
        super(name, id, salary);
        this.programmingLanguage=programmingLanguage;
    }
    @Override
    public void displaydetail(){
        super.displaydetail();
        System.out.println("Language : "+programmingLanguage);
        System.out.println("Role : Developer ");
    }
}
class Intern extends Employee{
    Intern(String name , int id , double salary){
        super(name, id, salary);
    }
    @Override
    public void displaydetail(){
        super.displaydetail();
    }
}
class EmployeeManagement{
    public static void main(String[] args) {
        Employee e1 = new Employee("Raghav", 01, 50000);
        Employee m1 = new Manager("Sujal", 02, 30000, 3);
        Employee d1= new Developer("Rahul", 03, 20000, "Java");
        Employee i1 = new Intern("Radhika", 03, 20000);

        e1.displaydetail();
        System.out.println(" ");
        m1.displaydetail();
        System.out.println(" ");
        d1.displaydetail();
        System.out.println(" ");
        i1.displaydetail();

    }
}

