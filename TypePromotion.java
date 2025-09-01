public class TypePromotion {

    public static void main(String[] args) {

        System.out.println("--- Example 1: byte and short promotion ---");
        byte b = 10;
        short s = 20;
        
        int result1 = b + s;
        System.out.println("byte + short = " + result1 + " (Resulting type is int)");
        System.out.println();

        System.out.println("--- Example 2: int and long promotion ---");
        int i = 50;
        long l = 100L;
        
        long result2 = i + l;
        System.out.println("int + long = " + result2 + " (Resulting type is long)");
        System.out.println();

        System.out.println("--- Example 3: float and double promotion ---");
        float f = 25.5f;
        double d = 75.5;
        
        double result3 = f + d;
        System.out.println("float + double = " + result3 + " (Resulting type is double)");
        System.out.println();

        System.out.println("--- Example 4: Mixed types (int and double) ---");
        int num1 = 10;
        double num2 = 3.5;
        
        double result4 = num1 + num2;
        System.out.println("int + double = " + result4 + " (Resulting type is double)");
    }
    
}
