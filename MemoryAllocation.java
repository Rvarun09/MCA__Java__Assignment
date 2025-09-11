class MemoryAllocation {
    public static void main(String[] args) {
        int x = 10;
        int y = x;
        y++;
        System.out.println(x);
        System.out.println(y);

        int[] arr1 = {1, 2, 3};
        int[] arr2 = arr1;
        arr2[0] = 99;
        System.out.println(arr1[0]);
        System.out.println(arr2[0]);
    }
}
