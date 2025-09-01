public class ASCIIValue {

    public static void main(String[] args) {

        // Declare a character variable. You can change this to any character.
        char character = 'J';

        // When a 'char' is assigned to an 'int', Java implicitly converts
        // the character to its corresponding ASCII integer value.
        int asciiValue = character;

        // Print the character and its corresponding ASCII value.
        System.out.println("The character is: " + character);
        System.out.println("The ASCII value of '" + character + "' is: " + asciiValue);
    }
    
}
