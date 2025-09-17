import java.util.Random;

public class EmployeeBonus {
    public static void main(String[] args) {
        Random rand = new Random();
        int[][] data = new int[10][2];
        for (int i = 0; i < 10; i++) {
            data[i][0] = 10000 + rand.nextInt(90000);
            data[i][1] = 1 + rand.nextInt(10);
        }

        double totalOld=0, totalNew=0, totalBonus=0;
        System.out.println("Salary   Years   NewSalary   Bonus");
        for (int i = 0; i < 10; i++) {
            int salary = data[i][0];
            int years = data[i][1];
            double bonus = (years>5) ? salary*0.05 : salary*0.02;
            double newSalary = salary + bonus;
            totalOld += salary;
            totalNew += newSalary;
            totalBonus += bonus;
            System.out.println(salary+"   "+years+"   "+(int)newSalary+"   "+(int)bonus);
        }
        System.out.println("Total Old:"+totalOld+" Total New:"+totalNew+" Total Bonus:"+totalBonus);
    }
}
