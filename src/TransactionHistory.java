import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionHistory {

    private final List<Transaction> TransactionList;

    public TransactionHistory() {
        this.TransactionList = new ArrayList<>();
    }

    public void addTransaction(String type, double amount) {
        TransactionList.add(new Transaction(type, amount));
    }

    public void printTransactionHistory() {
        System.out.println("Transaktionshistorik:");
        for (Transaction transaction : TransactionList) {
            System.out.println(transaction);
        }
    }


    private static class Transaction {
        private String type;
        private double amount;
        Date time;

        public Transaction(String type, double amount) {
            this.type = type;
            this.amount = amount;
            this.time = new Date();
        }
        @Override
        public String toString() {
            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm dd MMM");
            return  type + ": " + amount +"kr"  + " Klockan: " + dateFormat.format(time);
        }

    }

}

