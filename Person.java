public class Person {
    String name;
    int age;
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    void showDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}
class Teacher extends Person {
    String subject;
    Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }
    void displayRole() {
        System.out.println("Role: Teacher");
    }
    void showDetails() {
        super.showDetails();
        System.out.println("Subject: " + subject);
    }
}
class Student extends Person {
    String grade;
    Student(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
    }
    void displayRole() {
        System.out.println("Role: Student");
    }
    void showDetails() {
        super.showDetails();
        System.out.println("Grade: " + grade);
    }
}
class Staff extends Person {
    String department;
    Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }
    void displayRole() {
        System.out.println("Role: Staff");
    }
    void showDetails() {
        super.showDetails();
        System.out.println("Department: " + department);
    }
}
class SchoolSystemDemo {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("Alice Johnson", 35, "Mathematics");
        Student student = new Student("Bob Smith", 16, "10th Grade");
        Staff staff = new Staff("Charlie Brown", 40, "Administration");
        System.out.println("---- Teacher ----");
        teacher.displayRole();
        teacher.showDetails();
        System.out.println("\n---- Student ----");
        student.displayRole();
        student.showDetails();
        System.out.println("\n---- Staff ----");
        staff.displayRole();
        staff.showDetails();
    }
}
