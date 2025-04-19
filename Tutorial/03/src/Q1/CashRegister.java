package Q1;

public class CashRegister {
    double total;

    CashRegister() {
        total = 0.0;
    }

    public void addToTotal(double amount) {
        total += amount;
    }

    public double getTotal() {
        return total;
    }


}
