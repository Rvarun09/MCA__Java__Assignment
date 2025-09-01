public class SwapWithThirdVariable {
    public static void main(String[] args) {

        // Declare and initialize two integer variables.
        int number1 = 15;
        int number2 = 25;

        System.out.println("Before swapping:");
        System.out.println("number1 = " + number1);
        System.out.println("number2 = " + number2);

        // Declare a temporary variable to hold one of the values during the swap.
        int temp;

        // Step 1: Store the value of number1 in the temp variable.
        temp = number1;

        // Step 2: Assign the value of number2 to number1.
        number1 = number2;

        // Step 3: Assign the original value of number1 (now in temp) to number2.
        number2 = temp;

        System.out.println("\nAfter swapping:");
        System.out.println("number1 = " + number1);
        System.out.println("number2 = " + number2);
    }
    
}
