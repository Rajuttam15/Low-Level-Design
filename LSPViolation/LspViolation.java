package LSPViolation;
import java.util.*;
public class LspViolation {
     public static void main(String[] args) {
        List<Account> accounts = new ArrayList<>();
        accounts.add(new SavingAccounts());
        accounts.add(new CurrentAccount());
        accounts.add(new FixedTermAccount());

        BankClient client = new BankClient(accounts);
        client.processTransactions(); // Throws exception when withdrawing from FixedTermAccount
    }
}
interface Account {
    void deposit(double amount);
    void withdraw(double amount);
}
//saving class
class SavingAccounts implements Account{
    private double balance;

    public  SavingAccounts() {
        balance = 0;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + " in Savings Account. New Balance: " + balance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + " from Savings Account. New Balance: " + balance);
        } else {
            System.out.println("Insufficient funds in Savings Account!");
        }
    }
}
//current class
class CurrentAccount implements Account {
    private double balance;

    public CurrentAccount() {
        balance = 0;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + " in Current Account. New Balance: " + balance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + " from Current Account. New Balance: " + balance);
        } else {
            System.out.println("Insufficient funds in Current Account!");
        }
    }
}
//fixed class
class FixedTermAccount implements Account {
    private double balance;

    public FixedTermAccount() {
        balance = 0;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + " in Fixed Term Account. New Balance: " + balance);
    }

    @Override
    public void withdraw(double amount) {
        throw new UnsupportedOperationException("Withdrawal not allowed in Fixed Term Account!");
    }
}
//client
class BankClient {
    private List<Account> accounts;

    public BankClient(List<Account> accounts) {
        this.accounts = accounts;
    }

    public void processTransactions() {
        for (Account acc : accounts) {
            acc.deposit(1000);  // All accounts allow deposits

            // Assuming all accounts support withdrawal (LSP Violation)
            try {
                acc.withdraw(500);
            } catch (UnsupportedOperationException e) {
                System.out.println("Exception: " + e.getMessage());
            }
        }
    }
}
