public class TypeCasting {

    public static void main(String[] args) {

        System.out.println("--- Implicit (Widening) Casting ---");

        int intValue = 100;
        long longValue = intValue;
        System.out.println("Original int value: " + intValue);
        System.out.println("After casting to long: " + longValue);

        long longNumber = 500000000L;
        float floatNumber = longNumber;
        System.out.println("Original long value: " + longNumber);
        System.out.println("After casting to float: " + floatNumber);

        char character = 'A';
        int asciiValue = character;
        System.out.println("Original char value: " + character);
        System.out.println("After casting to int: " + asciiValue);

        System.out.println("\n--- Explicit (Narrowing) Casting ---");

        double doubleValue = 123.456;
        int convertedInt = (int) doubleValue;
        System.out.println("Original double value: " + doubleValue);

        System.out.println("After explicit casting to int: " + convertedInt);

        int largeIntValue = 130;
        byte convertedByte = (byte) largeIntValue;
        System.out.println("Original int value: " + largeIntValue);
        System.out.println("After explicit casting to byte: " + convertedByte);
    }
  
}
