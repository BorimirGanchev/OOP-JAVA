import java.util.UUID;

public class Account {


    private String accountNumber;
    private String ownerName;
    private double balance;
    private AccountType accountType;

    public Account(String ownerName, AccountType accountType) {
        this.accountNumber = UUID.randomUUID().toString();
        this.ownerName = ownerName;
        this.balance = 0;
        this.accountType = accountType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void add(double amount) {
        this.balance += amount;
    }

    public void remove(double amount) {
        if (this.balance < amount) {
            throw new IllegalArgumentException("Not enough balance");
        }
        this.balance -= amount;
    }
}