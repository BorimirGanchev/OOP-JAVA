public abstract class Transaction {
    private double amount;
    private int SourceAccount;
    private int DestinationAccount;

    public Transaction(double amount, int sourceAccount, int destinationAccount) {
        this.amount = amount;
        SourceAccount = sourceAccount;
        DestinationAccount = destinationAccount;
    }

}
