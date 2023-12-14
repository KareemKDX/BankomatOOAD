public class Loan {
    private final int loanAmount;
    InterestRate interestRate = new InterestRate();
    public Loan(int loanAmount){
        this.loanAmount = loanAmount;
    }
    public void takeANewLoan(){
        System.out.println("Du har tagit ett lån på: " + loanAmount + " kr.");
    }
    public int getLoanAmount() {
        return loanAmount;
    }
}
