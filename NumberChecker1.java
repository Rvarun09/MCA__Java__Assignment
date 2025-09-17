import java.util.*;

class NumberChecker1 {
    static int[] digitsArray(int n) {
        String s = String.valueOf(n);
        int[] arr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) arr[i] = s.charAt(i) - '0';
        return arr;
    }

    static int[] reverse(int[] arr) {
        int[] rev = new int[arr.length];
        for (int i = 0; i < arr.length; i++) rev[i] = arr[arr.length - 1 - i];
        return rev;
    }

    static boolean arraysEqual(int[] a, int[] b) {
        return Arrays.equals(a, b);
    }

    static boolean isPalindrome(int n) {
        int[] arr = digitsArray(n);
        return arraysEqual(arr, reverse(arr));
    }

    static boolean isDuck(int n) {
        int[] arr = digitsArray(n);
        for (int x : arr) if (x == 0) return true;
        return false;
    }

    public static void main(String[] args) {
        int n = 121;
        System.out.println("Palindrome: " + isPalindrome(n));
        System.out.println("Duck: " + isDuck(n));
    }
}
