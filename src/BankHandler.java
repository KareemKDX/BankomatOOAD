import java.util.Scanner;

public class BankHandler implements BankManagerInterface {


    private double balance;
    private Customer accountHolder;

    public BankHandler(Customer accountHolder) {
        this.accountHolder = accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Insättning: " + amount + "Nytt värde konto" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Uttag: " + amount + ". Nytt värde konto: " + balance);
        } else {
            System.out.println("Gick inte ta ut pengar. För lite saldo för vald summa");
        }
    }

    public void userStartMenu() {

        System.out.println("Välkommen till Banken: Nuvarande saldo: " + getBalance());


        Scanner scanner = new Scanner(System.in);
        System.out.println("Vad vill du göra? 1. Insättning 2. Uttag 3. Se Sparkonto");
        int userChoiche = scanner.nextInt();

        if (userChoiche == 1) ;
        {
            System.out.println("Hur mycket vill du sätta in?");
            double userDepositSum = scanner.nextDouble();
            deposit(userDepositSum);
        }
        if (userChoiche == 2) ;
        {
            System.out.println("Hur mycket vill du ta ut?");
            double userWithdrawSum = scanner.nextDouble();
            withdraw(userWithdrawSum);
        }
        if (userChoiche == 3) ;
        {
            System.out.println("Aktuellt saldo Sparkonto: ");
            System.out.println("Vad vill du göra? 1. Ta ut från konto 2. Överför till konto");
            double userWithdrawSum = scanner.nextDouble();
            withdraw(userWithdrawSum);


        }
    }
}



