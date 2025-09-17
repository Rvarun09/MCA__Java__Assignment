class BankAccount {
    public String accountNumber;
    protected String accountHolder;
    private double balance;

    BankAccount(String accNum, String holder, double bal) {
        accountNumber = accNum;
        accountHolder = holder;
        balance = bal;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double newBalance) {
        if (newBalance >= 0) {
            balance = newBalance;
        } else {
            System.out.println("Balance cannot be negative");
        }
    }

    public void displayAccount() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
        System.out.println();
    }
}

class SavingsAccount extends BankAccount {
    double interestRate;

    SavingsAccount(String accNum, String holder, double bal, double rate) {
        super(accNum, holder, bal);
        interestRate = rate;
    }

    public void displaySavingsAccount() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Interest Rate: " + interestRate + "%");
        System.out.println("Balance: " + getBalance());
        System.out.println();
    }
}

public class BankAccountManagement {
    public static void main(String[] args) {
        BankAccount b1 = new BankAccount("1234567890", "Alice", 5000);
        b1.displayAccount();
        b1.setBalance(7000);
        b1.displayAccount();

        SavingsAccount s1 = new SavingsAccount("9876543210", "Bob", 10000, 4.5);
        s1.displaySavingsAccount();
    }
}