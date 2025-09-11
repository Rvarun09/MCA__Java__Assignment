import java.util.Scanner;

public class VotingEligibilityChecker {
    public static void main(String[] args) {
        int[] ages = new int[10]; 
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < ages.length; i++) {
            System.out.print("Enter age of student " + (i + 1) + ": ");
            ages[i] = scanner.nextInt();
        }

        System.out.println("\n--- Voting Eligibility ---");

        for (int i = 0; i < ages.length; i++) {
            int age = ages[i];

            if (age < 0) {
                System.out.println("Invalid age entered for student " + (i + 1));
            } else if (age >= 18) {
                System.out.println("The student with the age " + age + " can vote.");
            } else {
                System.out.println("The student with the age " + age + " cannot vote.");
            }
        }

        scanner.close();
    }
}

