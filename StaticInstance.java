class StaticInstance {
    static int staticVar = 0;
    int instanceVar = 0;

    void increment() {
        staticVar++;
        instanceVar++;
        System.out.println(staticVar + " " + instanceVar);
    }

    public static void main(String[] args) {
        StaticInstance obj1 = new StaticInstance();
        StaticInstance obj2 = new StaticInstance();
        obj1.increment();
        obj1.increment();
        obj2.increment();
    }
}
