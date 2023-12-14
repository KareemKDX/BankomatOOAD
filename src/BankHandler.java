import java.util.*;

public class BankHandler implements BankManagerInterface {


    private double balanceSavingsAccount;
    private double balance;
    private Customer accountHolder;
    TransactionHistory history = new TransactionHistory();
    private static Map<Customer, BankHandler> instances = new HashMap<>();
    Customer c;

    private BankHandler(Customer accountHolder) {
        this.accountHolder = accountHolder;
    }

    public static BankHandler getInstance(Customer accountHolder) {
        return instances.computeIfAbsent(accountHolder, BankHandler::new);
    }

    public double getBalance() {
        return balance;
    }

    public double getBalanceSavingsAccount() {
        return balanceSavingsAccount;
    }

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

    @Override
    public void depositSaving(double amount) {
        System.out.println("SPARKONTO");
        if (amount > 0) {
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

        System.out.println("Välkommen "  +  "till Banken: Nuvarande saldo: " + getBalance());

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Vad vill du göra? \n 1. Insättning \n 2. Uttag \n 3. Se Sparkonto \n 4. Se räntekonto \n 5. Ta lån \n 6. Ansökan bankomatkort \n 7. Kontohistorik"
                    + "  \n 8. Kundsupport");

            int userChoice = scanner.nextInt();

            switch (userChoice) {
                case 1 -> depositMoney();
                case 2 -> withdrawMoney();
                case 3 -> manageSavings();
                case 6 -> creditCardMenu();
                case 7 -> showTransactionHistory();
                // Add other cases as needed

                default -> System.out.println("Ogiltigt val. Försök igen.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Felaktig inmatning. Var god ange en siffra.");
        }
    }

    private void depositMoney() {
        System.out.println("Hur mycket vill du sätta in?");
        double userDepositSum = new Scanner(System.in).nextDouble();
        deposit(userDepositSum);
        goBackToStartMenu();
    }

    private void withdrawMoney() {
        System.out.println("Hur mycket vill du ta ut?");
        double userWithdrawSum = new Scanner(System.in).nextDouble();
        withdraw(userWithdrawSum);
        goBackToStartMenu();
    }

    private void manageSavings() {
        System.out.println("Aktuellt saldo Sparkonto: ");
        System.out.println("Vad vill du göra? 1. Ta ut från konto 2. Överför till konto");
        int userChoice = new Scanner(System.in).nextInt();

        if (userChoice == 2) {
            System.out.println("Ange summa att överföra: ");
            double userSum = new Scanner(System.in).nextDouble();
            depositSaving(userSum);
            goBackToStartMenu();
        } else if (userChoice == 1) {
            System.out.println("Ange summa att ta ut: ");
            double userAmountWithdraw = new Scanner(System.in).nextDouble();
            withdrawSaving(userAmountWithdraw);
            goBackToStartMenu();
        } else {
            System.out.println("Ogiltigt val. Var god ange antingen 1 eller 2.");
        }
    }
    public void creditCardMenu() {
      Calculator randomNumber = new Calculator();
      Long number = randomNumber.generateRandomCreditCardNumber();

      System.out.println("Skapa ett kreditkort 1. JA 2. NEJ");
      int userSum =  new Scanner(System.in).nextInt();
       if(userSum == 1) {
           System.out.println("Ditt kortnummer är " + number);
           goBackToStartMenu();
       }


    }


    public void showTransactionHistory() {
        history.printTransactionHistory();
        goBackToStartMenu();
    }


    //Metod för att kalla på startmenyn inom if-satserna.
    public void goBackToStartMenu() {
       Scanner scanner = new Scanner(System.in);
        System.out.println();
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



