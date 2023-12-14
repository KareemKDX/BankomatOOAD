import javax.swing.*;
import java.util.Scanner;

public class ATM {

    public static void main(String[] args) {

        String name = JOptionPane.showInputDialog(null, "Ange ditt namn:", "Bankomaten", JOptionPane.PLAIN_MESSAGE);

        if (name != null && !name.isEmpty()) {
            SwingUtilities.invokeLater(() -> {
                Customer customer = new Customer(name);
                BankHandler bankHandler = new BankHandler(customer);
                BankGUI gui = BankGUI.getInstance(bankHandler, customer);
            });
        } else {
           JOptionPane.showMessageDialog(null,"Du måste skriva in ditt namn!");
        }

    }
}



