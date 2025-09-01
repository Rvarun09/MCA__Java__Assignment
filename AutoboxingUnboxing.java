public class AutoboxingUnboxing {

    public static void main(String[] args) {

        System.out.println("--- Demonstrating Autoboxing ---");

        int primitiveInt = 50;
        Integer wrapperInt = primitiveInt;

        System.out.println("The primitive `int` value is: " + primitiveInt);
        System.out.println("The autoboxed `Integer` object is: " + wrapperInt);
        System.out.println(); 
        System.out.println("--- Demonstrating Unboxing ---");

        Integer wrapperInteger = 100;
        int primitiveInteger = wrapperInteger;

        System.out.println("The `Integer` object value is: " + wrapperInteger);
        System.out.println("The unboxed `int` primitive is: " + primitiveInteger);
        System.out.println();

        System.out.println("--- Autoboxing and Unboxing in a method call ---");

        int sum = addNumbers(wrapperInt, primitiveInteger);
        System.out.println("Sum of autoboxed and unboxed numbers: " + sum);
    }

    public static int addNumbers(Integer a, Integer b) {
        return a + b;
    }
}
