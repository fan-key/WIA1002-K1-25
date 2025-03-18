package Q4;

import java.sql.Date;

public class Transaction {
    Date date;
    char type;
    double amount;
    double balance;
    String description;

    Transaction(char type, double amount, double balance, String description) {
        this.date = new Date(System.currentTimeMillis());
        this.type = type;
        this.amount = amount;
        this.balance = balance;
        this.description = description;
    }
    @Override
    public String toString() {
        return 
                "date = " + date +
                ", type = " + type +
                ", amount = " + amount +
                ", balance = " + balance +
                ", description = " + description;
    }
}
