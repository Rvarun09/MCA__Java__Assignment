import java.util.Scanner;
import java.util.Random;

public class StudentScorecard {

    public static int[][] generateMarks(int numStudents) {
        Random rand = new Random();
        int[][] marks = new int[numStudents][3];
        for (int i = 0; i < numStudents; i++) {
            marks[i][0] = 50 + rand.nextInt(51);
            marks[i][1] = 50 + rand.nextInt(51);
            marks[i][2] = 50 + rand.nextInt(51);
        }
        return marks;
    }

    public static double[][] calculateTotalsAndPercentage(int[][] marks) {
        int n = marks.length;
        double[][] result = new double[n][3];
        for (int i = 0; i < n; i++) {
            int total = marks[i][0] + marks[i][1] + marks[i][2];
            double average = Math.round((total / 3.0) * 100.0) / 100.0;
            double percentage = Math.round((total / 300.0 * 100) * 100.0) / 100.0;
            result[i][0] = total;
            result[i][1] = average;
            result[i][2] = percentage;
        }
        return result;
    }

    public static String[] calculateGrades(double[][] percentages) {
        int n = percentages.length;
        String[] grades = new String[n];
        for (int i = 0; i < n; i++) {
            double p = percentages[i][2];
            if (p >= 90) grades[i] = "A+";
            else if (p >= 80) grades[i] = "A";
            else if (p >= 70) grades[i] = "B+";
            else if (p >= 60) grades[i] = "B";
            else if (p >= 50) grades[i] = "C";
            else grades[i] = "F";
        }
        return grades;
    }

    public static void displayScorecard(int[][] marks, double[][] totalsPercentages, String[] grades) {
        System.out.println("Student\tPhysics\tChemistry\tMaths\tTotal\tAverage\tPercentage\tGrade");
        System.out.println("--------------------------------------------------------------------------");
        for (int i = 0; i < marks.length; i++) {
            System.out.println((i+1) + "\t" + marks[i][0] + "\t" + marks[i][1] + "\t\t" + marks[i][2] + "\t" +
                    (int)totalsPercentages[i][0] + "\t" + totalsPercentages[i][1] + "\t" + totalsPercentages[i][2] + "\t\t" + grades[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int numStudents = sc.nextInt();

        int[][] marks = generateMarks(numStudents);
        double[][] totalsPercentages = calculateTotalsAndPercentage(marks);
        String[] grades = calculateGrades(totalsPercentages);

        displayScorecard(marks, totalsPercentages, grades);

        sc.close();
    }
}
