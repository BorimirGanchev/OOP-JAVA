import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Please provide paths to the accounts and transactions files.");
            return;
        }

        String accountsFilePath = args[0];
        String transactionsFilePath = args[1];

        Bank bank = new Bank();

        try {
            List<String> accountLines = Files.readAllLines(Paths.get(accountsFilePath));
            for (String line : accountLines) {
                String[] parts = line.split(",");
                String ownerName = parts[0];
                Account.AccountType accountType = Account.AccountType.valueOf(parts[1].toUpperCase());
                bank.addAccount(new Account(ownerName, accountType));
            }

            List<String> transactionLines = Files.readAllLines(Paths.get(transactionsFilePath));
            for (String line : transactionLines) {
                String[] parts = line.split(",");
                Transaction.TransactionType type = Transaction.TransactionType.valueOf(parts[0].toUpperCase());
                double amount = Double.parseDouble(parts[1]);
                String accountNumber = parts[2];
                if (type == Transaction.TransactionType.TRANSFER) {
                    String targetAccountNumber = parts[3];
                    bank.addTransaction(new Transaction(type, amount, accountNumber, targetAccountNumber));
                } else {
                    bank.addTransaction(new Transaction(type, amount, accountNumber));
                }
            }

            bank.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}