class NumberChecker {
    static int[] digitsArray(int n) {
        String s = String.valueOf(n);
        int[] arr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) arr[i] = s.charAt(i) - '0';
        return arr;
    }

    static int sumDigits(int[] arr) {
        int s = 0; for (int x : arr) s += x; return s;
    }

    static int sumSquares(int[] arr) {
        int s = 0; for (int x : arr) s += Math.pow(x,2); return s;
    }

    static boolean isHarshad(int n) {
        int[] arr = digitsArray(n);
        return n % sumDigits(arr) == 0;
    }

    static void frequency(int[] arr) {
        int[][] freq = new int[10][2];
        for (int i = 0; i < 10; i++) freq[i][0] = i;
        for (int x : arr) freq[x][1]++;
        for (int i = 0; i < 10; i++) if (freq[i][1] > 0) 
            System.out.println(freq[i][0] + " -> " + freq[i][1]);
    }

    public static void main(String[] args) {
        int n = 21;
        int[] arr = digitsArray(n);
        System.out.println("Sum: " + sumDigits(arr));
        System.out.println("Sum Squares: " + sumSquares(arr));
        System.out.println("Harshad: " + isHarshad(n));
        frequency(arr);
    }
}
