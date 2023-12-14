import javax.swing.*;
import java.util.*;

public class BankHandler {
    private double balanceSavingsAccount;
    private double balance;
    private Customer accountHolder;
    TransactionHistory history = new TransactionHistory();
    Customer c;
    StandardAccount standardAccount = new StandardAccount();
    SavingsAccount savingsAccount = new SavingsAccount();
    Loan loan;


    public BankHandler(Customer accountHolder) {
        this.accountHolder = accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public double getBalanceSavingsAccount() {
        return balanceSavingsAccount;
    }

   /* @Override
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

    /*@Override
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

   */

    public void depositMoney() {

        String userInput = JOptionPane.showInputDialog("Hur mycket vill du sätta in?");
        if (userInput != null) {
            double userDepositSum = Double.parseDouble(userInput);
            standardAccount.deposit(userDepositSum);
        }
    }

    public void withdrawMoney() {
        String userInput = JOptionPane.showInputDialog("Hur mycket vill du ta ut?");
        if (userInput != null) {
            double userWithdrawSum = Double.parseDouble(userInput);
            standardAccount.deposit(userWithdrawSum);
        }
    }

    public void manageSavings() {

        String[] options = {"Ta ut från konto", "Överför till konto", "Aktuell ränta"};
        int userChoice = JOptionPane.showOptionDialog(null, "Vad vill du göra?", "Sparkonto",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        if (userChoice == 1) {
            double userSum = Double.parseDouble(JOptionPane.showInputDialog("Ange summa att överföra: "));
            savingsAccount.deposit(userSum);

        } else if (userChoice == 0) {
            double userAmountWithdraw = Double.parseDouble(JOptionPane.showInputDialog("Ange summa att ta ut: "));
            savingsAccount.deposit(userAmountWithdraw);

        }else {
            savingsAccount.interest.showInterestRateSavings();
        }
    }
    public void creditCardMenu() {
        Calculator randomNumber = new Calculator();
        Long number = randomNumber.generateRandomCreditCardNumber();

        Object[] options = {"JA", "NEJ"};
        int userChoice = JOptionPane.showOptionDialog(null, "Skapa ett kreditkort?", "Kreditkort",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[1]);

        if (userChoice == 0) {
            System.out.println("Ditt kortnummer är " + number);
        }
    }
    public void showTransactionHistory() {
        String[] options = {"Lönekonto", "Sparkonto"};
        int userChoice = JOptionPane.showOptionDialog(null, "Vilket konto vill du kolla historiken på?", "Transaktionshistorik",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        if (userChoice == 0) {
            if (standardAccount.getBalance() != 0) {
                standardAccount.history.printTransactionHistory();
            } else {
                System.out.println("Du har inte gjort några transaktioner ännu");
            }
        } else if (userChoice == 1) {
            if (savingsAccount.getBalanceSavingsAccount() != 0) {
                savingsAccount.history.printTransactionHistory();
            } else {
                System.out.println("Du har inte gjort några transaktioner ännu");
            }
        }
    }
    public void showContactInfo(){
        System.out.println("Om du har problem med bankomaten kan du kontakta oss på följande sätt:\nTel: 08-56144063\nEmail: bankingwizard@cashville.se\n" +
                "Eller så besöker du vårat fysiska kontor på adressen:\nPengavägen 12, 15562 Kronorborg");
    }
    public void manageLoan(){
        String[] options = {"Ta ett nytt lån", "Aktuell ränta för ditt lån"};
        int userChoice = JOptionPane.showOptionDialog(null, "Vad vill du göra?", "Lån",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        if (userChoice == 0) {
            int loanAmount = Integer.parseInt(JOptionPane.showInputDialog("Hur mycket vill du låna?"));
            loan = new Loan(loanAmount);
            loan.takeANewLoan();
        } else if (userChoice == 1) {
            if (loan != null) {
                int howManyYearsCustomer = Integer.parseInt(JOptionPane.showInputDialog("Hur många år har du varit kund?"));
                int loanAmount = loan.getLoanAmount();
                loan.interestRate.showInterestRateLoan(howManyYearsCustomer, loanAmount);
            } else {
                System.out.println("Du har inte tagit något lån ännu.");
            }
        }

    }
    }

