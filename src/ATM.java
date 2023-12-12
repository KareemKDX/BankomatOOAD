import javax.swing.*;
import java.util.Scanner;

public class ATM {

    public static void main(String[] args) {

        Customer customer1 = new Customer("Jakob Armandsson");
        Customer customer2 = new Customer("Robin Halvardsson");
        Customer customer3 = new Customer("Josefine Ullevi");

        BankHandler handler1 = new BankHandler(customer1);
        BankHandler handler2 = new BankHandler(customer2);
        BankHandler handler3= new BankHandler(customer3);




    }
}



