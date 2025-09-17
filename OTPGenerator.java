import java.util.*;

class OTPGenerator {
    static int generateOTP() {
        return (int)(Math.random()*900000)+100000;
    }

    static boolean allUnique(int[] arr) {
        Set<Integer> set=new HashSet<>();
        for(int x:arr)set.add(x);
        return set.size()==arr.length;
    }

    public static void main(String[] args) {
        int[] otps=new int[10];
        for(int i=0;i<10;i++)otps[i]=generateOTP();
        for(int x:otps)System.out.println(x);
        System.out.println("All Unique: "+allUnique(otps));
    }
}
