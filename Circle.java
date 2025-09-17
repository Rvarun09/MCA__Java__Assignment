public class Circle {
    double radius;

    Circle() {
        this(5.0); // default value
    }

    Circle(double r) {
        radius = r;
    }

    void display() {
        System.out.println("Radius: " + radius);
    }

    public static void main(String[] args) {
        Circle c1 = new Circle();      // uses default radius
        Circle c2 = new Circle(10.5);  // uses user-provided radius

        c1.display();
        c2.display();
    }
}
