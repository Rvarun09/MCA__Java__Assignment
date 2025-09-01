public class DefaultValues {

    byte byteValue;
    short shortValue;
    int intValue;
    long longValue;
    float floatValue;
    double doubleValue;
    char charValue;
    boolean booleanValue;

    String stringValue;

    public static void main(String[] args) {

        DefaultValues defaults = new DefaultValues();

        System.out.println("Default values of instance variables:");
        System.out.println("byte: " + defaults.byteValue);
        System.out.println("short: " + defaults.shortValue);
        System.out.println("int: " + defaults.intValue);
        System.out.println("long: " + defaults.longValue);
        System.out.println("float: " + defaults.floatValue);
        System.out.println("double: " + defaults.doubleValue);
        System.out.println("char: '" + defaults.charValue + "' (Note: This is the null character)");
        System.out.println("boolean: " + defaults.booleanValue);
        System.out.println("String: " + defaults.stringValue);
    }
    
}
