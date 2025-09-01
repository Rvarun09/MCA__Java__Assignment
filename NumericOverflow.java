public class NumericOverflow {

    public static void main(String[] args) {

        System.out.println("--- Integer Overflow (Wrapping Around) ---");

        int maxInt = Integer.MAX_VALUE;
        System.out.println("Maximum integer value: " + maxInt);
        int overflowInt = maxInt + 1;
        System.out.println("Adding 1 to max value results in: " + overflowInt);

        System.out.println(); 
        int minInt = Integer.MIN_VALUE;
        System.out.println("Minimum integer value: " + minInt);
        int underflowInt = minInt - 1;
        System.out.println("Subtracting 1 from min value results in: " + underflowInt); 

        System.out.println();

        long maxLong = Long.MAX_VALUE;
        System.out.println("Maximum long value: " + maxLong);
        long overflowLong = maxLong + 1;
        System.out.println("Adding 1 to max long value results in: " + overflowLong);

        System.out.println("\n--- Floating-Point Overflow (Infinity) ---");

        double positiveInfinity = Double.MAX_VALUE * 2;
        System.out.println("Positive overflow results in: " + positiveInfinity); 

        double negativeInfinity = -Double.MAX_VALUE * 2;
        System.out.println("Negative overflow results in: " + negativeInfinity); 
    }
    
}
