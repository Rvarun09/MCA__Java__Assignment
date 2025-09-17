import java.util.*;

public class StudentMarks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Random rand = new Random();
        int[][] marks = new int[n][3];
        int[][] result = new int[n][3];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) marks[i][j] = rand.nextInt(100);
        }

        System.out.println("Phy Chem Math Total Avg %");
        for (int i = 0; i < n; i++) {
            int total = marks[i][0] + marks[i][1] + marks[i][2];
            int avg = Math.round(total/3f);
            int per = Math.round(total/3f);
            System.out.println(marks[i][0]+"   "+marks[i][1]+"   "+marks[i][2]+"   "+total+"   "+avg+"   "+per);
        }
    }
}
