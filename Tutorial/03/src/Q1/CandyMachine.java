package Q1;

public class CandyMachine {
    public CashRegister cashRegister;
    public Dispenser candyDispenser;
    public Dispenser chipsDispenser;
    public Dispenser gumDispenser;
    public Dispenser cookieDispenser;

    CandyMachine(){
        cashRegister = new CashRegister();
        candyDispenser = new Dispenser("Candy", 10, 2);
        chipsDispenser = new Dispenser("Chips", 5, 3);
        gumDispenser = new Dispenser("Gum", 20, 1);
        cookieDispenser = new Dispenser("Cookie", 15, 4);
    }

    public void showProducts(){
        System.out.println("Available Products:");
        System.out.println("1. " + candyDispenser.name + " - Price: " + candyDispenser.price + " - Available: " + candyDispenser.getItemCount());
        System.out.println("2. " + chipsDispenser.name + " - Price: " + chipsDispenser.price + " - Available: " + chipsDispenser.getItemCount());
        System.out.println("3. " + gumDispenser.name + " - Price: " + gumDispenser.price + " - Available: " + gumDispenser.getItemCount());
        System.out.println("4. " + cookieDispenser.name + " - Price: " + cookieDispenser.price + " - Available: " + cookieDispenser.getItemCount());
    }


}
