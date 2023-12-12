import javax.swing.*;
import java.util.Scanner;

public class ATM {

    public static void main(String[] args) {

       BankHandler bankHandler = new BankHandler();

        Customer customer1 = new Customer();

        Scanner scan = new Scanner(System.in);

        System.out.println("Vänligen skriv in ditt namn");

        String customerName = scan.nextLine();

        BankHandler bank = new BankHandler();
        //bank.createAccount();

        customer1.setName(customerName);

        System.out.println("Vad vill du göra? UTTAG/INSÄTTNING/");
        String customerChoice = scan.nextLine();

        if (customerChoice.equalsIgnoreCase("UTTAG")) {
            System.out.println("Hur mycket vill du ta ut?");

            int customerDepositAmount = scan.nextInt();


        }






    }}

