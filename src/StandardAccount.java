public class StandardAccount implements BankManagerInterface{
    private double balance;
    TransactionHistory history = new TransactionHistory();

public StandardAccount() {}
@Override
public void deposit(double amount) {
    if (amount > 0) {
        balance += amount;
        System.out.println("Insättning: " + amount + "kr. " + "\nNytt kontosaldo:" + " " + balance + "kr.");
        history.addTransaction("Insättning", amount);
    } else {
        System.out.println("Invalid deposit amount.");
    }
}
    public double getBalance() {
        return balance;
    }
    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Uttag: " + amount + "kr. " + "\nNytt kontosaldo: " + balance + "kr.");
            history.addTransaction("Uttag", amount);

        } else {
            System.out.println("Gick inte ta ut pengar. För lite saldo för vald summa");
        }

    }
}

