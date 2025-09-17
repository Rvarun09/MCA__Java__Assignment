import java.util.Scanner;
public class SimpleInterest{
    int principal;
    int rate;
    int time;
    int interest;
    int SIinterest(int p, int r, int t){
    principal = p;
    rate = r;
    time = t;
    interest = (p*r*t)/100;
    return interest;
    }
    void display(){
        System.out.println("The Simple Interest is :"+interest+" for Principal :"+principal+" , Rate of Interest :"+rate+ " and Time : "+time);
    }
}
class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Principal amount :");
        int p = sc.nextInt();
        System.out.print("Enter rate of interest :");
        int r = sc.nextInt();
        System.out.print("Enter time :");
        int t = sc.nextInt();
        SimpleInterest s1 = new SimpleInterest();
        s1.SIinterest(p, r, t);
        s1.display();
    }
}