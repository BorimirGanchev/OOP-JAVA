import java.security.InvalidParameterException;
import java.util.UUID;

public class Account {
    private String name;
    private double balance;
    private String id;

    public Account(String name, long balance) {
        this.name = name;
        this.balance = 0;
        this.id = generateRandomId();
    }

    private String generateRandomId() {
        return UUID.randomUUID().toString();
    }

    public double add(double balance) {
        this.balance += balance;
        return this.balance;
    }

    public double remove(double balance) {
        if (this.balance < balance) {
            throw new NotEnoughMoney("Balance is too low");
        }else{
            this.balance -= balance;
            return this.balance;
        }
    }
}