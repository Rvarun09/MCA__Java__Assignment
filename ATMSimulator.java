class BankAccount {
    public String accountHolder;
    public String accountNumber;
    public double balance;
    public BankAccount(String accountHolder, String accountNumber, double initialBalance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }
    public void withdraw(double amount) {
        if (amount > 0 && amount<=balance) {
            balance -= amount;
            System.out.println("Successfully withdrawn :"+amount);
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }
    public void displayBalance() {
        System.out.println("Current balance: $" + balance);
    }
}
public class ATMSimulator {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("John Doe", "123456789", 500.00);
        account.displayBalance();
        account.withdraw(250.0);
        account.displayBalance();
    }
}
