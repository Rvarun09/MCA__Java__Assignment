public class ContinueExample {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            if (i == 5) {
                continue; // Skip the iteration when i is 5
            }
            System.out.println(i);
        }
    }
}
