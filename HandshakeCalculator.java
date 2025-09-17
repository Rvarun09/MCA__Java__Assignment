import java.util.Scanner;

public class HandshakeCalculator {

    public static int calculateHandshakes(int n) {
        return (n * (n - 1)) / 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the number of students: ");
            int numStudents = scanner.nextInt();

            if (numStudents < 0) {
                System.out.println("Number of students cannot be negative.");
            } else {
                
                int maxHandshakes = calculateHandshakes(numStudents);
                System.out.println("Maximum number of handshakes among " + numStudents + " students is: " + maxHandshakes);
            }

        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid integer.");
        } finally {
            scanner.close();
        }
    }
}
