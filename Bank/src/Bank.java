import java.util.*;

public class Bank {
    private List<Account> accounts;
    private PriorityQueue<Transaction> transactions;

    public Bank() {
        this.accounts = new ArrayList<>();
        this.transactions = new PriorityQueue<>(Comparator.comparing((Transaction t) -> {Account account = getAccountByNumber(t.getAccountNumber());
            return account.getAccountType() == Account.AccountType.BUSINESS ? 0 : 1;
        }).thenComparing(t -> transactions.size()));
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public void withdraw(String accountNumber, double amount) {
        addTransaction(new Transaction(Transaction.TransactionType.WITHDRAWAL, amount, accountNumber));
    }

    public void addMoney(String accountNumber, double amount) {
        addTransaction(new Transaction(Transaction.TransactionType.DEPOSIT, amount, accountNumber));
    }

    public void transfer(String fromAccountNumber, String toAccountNumber, double amount) {
        addTransaction(new Transaction(Transaction.TransactionType.TRANSFER, amount, fromAccountNumber, toAccountNumber));
    }

    public void flush() {
        while (!transactions.isEmpty()) {
            Transaction transaction = transactions.poll();
            processTransaction(transaction);
        }
    }

    private void processTransaction(Transaction transaction) {
        Account account = getAccountByNumber(transaction.getAccountNumber());
        switch (transaction.getType()) {
            case DEPOSIT:
                account.add(transaction.getAmount());
                break;
            case WITHDRAWAL:
                account.remove(transaction.getAmount());
                break;
            case TRANSFER:
                Account targetAccount = getAccountByNumber(transaction.getTargetAccountNumber());
                account.remove(transaction.getAmount());
                targetAccount.add(transaction.getAmount());
                break;
        }
    }

    private Account getAccountByNumber(String accountNumber) {
        return accounts.stream()
                .filter(account -> account.getAccountNumber().equals(accountNumber))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Account not found"));
    }
}