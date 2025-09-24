public class Person1 {
    String name;
    int id;
    Person1(String name, int id) {
        this.name = name;
        this.id = id;
    }
    void showDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}
interface Worker {
    void performDuties();
}
class Chef extends Person1 implements Worker {
    String specialty;
    Chef(String name, int id, String specialty) {
        super(name, id);
        this.specialty = specialty;
    }
    @Override
    public void performDuties() {
        System.out.println(name + " is cooking delicious " + specialty + " dishes.");
    }
    void showDetails() {
        super.showDetails();
        System.out.println("Specialty: " + specialty);
    }
}
class Waiter extends Person1 implements Worker {
    int tablesAssigned;
    Waiter(String name, int id, int tablesAssigned) {
        super(name, id);
        this.tablesAssigned = tablesAssigned;
    }
    @Override
    public void performDuties() {
        System.out.println(name + " is serving " + tablesAssigned + " tables.");
    }
    void showDetails() {
        super.showDetails();
        System.out.println("Tables Assigned: " + tablesAssigned);
    }
}
class RestaurantSystemDemo {
    public static void main(String[] args) {
        Chef chef = new Chef("Gordon Ramsay", 101, "Italian");
        Waiter waiter = new Waiter("John Smith", 201, 5);

        System.out.println("---- Chef ----");
        chef.showDetails();
        chef.performDuties();

        System.out.println("\n---- Waiter ----");
        waiter.showDetails();
        waiter.performDuties();
    }
}
