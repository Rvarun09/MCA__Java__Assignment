public class VarExample {

    public static void main(String[] args) {

        System.out.println("--- Demonstrating 'var' with different data types ---");

        var greeting = "Hello, Java!";
        System.out.println("Variable 'greeting' is a " + ((Object)greeting).getClass().getName() + " with value: " + greeting);

        var count = 100;
        System.out.println("Variable 'count' is an " + ((Object)count).getClass().getName() + " with value: " + count);

        var price = 25.50;
        System.out.println("Variable 'price' is a " + ((Object)price).getClass().getName() + " with value: " + price);

        var isJavaFun = true;
        System.out.println("Variable 'isJavaFun' is a " + ((Object)isJavaFun).getClass().getName() + " with value: " + isJavaFun);

        var myList = new java.util.ArrayList<String>();
        myList.add("Element 1");
        myList.add("Element 2");
        System.out.println("Variable 'myList' is a " + myList.getClass().getName() + " with value: " + myList);

        System.out.println("\n--- Common errors with 'var' ---");
    }
    
}
