import java.util.Scanner;

public class StudentGrades2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[][] marks = new int[n][3];
        double[] percentage = new double[n];
        char[] grade = new char[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter marks for Student " + (i + 1));
            for (int j = 0; j < 3; j++) {
                String subject = (j == 0) ? "Physics" : (j == 1) ? "Chemistry" : "Maths";
                int m;
                do {
                    System.out.print(subject + ": ");
                    m = sc.nextInt();
                    if (m < 0 || m > 100) {
                        System.out.println("Invalid! Enter marks between 0 and 100.");
                    }
                } while (m < 0 || m > 100);
                marks[i][j] = m;
            }
        }

        for (int i = 0; i < n; i++) {
            int total = 0;
            for (int j = 0; j < 3; j++) {
                total += marks[i][j];
            }
            percentage[i] = total / 3.0;

            if (percentage[i] >= 90) grade[i] = 'A';
            else if (percentage[i] >= 75) grade[i] = 'B';
            else if (percentage[i] >= 50) grade[i] = 'C';
            else if (percentage[i] >= 35) grade[i] = 'D';
            else grade[i] = 'F';
        }

        System.out.println("\n--- Student Report ---");
        System.out.printf("%-10s %-10s %-10s %-10s %-12s %-6s%n",
                "Physics", "Chemistry", "Maths", "Total", "Percentage", "Grade");

        for (int i = 0; i < n; i++) {
            int total = marks[i][0] + marks[i][1] + marks[i][2];
            System.out.printf("%-10d %-10d %-10d %-10d %-12.2f %-6c%n",
                    marks[i][0], marks[i][1], marks[i][2], total, percentage[i], grade[i]);
        }

        sc.close();
    }
}
