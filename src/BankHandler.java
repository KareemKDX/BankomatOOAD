import javax.swing.*;
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
    private static BankHandler instance;
    private BankHandler(Customer accountHolder) {
        this.accountHolder = accountHolder;
    }

    public static BankHandler getInstance(Customer accountHolder) {
        if (instance == null) {
            instance = new BankHandler(accountHolder);
        }
        return instance;
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

    public void userStartMenu(int selectedOption) {
        if (selectedOption == 1) {
            String userInput = JOptionPane.showInputDialog("Hur mycket vill du sätta in?");
            if (userInput != null) {
                double userDepositSum = Double.parseDouble(userInput);
                deposit(userDepositSum);
            }
        } else if (selectedOption == 2) {
            String userInput = JOptionPane.showInputDialog("Hur mycket vill du ta ut?");
            if (userInput != null) {
                double userWithdrawSum = Double.parseDouble(userInput);
                withdraw(userWithdrawSum);
            }
        } else if (selectedOption == 3) {
            int user1 = JOptionPane.showOptionDialog(null, "Aktuellt saldo Sparkonto:", "Select an option",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"1. Ta ut från konto", "2. Överför till konto"}, null);

            if (user1 == JOptionPane.YES_OPTION) {
                String userInput = JOptionPane.showInputDialog("Ange summa att ta ut:");
                if (userInput != null) {
                    double userAmountWithdraw = Double.parseDouble(userInput);
                    withdrawSaving(userAmountWithdraw);

                }
            } else if (user1 == JOptionPane.NO_OPTION) {
                String userInput = JOptionPane.showInputDialog("Ange summa att överföra:");
                if (userInput != null) {
                    double userSum = Double.parseDouble(userInput);
                    depositSaving(userSum);

                }
            }
        }




    }

    public void goBackToStartMenu() {
        int user = JOptionPane.showOptionDialog(null, "Vill du gå tillbaka till start-menyn?", "Välj alternativ",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

        if (user == JOptionPane.YES_OPTION) {
            new BankGUI(instance, accountHolder);
        } else {
            System.out.println("Tack och välkommen åter");
            System.exit(0);
        }
    }
}



