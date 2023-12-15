import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankGUI extends JFrame implements ActionListener{
    private JPanel panel = new JPanel();
    private JLabel label = new JLabel("Välkommen");
    private JComboBox<String> comboBox = new JComboBox<>(new String[]{"1. Insättning", "2. Uttag", "3. Sparkonto", "4. Lån", "5. Ansök om bankomatkort", "6. Kontohistorik", "7. Kundsupport"});
    private JButton button = new JButton("Utför åtgärd");
    private final BankHandler bankHandler;
    private final Customer customer;
    //volatile instance så att andra trådar måste vänta tills
    // den första tråden är färdig med skapandet av instansen.
    private static volatile BankGUI instance;

    private BankGUI(BankHandler bankHandler, Customer customer) {
        this.bankHandler = bankHandler;
        this.customer = customer;

        this.setTitle("Bankomaten");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(280, 200);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.add(panel);

        label.setText("Välkommen " + this.customer.getName());
        panel.add(label);
        panel.add(comboBox);
        panel.add(button);


        button.addActionListener(this);
    }
    public static BankGUI getInstance(BankHandler bankHandler, Customer accountHolder) {
        //Double-Checked Locking, hoppar över synk när man hämtar en instans som redan är skapad(effektivare program)
        if (instance == null) {
            synchronized (BankGUI.class) {
                if (instance == null) {
                    instance = new BankGUI(bankHandler, accountHolder);
                }
            }
        }
        return instance;
    }

    private void handleUserChoice(String selectedOption) {
        switch (selectedOption) {
            case "1. Insättning":
                bankHandler.depositMoney();
                break;
            case "2. Uttag":
               bankHandler.withdrawMoney();
                break;
            case "3. Sparkonto":
                bankHandler.manageSavings();
                break;
            case "4. Lån":
                bankHandler.manageLoan();
                break;
            case  "5. Ansök om bankomatkort":
                bankHandler.creditCardMenu();
                break;
            case  "6. Kontohistorik":
                bankHandler.showTransactionHistory();
                break;
            case  "7. Kundsupport":
                bankHandler.showContactInfo();
                default:
                break;
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String selectedOption = (String) comboBox.getSelectedItem();
        handleUserChoice(selectedOption);
    }
}
