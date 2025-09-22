public class Student {
    private static String universityName = "Default University";
    private static int totalStudents = 0;

    private final int rollNumber;
    private String name;
    private String grade;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        totalStudents++;
    }

    public static void setUniversityName(String name) {
        universityName = name;
    }

    public static void displayTotalStudents() {
        System.out.println("Total Students: " + totalStudents);
    }

    public void displayDetails() {
        if (this instanceof Student) {
            System.out.println("University Name: " + universityName);
            System.out.println("Name: " + name);
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Grade: " + grade);
        } else {
            System.out.println("Not a valid Student object.");
        }
    }

    public void updateGrade(String newGrade) {
        if (this instanceof Student) {
            this.grade = newGrade;
            System.out.println("Grade updated to: " + grade);
        } else {
            System.out.println("Not a valid Student object.");
        }
    }

    public static void main(String[] args) {
        Student.setUniversityName("Copilot University");
        Student s1 = new Student("Alice", 1, "A");
        Student s2 = new Student("Bob", 2, "B");

        s1.displayDetails();
        System.out.println();
        s2.displayDetails();

        s1.updateGrade("A+");
        System.out.println();
        s1.displayDetails();

        Student.displayTotalStudents();
    }
}