abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public abstract double calculateInterest();

    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: " + balance);
    }
}

interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

class SavingsAccount extends BankAccount implements Loanable {
    private double interestRate = 0.04;
    private double loanLimit = 50000;

    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * interestRate;
    }

    @Override
    public void applyForLoan(double amount) {
        if (amount <= loanLimit && calculateLoanEligibility()) {
            System.out.println("Loan of " + amount + " approved for Savings Account.");
        } else {
            System.out.println("Loan request denied for Savings Account.");
        }
    }

    @Override
    public boolean calculateLoanEligibility() {
        return getBalance() >= 1000;
    }
}

class CurrentAccount extends BankAccount implements Loanable {
    private double interestRate = 0.02;
    private double loanLimit = 200000;

    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * interestRate;
    }

    @Override
    public void applyForLoan(double amount) {
        if (amount <= loanLimit && calculateLoanEligibility()) {
            System.out.println("Loan of " + amount + " approved for Current Account.");
        } else {
            System.out.println("Loan request denied for Current Account.");
        }
    }

    @Override
    public boolean calculateLoanEligibility() {
        return getBalance() >= 5000;
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount("SAV123", "Alice", 10000);
        CurrentAccount current = new CurrentAccount("CUR456", "Bob", 50000);

        System.out.println("=== Savings Account ===");
        savings.displayDetails();
        savings.deposit(2000);
        savings.withdraw(3000);
        System.out.println("Interest: " + savings.calculateInterest());
        savings.applyForLoan(20000);
        System.out.println("--------------------------");

        System.out.println("=== Current Account ===");
        current.displayDetails();
        current.deposit(10000);
        current.withdraw(5000);
        System.out.println("Interest: " + current.calculateInterest());
        current.applyForLoan(150000);
        System.out.println("--------------------------");
    }
}
