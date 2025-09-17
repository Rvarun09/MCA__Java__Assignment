class NumberChecker3 {
    static int[] factors(int n) {
        int c = 0;
        for (int i=1;i<=n;i++) if(n%i==0)c++;
        int[] arr=new int[c];
        int j=0;
        for (int i=1;i<=n;i++) if(n%i==0)arr[j++]=i;
        return arr;
    }

    static int greatestFactor(int[] arr) {
        return arr[arr.length-2];
    }

    static int sumFactors(int[] arr) {
        int s=0;for(int x:arr)s+=x;return s;
    }

    static int productFactors(int[] arr) {
        int p=1;for(int x:arr)p*=x;return p;
    }

    static double productCubeFactors(int[] arr) {
        double p=1;for(int x:arr)p*=Math.pow(x,3);return p;
    }

    static boolean isPerfect(int n) {
        int[] arr=factors(n);
        return sumFactors(arr)-n==n;
    }

    static boolean isAbundant(int n) {
        int[] arr=factors(n);
        return sumFactors(arr)-n>n;
    }

    static boolean isDeficient(int n) {
        int[] arr=factors(n);
        return sumFactors(arr)-n<n;
    }

    static boolean isStrong(int n) {
        int temp=n,sum=0;
        while(temp>0){
            int d=temp%10;
            int f=1;for(int i=1;i<=d;i++)f*=i;
            sum+=f;temp/=10;
        }
        return sum==n;
    }

    public static void main(String[] args) {
        int n=28;
        int[] arr=factors(n);
        System.out.println("Greatest Factor: "+greatestFactor(arr));
        System.out.println("Sum: "+sumFactors(arr));
        System.out.println("Product: "+productFactors(arr));
        System.out.println("Product Cube: "+productCubeFactors(arr));
        System.out.println("Perfect: "+isPerfect(n));
        System.out.println("Abundant: "+isAbundant(n));
        System.out.println("Deficient: "+isDeficient(n));
        System.out.println("Strong: "+isStrong(n));
    }
}
