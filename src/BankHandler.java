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

        String[] options = {"Ta ut från konto", "Överför till konto"};
        int userChoice = JOptionPane.showOptionDialog(null, "Vad vill du göra?", "Aktuellt saldo Sparkonto",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        if (userChoice == 1) {
            double userSum = Double.parseDouble(JOptionPane.showInputDialog("Ange summa att överföra: "));
            savingsAccount.deposit(userSum);

        } else if (userChoice == 0) {
            double userAmountWithdraw = Double.parseDouble(JOptionPane.showInputDialog("Ange summa att ta ut: "));
            savingsAccount.deposit(userAmountWithdraw);

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
        history.printTransactionHistory();
            }
    }
