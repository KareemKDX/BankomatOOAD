import javax.swing.*;
import java.util.Scanner;

public class ATM {

    public static void main(String[] args) {

        Customer customer1 = new Customer("Jakob Armandsson");
        Customer customer2 = new Customer("Robin Halvardsson");
        Customer customer3 = new Customer("Josefine Ullevi");

        BankHandler handler1 = BankHandler.getInstance(customer1);
        BankHandler handler2 = BankHandler.getInstance(customer2);
        BankHandler handler3 = BankHandler.getInstance(customer3);

        handler1.userStartMenu();




    }
}



