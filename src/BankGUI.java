import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankGUI extends JFrame implements ActionListener{
    JPanel panel = new JPanel();
    JLabel label = new JLabel("Välkommen");
    JComboBox<String> comboBox = new JComboBox<>(new String[]{"1. Insättning", "2. Uttag", "3. Se Sparkonto", "4. Se räntekonto", "5. Ta lån", "6. Ansökan bankomatkort", "7. Kontohistorik", "8. Kundsupport"});
    JButton button = new JButton("Utför åtgärd");
    private final BankHandler bankHandler;
    private final Customer customer;

    public BankGUI(BankHandler bankHandler, Customer customer) {
        this.bankHandler = bankHandler;
        this.customer = customer;

        this.setTitle("Bankomaten");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(280, 200);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.add(panel);

        label.setText("Välkommen " + customer.getName());
        panel.add(label);
        panel.add(comboBox);
        panel.add(button);


        button.addActionListener(this);
    }

    private void handleUserChoice(String selectedOption) {
        switch (selectedOption) {
            case "1. Insättning":
                bankHandler.userStartMenu(1);
                break;
            case "2. Uttag":
               bankHandler.userStartMenu(2);
                break;
            case "3. Se Sparkonto":
                bankHandler.userStartMenu(3);

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
