public class NumberConverter {

    public static void main(String[] args) {

        int decimalNumber = 42;
        System.out.println("Original Decimal Number: " + decimalNumber);

        String binaryString = Integer.toBinaryString(decimalNumber);
        System.out.println("Binary Representation: " + binaryString);

        String hexString = Integer.toHexString(decimalNumber);
        System.out.println("Hexadecimal Representation: " + hexString);
    }
    
}
