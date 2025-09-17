class Student {
    public int rollNumber;
    protected String name;
    private double CGPA;

    Student(int roll, String n, double c) {
        rollNumber = roll;
        name = n;
        CGPA = c;
    }

    public double getCGPA() {
        return CGPA;
    }

    public void setCGPA(double c) {
        CGPA = c;
    }

    public void display() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + CGPA);
        System.out.println();
    }
}

class PostgraduateStudent extends Student {
    String specialization;

    PostgraduateStudent(int roll, String n, double c, String spec) {
        super(roll, n, c);
        specialization = spec;
    }

    public void displayPostgraduateDetails() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("Specialization: " + specialization);
        System.out.println("CGPA: " + getCGPA());
        System.out.println();
    }
}

public class UniversityManagement {
    public static void main(String[] args) {
        Student s1 = new Student(101, "Alice", 8.7);
        s1.display();
        s1.setCGPA(9.0);
        s1.display();

        PostgraduateStudent pg1 = new PostgraduateStudent(201, "Bob", 9.1, "Data Science");
        pg1.displayPostgraduateDetails();
        pg1.setCGPA(9.3);
        pg1.displayPostgraduateDetails();
    }
}
