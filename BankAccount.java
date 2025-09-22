public class BankAccount {
     
    private static String bankName = "Default Bank";
    private static int totalAccounts = 0;


    private final String accountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccount(String accountHolderName, String accountNumber, double balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
        totalAccounts++;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }


    public static void setBankName(String name) {
        bankName = name;
    }

    public static String getBankName() {
        return bankName;
    }
   public void displayDetails() {
        if (this instanceof BankAccount) {
            System.out.println("Bank Name: " + bankName);
            System.out.println("Account Holder: " + accountHolderName);
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Balance: " + balance);
        } else {
            System.out.println("Not a valid BankAccount object.");
        }
    }

    
    public static void main(String[] args) {
        BankAccount.setBankName("Copilot Bank");
        BankAccount acc1 = new BankAccount("Alice", "12345", 1000.0);
        BankAccount acc2 = new BankAccount("Bob", "67890", 2000.0);

        acc1.displayDetails();
        System.out.println();
        acc2.displayDetails();

        System.out.println("\nTotal Accounts: " + BankAccount.getTotalAccounts());
    }
}
