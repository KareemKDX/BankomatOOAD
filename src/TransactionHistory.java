import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionHistory {
    private final List<String> TransactionList;

    public TransactionHistory() {
        this.TransactionList = new ArrayList<>();
    }

    public void addTransaction(String type, double amount) {
        Date time = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm dd MMM");
        String transaction = type + ": " + amount + "kr" + " Klockan: " + dateFormat.format(time);
        TransactionList.add(transaction);

    }
    public void printTransactionHistory() {
        System.out.println("Transaktionshistorik:");
        for (String transaction : TransactionList) {
            System.out.println(transaction);
        }
    }
}



