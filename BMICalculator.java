import java.util.Scanner;

public class BMICalculator {

    public static String[] computeBMI(double weightKg, double heightCm) {
        double heightM = heightCm / 100.0;
        double bmi = weightKg / (heightM * heightM);
        bmi = Math.round(bmi * 100.0) / 100.0;
        String status = "";
        if (bmi < 18.5) status = "Underweight";
        else if (bmi < 24.9) status = "Normal";
        else if (bmi < 29.9) status = "Overweight";
        else status = "Obese";
        return new String[]{String.valueOf(weightKg), String.valueOf(heightCm), String.valueOf(bmi), status};
    }

    public static String[][] processTeam(double[][] teamData) {
        int n = teamData.length;
        String[][] result = new String[n][4];
        for (int i = 0; i < n; i++) {
            result[i] = computeBMI(teamData[i][0], teamData[i][1]);
        }
        return result;
    }

    public static void displayBMIResults(String[][] data) {
        System.out.println("Person\tWeight(kg)\tHeight(cm)\tBMI\tStatus");
        System.out.println("------------------------------------------------------");
        for (int i = 0; i < data.length; i++) {
            System.out.println((i + 1) + "\t" + data[i][0] + "\t\t" + data[i][1] + "\t\t" + data[i][2] + "\t" + data[i][3]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] teamData = new double[10][2];

        for (int i = 0; i < 10; i++) {
            System.out.print("Enter weight (kg) for person " + (i+1) + ": ");
            teamData[i][0] = sc.nextDouble();
            System.out.print("Enter height (cm) for person " + (i+1) + ": ");
            teamData[i][1] = sc.nextDouble();
        }

        String[][] bmiResults = processTeam(teamData);
        displayBMIResults(bmiResults);

        sc.close();
    }
}
