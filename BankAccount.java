public class BankAccount {
    String accountNumber;
    double balance;
    BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    void showDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
    }
}
class SavingsAccount extends BankAccount {
    double interestRate;
    SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }
    void displayAccountType() {
        System.out.println("This is a Savings Account.");
    }
    void showDetails() {
        super.showDetails();
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}
class CheckingAccount extends BankAccount {
    double withdrawalLimit;
    CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }
    void displayAccountType() {
        System.out.println("This is a Checking Account.");
    }
    void showDetails() {
        super.showDetails();
        System.out.println("Withdrawal Limit: $" + withdrawalLimit);
    }
}
class FixedDepositAccount extends BankAccount {
    int lockInPeriod; 
    FixedDepositAccount(String accountNumber, double balance, int lockInPeriod) {
        super(accountNumber, balance);
        this.lockInPeriod = lockInPeriod;
    }
    void displayAccountType() {
        System.out.println("This is a Fixed Deposit Account.");
    }
    void showDetails() {
        super.showDetails();
        System.out.println("Lock-in Period: " + lockInPeriod + " months");
    }
}
class BankSystemDemo {
    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount("SA123", 5000, 4.5);
        CheckingAccount ca = new CheckingAccount("CA456", 2000, 1000);
        FixedDepositAccount fda = new FixedDepositAccount("FD789", 10000, 12);
        System.out.println("---- Savings Account ----");
        sa.displayAccountType();
        sa.showDetails();
        System.out.println("\n---- Checking Account ----");
        ca.displayAccountType();
        ca.showDetails();
        System.out.println("\n---- Fixed Deposit Account ----");
        fda.displayAccountType();
        fda.showDetails();
    }
}
