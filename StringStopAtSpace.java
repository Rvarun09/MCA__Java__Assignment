import java.util.Scanner;

public class StringStopAtSpace {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        for (char ch : str.toCharArray()) {
            if (ch == ' ') break;
            System.out.print(ch);
        }
        sc.close();
    }
}
