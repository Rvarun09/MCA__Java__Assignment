import java.util.Scanner;

public class DistanceEquation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();

        double distance = Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y1,2));
        double m = (y2-y1)/(x2-x1);
        double b = y1 - m*x1;

        System.out.println("Distance: " + distance);
        System.out.println("Equation: y = " + m + "x + " + b);
    }
}
