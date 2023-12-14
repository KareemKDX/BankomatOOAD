import javax.swing.*;
import java.util.Scanner;

public class ATM {

    public static void main(String[] args) {

        Customer customer1 = new Customer("Jakob Armandsson", true);
        Customer customer2 = new Customer("Robin Halvardsson", false);
        Customer customer3 = new Customer("Josefine Ullevi", true);

        BankHandler handler1 = BankHandler.getInstance(customer1);
        BankHandler handler2 = BankHandler.getInstance(customer2);
        BankHandler handler3 = BankHandler.getInstance(customer3);


        handler1.userStartMenu();










    }
}



