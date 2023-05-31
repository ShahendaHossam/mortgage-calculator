import java.text.NumberFormat;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        final byte PERCENT = 100;
        final byte MONTHS_IN_YEAR = 12;

        double annual_interest_rate = 0;
        Scanner scanner = new Scanner(System.in);

        //first print in the project
        System.out.print("Principal: ");
        int principal = scanner.nextInt();
        //if the condition in the while loop is false a msg for entering a proper value will be displayed over and over until the user enter the correct value
        //if the condition is true in the if condition it will break the code and will not display its value in the terminal but will store it
        while(!(principal >= 1_000 && principal <= 1_000_000)){
            System.out.println("Enter a number between 1,000 and 1,000,000 ");
            System.out.print("Principal: ");
             principal = scanner.nextInt();
            if(principal >= 1_000 && principal <= 1_000_000){
                break;
            }
        }
        System.out.print("Annual Interest Rate: ");
        double interest_rate = scanner.nextDouble();
        while(!(interest_rate > 0 && interest_rate <= 30)){
            System.out.println("Enter a value greater than 0 and less than or equal 30 ");
            System.out.print("Annual Interest Rate: ");
            interest_rate = scanner.nextDouble();
            if(interest_rate > 0 && interest_rate <= 30){
                double interest_rate_percent = interest_rate / PERCENT;
                annual_interest_rate = interest_rate_percent / MONTHS_IN_YEAR;
                break;
            }
        }
        System.out.print("Period(Years): ");
        int period = scanner.nextShort();
        while(!(period >= 1 && period <= 30)){
            System.out.println("Enter a value between 1 and 30");
            System.out.print("Period(Years): ");
            period = scanner.nextShort();
            if(period >= 1 && period <= 30){
                int year_period = period * MONTHS_IN_YEAR;

                double mortgage_calculator = principal * (annual_interest_rate * Math.pow(1 + annual_interest_rate , year_period)) / (Math.pow(1 + annual_interest_rate , year_period) - 1);
                NumberFormat currency = NumberFormat.getCurrencyInstance();
                String result = currency.format(mortgage_calculator);
                System.out.println(result);
            }
        }




        //another solution:-

    }
}