import java.util.ArrayList;
import java.util.List;
import java.util.Random;


class Account {
    private int accountNumber;
    private double balance;
    private Bank bank; 
    
    public Account(int accountNumber, double balance, Bank bank) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.bank = bank;
    }

    public double getBalance() {
        return balance;
    }

    public String getBankName() {
        return bank.getName();
    }

    @Override
    public String toString() {
        return "Acc #" + accountNumber + " at " + bank.getName() + ": $" + balance;
    }
}

class Customer {
    private String name;

    private List<Account> myAccounts; 

    public Customer(String name) {
        this.name = name;
        this.myAccounts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    
    public void addAccount(Account account) {
        myAccounts.add(account);
    }

    
    public void viewBalance() {
        System.out.println("--- Balance Statement for " + name + " ---");
        if (myAccounts.isEmpty()) {
            System.out.println("No active accounts.");
        } else {
            for (Account acc : myAccounts) {
                System.out.println(acc);
            }
        }
        System.out.println();
    }
}


class Bank {
    private String name;
    private List<Account> allAccounts;

    public Bank(String name) {
        this.name = name;
        this.allAccounts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void openAccount(Customer customer, double initialDeposit) {
        
        int accNum = new Random().nextInt(9000) + 1000; 
        
       
        Account newAccount = new Account(accNum, initialDeposit, this);
        
  
        allAccounts.add(newAccount);
        
      
        customer.addAccount(newAccount);
        
        System.out.println("Success: Opened Account #" + accNum + " for " + customer.getName() + " at " + this.name);
    }
}

public class BankAssociation {
    public static void main(String[] args) {
     
        Bank bankA = new Bank("Chase Bank");
        Bank bankB = new Bank("Wells Fargo");
        
        Customer john = new Customer("John Doe");
        Customer jane = new Customer("Jane Smith");

    
        bankA.openAccount(john, 500.00);
        
       
        bankB.openAccount(john, 1200.50);
        
        
        bankA.openAccount(jane, 300.00);

        System.out.println(); // Spacing

        john.viewBalance();
        
        jane.viewBalance();
    }
}