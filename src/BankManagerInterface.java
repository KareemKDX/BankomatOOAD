public interface BankManagerInterface {

    void createAccount(String accountHolder, double initialBalance);


       void deposit(String accountName, double amount);


        void withdraw(String accountName, double amount);


        double getBalance(String accountName);


        void transfer(String fromAccountName, String toAccountName, double amount);




}
