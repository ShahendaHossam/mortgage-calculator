import java.text.NumberFormat;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    //we should but static keyword because all methods in this class are static  and they can only access static variables
    final static byte PERCENT = 100;  //field is a variable thst we defined at a class and it is accessible to all methods in that class
    final static byte MONTHS_IN_YEAR = 12;  //field

    public static void main(String[] args) {
        int principal;
        float annualInterest;
        byte years;
        // Scanner scanner = new Scanner(System.in);

        // first print in the project

        // System.out.print("Principal: ");
        // int principal = scanner.nextInt();

        // //if the condition in the while loop is false a msg for entering a proper
        // value will be displayed over and over until the user enter the correct value
        // //if the condition is true in the if condition it will break the code and
        // will not display its value in the terminal but will store it
        // while(!(principal >= 1_000 && principal <= 1_000_000)){
        // System.out.println("Enter a number between 1,000 and 1,000,000 ");
        // System.out.print("Principal: ");
        // principal = scanner.nextInt();
        // if(principal >= 1_000 && principal <= 1_000_000){
        // break;
        // }
        // }
        // System.out.print("Annual Interest Rate: ");
        // double interest_rate = scanner.nextDouble();
        // while(!(interest_rate > 0 && interest_rate <= 30)){
        // System.out.println("Enter a value greater than 0 and less than or equal 30
        // ");
        // System.out.print("Annual Interest Rate: ");
        // interest_rate = scanner.nextDouble();
        // if(interest_rate > 0 && interest_rate <= 30){
        // double interest_rate_percent = interest_rate / PERCENT;
        // annual_interest_rate = interest_rate_percent / MONTHS_IN_YEAR;
        // break;
        // }
        // }
        // System.out.print("Period(Years): ");
        // int period = scanner.nextShort();
        // while(!(period >= 1 && period <= 30)){
        // System.out.println("Enter a value between 1 and 30");
        // System.out.print("Period(Years): ");
        // period = scanner.nextShort();
        // if(period >= 1 && period <= 30){
        // int year_period = period * MONTHS_IN_YEAR;
        //
        // double mortgage_calculator = principal * (annual_interest_rate * Math.pow(1 +
        // annual_interest_rate , year_period)) / (Math.pow(1 + annual_interest_rate ,
        // year_period) - 1);
        // NumberFormat currency = NumberFormat.getCurrencyInstance();
        // String result = currency.format(mortgage_calculator);
        // System.out.println(result);
        // }
        // }

        // another solution:-
        // this solution is the right one because in the above code will make all the
        // cases right except one case which is the user enters all the condition right
        // from the first time
        // but the above solution first the user must enter the wrong value and then the
        // correct value to print the value and this is not correct
        // he must in the while loop the condition be true.
        // while (true) {
        // System.out.print("Principal: ");
        // principal = scanner.nextInt();
        // if (principal >= 1_000 && principal <= 1_000_000) {
        // break;
        // }
        // System.out.println("Enter a number between 1,000 and 1,000,000 ");
        // }

        // while (true) {
        // System.out.print("Annual Interest Rate: ");
        // interest_rate = scanner.nextDouble();
        // if (interest_rate > 0 && interest_rate <= 30) {
        // double interest_rate_percent = interest_rate / PERCENT;
        // annual_interest_rate = interest_rate_percent / MONTHS_IN_YEAR;
        // break;
        // }
        // System.out.println("Enter a value greater than 0 and less than or equal 30
        // ");

        // }

        // while (true) {
        // System.out.print("Period(Years): ");
        // period = scanner.nextShort();
        // if (period >= 1 && period <= 30) {
        // int year_period = period * MONTHS_IN_YEAR;

        // double mortgage_calculator = principal
        // * (annual_interest_rate * Math.pow(1 + annual_interest_rate, year_period))
        // / (Math.pow(1 + annual_interest_rate, year_period) - 1);
        // NumberFormat currency = NumberFormat.getCurrencyInstance();
        // String result = currency.format(mortgage_calculator);
        // System.out.println(result);
        // break;
        // }
        // System.out.println("Enter a value between 1 and 30");

        // }

        principal = (int) readNumber("Principal: ", 1_000, 1_000_000);
        annualInterest = (float) readNumber("Annual Interest Rate: ", 1, 30);
        years = (byte) readNumber("Period(Years): ", 1, 30);

        double mortgage_calculator = calculateMortgage(principal, annualInterest, years);



        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String result = currency.format(mortgage_calculator);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly Payments: " + result);

        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("-----------------");
        //to iterate over all the payments and after each payment
        for(short month = 1; month <= years * MONTHS_IN_YEAR; month++ ){
            double balance = calculatePaymentSchedule(principal, annualInterest, years, month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance)); 

        }

    }

    public static double readNumber(String prompt, double min, double max) {
        Scanner scanner = new Scanner(System.in);
        double value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextFloat();
            if (value >= min && value <= max) {
                break;
            }
            System.out.println("Enter a value greater than " + min + "and " + max);
        }
        return value;
    }

    // Extracting Methods
    // create methods instead of coding all in the main function
    public static double calculateMortgage(
            int principal,
            float annualInterest,
            byte years) {

        float annual_interest_rate = annualInterest / PERCENT / MONTHS_IN_YEAR;
        float numberOfPayments = years * MONTHS_IN_YEAR;

        double mortgage_calculator = principal
                * (annual_interest_rate * Math.pow(1 + annual_interest_rate, numberOfPayments))
                / (Math.pow(1 + annual_interest_rate, numberOfPayments) - 1);

        return mortgage_calculator;
    }

    public static double calculatePaymentSchedule(
            int principal,
            float annualInterest,
            byte years,
            double totalMonthlyPayment) {


        float annual_interest_rate = annualInterest / PERCENT / MONTHS_IN_YEAR;
        float numberOfPayments = years * MONTHS_IN_YEAR;

        // Main obj = new Main();
        double payment_schedule = principal * (Math.pow(1 + annual_interest_rate, numberOfPayments)
                - Math.pow(1 + annual_interest_rate, totalMonthlyPayment))
                / (Math.pow(1 + annual_interest_rate, numberOfPayments) - 1);

        return payment_schedule;
    }

}