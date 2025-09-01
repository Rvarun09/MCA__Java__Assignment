public class MemoryAllocation {
    
    public static class Person {
        String name;

        public Person(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {

        System.out.println("--- Primitive Variables (stored on the stack) ---");

        int a = 10;
        System.out.println("a = " + a);

        int b = a;
        System.out.println("b = " + b);

        a = 20;
        System.out.println("\nAfter changing 'a' to 20:");
        System.out.println("a = " + a);
        System.out.println("b = " + b); 
        System.out.println("----------------------------------------------\n");

        System.out.println("--- Reference Variables (references on stack, objects on heap) ---");

        Person p1 = new Person("Alice");
        System.out.println("p1.name = " + p1.name);

        Person p2 = p1;
        System.out.println("p2.name = " + p2.name);

        p2.name = "Bob";
        System.out.println("\nAfter changing p2.name to Bob:");
        System.out.println("p2.name = " + p2.name);
        System.out.println("p1.name = " + p1.name); 
    }
}
