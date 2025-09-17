import java.util.Scanner;

public class CollinearPoints {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x1 = sc.nextDouble(), y1 = sc.nextDouble();
        double x2 = sc.nextDouble(), y2 = sc.nextDouble();
        double x3 = sc.nextDouble(), y3 = sc.nextDouble();

        double slope1 = (y2-y1)/(x2-x1);
        double slope2 = (y3-y2)/(x3-x2);
        if (slope1 == slope2) System.out.println("Collinear");
        else System.out.println("Not Collinear");
    }
}
