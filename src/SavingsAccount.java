public class SavingsAccount implements BankManagerInterface{
    private double balanceSavingsAccount;
    TransactionHistory history = new TransactionHistory();

    @Override
    public void deposit(double amount) {
        System.out.println("SPARKONTO");
        if (amount > 0) {
            balanceSavingsAccount += amount;
            System.out.println("Insättning: " + amount + " . Nytt värde konto: " + balanceSavingsAccount);
        } else {
            System.out.println("Gick inte ta ut pengar. För lite saldo för vald summa");
        }
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("SPARKONTO");
        if (amount > 0 && amount <= balanceSavingsAccount) {
            balanceSavingsAccount -= amount;
            System.out.println("Uttag: " + amount + " . Nytt värde konto: " + balanceSavingsAccount);
        } else {
            System.out.println("Gick inte ta ut pengar. För lite saldo för vald summa");
        }

    }
}
