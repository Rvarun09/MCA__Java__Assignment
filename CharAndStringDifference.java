public class CharAndStringDifference {

     public static void main(String[] args) {

        System.out.println("--- 1. Data Type & Memory ---");

        char singleCharacter = 'A';
        System.out.println("A 'char' variable: " + singleCharacter);

        String sequenceOfCharacters = "Hello, world!";
        System.out.println("A 'String' variable: " + sequenceOfCharacters);

        System.out.println("Length of the String: " + sequenceOfCharacters.length());
        System.out.println();


        System.out.println("--- 2. Declaration & Immutability ---");
        char myChar = 'C';
        System.out.println("char declared with single quotes: " + myChar);

        String myString = "Java";
        System.out.println("String declared with double quotes: " + myString);

        String anotherString = myString.concat(" is great!");
        System.out.println("Original String after concat: " + myString);
        System.out.println("New String after concat: " + anotherString);
        System.out.println();


        System.out.println("--- 3. Operations & Methods ---");
        char nextChar = (char) (singleCharacter + 1); 
        System.out.println("Result of 'A' + 1: " + nextChar);

        char charAtIndex = sequenceOfCharacters.charAt(7); 
        System.out.println("Character at index 7 of the String: " + charAtIndex);
    }
    
}
