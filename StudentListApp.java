import java.util.Scanner;

public class StudentListApp {

    static node head = null;

    static Scanner scanner = new Scanner(System.in);

    static class Student {
        int rollNumber;
        String name;
        int age;
        String grade;

        public Student(int roll, String n, int a,String g) {
            rollNumber = roll;
            name = n;
            age = a;
            grade = g;
        }
    }

    static class node {
        Student studentData;
        node next;

        public node (Student s) {
            studentData = s;
            next = null;
        }
    }


    public static void main(String[] args) {
        
        while (true) {

            System.out.println("-----Welcome to Student Record Management-----");
            System.out.println("1. add student at the end:");
            System.out.println("2. add student at beginning:");
            System.out.println("3. add student at specific position:");
            System.out.println("4. delete student by roll number:");
            System.out.println("5. search stuednt by roll number:");
            System.out.println("6. display student grade:");
            System.out.println("7. exit:");
            System.out.println("please enter your choice:"); 


            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addAtEnd();
                    break;

                case 2:
                    addAtBeginning();
                    break;

                case 3:
                    addAtPosition();
                    break;

                case 4:
                    deleteByRoll();
                    break;

                case 5:
                    SearchByRollt();
                    break;

                case 6:
                    DisplayList();
                    break;

                case 7:
                    UpdateGrade();
                    break;

                case 8:
                    System.out.println("goodbye!:");
                    return;            
                default:
                     System.out.println("invalid choice, please try again:");
            }
        }
    }

    public static Student getStudentDetailsFromUser() {
        System.out.println("enter roll number:");
        int roll = scanner.nextInt();
        scanner.nextLine();

        System.out.println("enter name:");
        String name = scanner.nextLine();

        System.out.println("enter age:");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.println("enter grade:");
        String grade = scanner.nextLine();

        return new Student(roll, name, age, grade);
    
    }

    public static void addAtEnd() {

        Student newStudent = getStudentDetailsFromUser();
        node newNode = new node(newStudent);

        if(head == null) {
            head = newNode;
            System.out.println("student added. list was empty");
            return;
        }

        node current = head;
        while (current.next !=null) {
            current = current.next;
        }

        current.next = newNode;
        System.out.println("student added to the end.");
    }

    public static void addAtBeginning(){

        Student newStudent = getStudentDetailsFromUser();
        node newNode = new node(newStudent);

        newNode.next = head;

        head = newNode;

        System.out.println("Student added to the beginning.");
    }

    public static void addAtPosition() {
        System.out.println("enter position:");
        int pos = scanner.nextInt();

        if(pos < 0) {
            addAtBeginning();
            return;
        }

        Student newStudent = getStudentDetailsFromUser();
        node newNode = new node(newStudent);

        node current = head;
        node previous = null;
        int currentPos = 0;

        while (currentPos< pos && current != null) {
            previous = current;
            current = current.next;
            currentPos++;  
        }

        if (previous != null && currentPos == pos){
            previous.next = newNode;
            newNode.next = current;
            System.out.println("student added at position" + pos);
        } else if (pos > currentPos) {
            System.out.println("position not found. Adding to the end instead");

            if (head == null) { head = newNode; }
            else { previous.next = newNode; }
        } else {
            System.out.println("could not add ata that position:");
        }
    }

    public static void deleteByRoll() {
        System.out.println("enter roll number to delete:");
        int roll = scanner.nextInt();


        if(head == null) {
            System.out.println("the list is empty. nothing tp delete:");
            return;
        }

        if (head.studentData.rollNumber == roll) {
            System.out.println("deleted: " + head.studentData.name);
            head = head.next;
            return;
        }

        node current = head;
        node previous = null;

        while (current != null && current.studentData.rollNumber != roll) {
            previous = current;
            current = current.next;
        }

        if (current !=null) {
            previous.next = current.next;
            System.out.println("deleted:" + current.studentData.name);
        } else {
            System.out.println("student with roll number " + roll + "not found");
        }
    }

    public static void SearchByRollt() {
        System.out.println("enter the roll number you are searching for:");
        int roll = scanner.nextInt();

        node current = head;

        while (current != null) {
            if (current.studentData.rollNumber == roll) {

                System.out.println("student has founded:");
                System.out.println(" Roll:" + current.studentData.rollNumber);
                System.out.println(" Name:" + current.studentData.name);
                System.out.println(" Age:" + current.studentData.age);
                System.out.println(" Grade:" + current.studentData.grade);
                return;
            }
            current = current.next;
        }

        System.out.println("student with roll number" + roll + "not found");
    }


    public static void UpdateGrade() {
        System.out.println("enter roll number to update:");
        int roll = scanner.nextInt();
        scanner.nextLine();

        node current = head;

        while (current !=null) {
            if (current.studentData.rollNumber == roll) {

                System.out.println("enter new grade for " + current.studentData.name + ": ");
                String newGrade = scanner.nextLine();

                current.studentData.grade = newGrade;

                System.out.println("grade updated sucessfully");
                return;
            }

            current = current.next;
        }

        System.out.println("student with the roll number " + roll + "not found");
    }


    public static void DisplayList() {

        if(head == null) {
            System.out.println("the list is empty.");
            return;
        }
        System.out.println("--- Full Student List ---");
        node current = head;
        int count = 1;
        
        while (current != null) {
            System.out.println(count + ". Roll: " + current.studentData.rollNumber +
                               ", Name: " + current.studentData.name +
                               ", Age: " + current.studentData.age +
                               ", Grade: " + current.studentData.grade);
            current = current.next; // Move to the next node
            count++;
        }
        System.out.println("-------------------------");
    }
}