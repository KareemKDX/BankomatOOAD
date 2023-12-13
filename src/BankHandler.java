import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BankHandler implements BankManagerInterface {


    public double getBalanceSavingsAccount() {
        return balanceSavingsAccount;
    }

    public void setBalanceSavingsAccount(double balanceSavingsAccount) {




    }

    private double balanceSavingsAccount;
    private double balance;
    private Customer accountHolder;
    private static Map<Customer, BankHandler> instances = new HashMap<>();
    private BankHandler(Customer accountHolder) {
        this.accountHolder = accountHolder;
    }
    public static BankHandler getInstance(Customer accountHolder) {
        return instances.computeIfAbsent(accountHolder, BankHandler::new);
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
                System.out.println("Uttag: " + amount + " . Nytt värde konto: " + balance);
            } else {
                System.out.println("Gick inte ta ut pengar. För lite saldo för vald summa");
            }
        }

    @Override
    public void depositSaving(double amount) {
        System.out.println("SPARKONTO");
        if (amount > 0 ) {
            balanceSavingsAccount += amount;
            System.out.println("Insättning: " + amount + " . Nytt värde konto: " + balanceSavingsAccount);
        } else {
            System.out.println("Gick inte ta ut pengar. För lite saldo för vald summa");
        }
    }

    @Override
    public void withdrawSaving(double amount) {
        System.out.println("SPARKONTO");
        if (amount > 0 && amount <= balanceSavingsAccount) {
            balanceSavingsAccount -= amount;
            System.out.println("Uttag: " + amount + " . Nytt värde konto: " + balanceSavingsAccount);
        } else {
            System.out.println("Gick inte ta ut pengar. För lite saldo för vald summa");
        }

    }

    public void userStartMenu() {

        System.out.println("Välkommen till Banken: Nuvarande saldo: " + getBalance());


        Scanner scanner = new Scanner(System.in);
        System.out.println("Vad vill du göra? \n 1. Insättning \n 2. Uttag \n 3. Se Sparkonto \n 4. Se räntekonto \n 5. Ta lån \n 6. Ansökan bankomatkort \n 7. Kontohistorik"
           + "  \n 8. Kundsupport" );

        int userChoiche = scanner.nextInt();

        if (userChoiche == 1)
            {
                System.out.println("Hur mycket vill du sätta in?");
                double userDepositSum = scanner.nextDouble();
                deposit(userDepositSum);

                goBackToStartMenu();


            }
         else if  (userChoiche == 2)
        {
            System.out.println("Hur mycket vill du ta ut?");
            double userWithdrawSum = scanner.nextDouble();
            withdraw(userWithdrawSum);
        }
        else if (userChoiche == 3)
        {
            System.out.println("Aktuellt saldo Sparkonto: ");
            System.out.println("Vad vill du göra? 1. Ta ut från konto 2. Överför till konto");
            int user1 = scanner.nextInt();
            if(user1 == 2) {

                System.out.println("Ange summa att överföra: ");
                double userSum = scanner.nextDouble();
                depositSaving(userSum);
                goBackToStartMenu();


            }

            if (user1 == 1) {
                System.out.println("Ange summa att ta ut: ");
                double userAmountWithdraw = scanner.nextDouble();
                withdrawSaving(userAmountWithdraw);
                goBackToStartMenu();
            }

        }




    }

    public void goBackToStartMenu() {
       Scanner scanner = new Scanner(System.in);
        System.out.println("Vill du gå tillbaka till start-menyn? 1. JA 2. NEJ");
        int user = scanner.nextInt();

        if(user == 1) {
            userStartMenu();
        }
        else {
            System.out.println("Tack och välkommen åter");
            System.exit(0);
        }
    }
}



