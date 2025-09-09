import java.util.Scanner;

public class UserGreeting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking inputs
        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        // Printing message
        System.out.println("Hello " + name + ", you are " + age + " years old.");

        sc.close();
    }
}
