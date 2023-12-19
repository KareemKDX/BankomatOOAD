import javax.swing.*;
import java.io.IOException;

public class BankHandler {
   StandardAccount standardAccount = new StandardAccount();
   SavingsAccount savingsAccount = new SavingsAccount();
   Loan loan;
   Calculator randomNumber = new Calculator();
   String inputErrorMessage =  "Felaktig inmatning, försök igen";

    public void depositMoney() {

    try{
        String userInput = JOptionPane.showInputDialog("Hur mycket vill du sätta in?");
        if (userInput != null) {
            double userDepositSum = Double.parseDouble(userInput);
            standardAccount.deposit(userDepositSum);
        }

    }catch (NumberFormatException e) {
        System.out.println(inputErrorMessage);
        JOptionPane.showMessageDialog(null,inputErrorMessage);
    }

    }

    public void withdrawMoney() {
        try {
            String userInput = JOptionPane.showInputDialog("Hur mycket vill du ta ut?");
            if (userInput != null) {
                double userWithdrawSum = Double.parseDouble(userInput);
                standardAccount.withdraw(userWithdrawSum);
            }
        } catch (NumberFormatException e) {
            System.out.println(inputErrorMessage);
            JOptionPane.showMessageDialog(null,inputErrorMessage);

        }
    }

    public void manageSavings() {

        String[] options = {"Överför till konto", "Ta ut från konto", "Aktuell ränta", "Nytt sparkonto"};
        int userChoice = JOptionPane.showOptionDialog(null, "Vad vill du göra?", "Sparkonto",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

     try{
        if (userChoice == 0) {
            double userSum = Double.parseDouble(JOptionPane.showInputDialog("Ange summa att överföra: "));
            savingsAccount.deposit(userSum);

        } else if (userChoice == 1) {
            double userAmountWithdraw = Double.parseDouble(JOptionPane.showInputDialog("Ange summa att ta ut: "));
            savingsAccount.withdraw(userAmountWithdraw);

        }else if (userChoice == 2){
            savingsAccount.interest.showInterestRateSavings();
        }else {
            Long savingsAccountnumber = randomNumber.generateRandomNumber();

            Object[] optionsSavings = {"JA", "NEJ"};
            int userChoiceSavings = JOptionPane.showOptionDialog(null, "Skapa ett nytt sparkonto?", "Sparkonto",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, optionsSavings, options[1]);

            if (userChoiceSavings == 0) {
                System.out.println("Ditt nya sparkonto-nummer är: " + savingsAccountnumber);
            }
        }
    }catch (NumberFormatException e) {
         System.out.println("Felaktig inmatning");

         JOptionPane.showMessageDialog(null, "Felaktig inmatning");
     }
     }
    public void creditCardMenu() {
        Long creditCardNumber = randomNumber.generateRandomNumber();

        Object[] options = {"JA", "NEJ"};
        int userChoice = JOptionPane.showOptionDialog(null, "Skapa ett kreditkort?", "Kreditkort",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[1]);

        if (userChoice == 0) {
            System.out.println("Ditt kortnummer är " + creditCardNumber);
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

