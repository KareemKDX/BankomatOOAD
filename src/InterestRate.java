public class InterestRate {
   private double BASE_LOAN_RATE = 3.25;
   private double BASE_SAVINGS_RATE = 2.50;

    public void showInterestRateSavings(){
        System.out.println("Våran sparkonto-ränta är just nu " + BASE_SAVINGS_RATE + "%.");
    }
    public void showInterestRateLoan(int howManyYearsAsCustomer, double loanAmount){
        double fiveYears = 0.2;
        double tenYears = 0.5;
        double twentyYears = 1;

        if (howManyYearsAsCustomer > 20) {
            double twentyYearsPlusDiscount = BASE_LOAN_RATE - twentyYears;
            System.out.println("Du har varit kund hos oss i över 20 år, du får " + twentyYears + "% rabatt på räntan. Räntan med rabatt är "
                    + twentyYearsPlusDiscount + "%, räntekostnaden per år ligger på " + loanAmount * twentyYearsPlusDiscount / 100 + " kr.");
        } else if (howManyYearsAsCustomer > 10) {
            double tenYearDiscount = BASE_LOAN_RATE - tenYears;
            System.out.println("Du har varit kund hos oss i över 10 år, du får " + tenYears + "% rabatt på räntan. Räntan med rabatt är "
                    + tenYearDiscount + "%, räntekostnaden per år ligger på " + loanAmount * tenYearDiscount / 100 + " kr.");
        }     else if (howManyYearsAsCustomer > 5) {
            double fiveYearDiscount = BASE_LOAN_RATE - fiveYears;
            System.out.println("Du har varit kund hos oss i över 5 år, du får " + fiveYears + "% rabatt på räntan. Räntan med rabatt är "
                    + fiveYearDiscount + "%, räntekostnaden per år ligger på " + loanAmount * fiveYearDiscount / 100 + " kr.");
        } else {
            System.out.println("'s Nuvarande ränta:" + BASE_LOAN_RATE + ", räntekostnaden på år ligger på" + loanAmount * BASE_LOAN_RATE / 100 + " kr");
        }

    }

}
