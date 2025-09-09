import java.util.Scanner;

public class StopAtSpace {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch == ' ') {
                break;
            }
            System.out.println(ch);
        }

        sc.close();
    }
}
