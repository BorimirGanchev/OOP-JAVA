import java.util.*;

public class Bank {
    private List<Account> accounts;
    private PriorityQueue<Transaction> transactions;

    public Bank() {
        this.accounts = new ArrayList<>();
        this.transactions = new PriorityQueue<>(new TransactionComparator());
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public void withdraw(String accountId, double amount) {
        Transaction transaction = new WithdrawTransaction(accountId, amount);
        addTransaction(transaction);
    }

    public void addMoney(String accountId, double amount) {
        Transaction transaction = new AddMoneyTransaction(accountId, amount);
        addTransaction(transaction);
    }

    public void transfer(String fromAccountId, String toAccountId, double amount) {
        Transaction transaction = new TransferTransaction(fromAccountId, toAccountId, amount);
        addTransaction(transaction);
    }

    public void flush() {
        while (!transactions.isEmpty()) {
            Transaction transaction = transactions.poll();
            transaction.process(accounts);
        }
    }
}