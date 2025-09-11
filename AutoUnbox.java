class AutoUnbox {
    public static void main(String[] args) {
        int a = 10;
        Integer obj = a;
        int b = obj;
        System.out.println(obj);
        System.out.println(b);
    }
}
