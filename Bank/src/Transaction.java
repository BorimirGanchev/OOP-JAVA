public class Transaction {
    public enum TransactionType { DEPOSIT, WITHDRAWAL, TRANSFER }

    private TransactionType type;
    private double amount;
    private String accountNumber;
    private String targetAccountNumber;

    public Transaction(TransactionType type, double amount, String accountNumber) {
        this(type, amount, accountNumber, null);
    }

    public Transaction(TransactionType type, double amount, String accountNumber, String targetAccountNumber) {
        this.type = type;
        this.amount = amount;
        this.accountNumber = accountNumber;
        this.targetAccountNumber = targetAccountNumber;
    }

    public TransactionType getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getTargetAccountNumber() {
        return targetAccountNumber;
    }
}