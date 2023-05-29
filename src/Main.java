import java.text.NumberFormat;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        final byte PERCENT = 100;
        final byte MONTHS_IN_YEAR = 12;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Principal: ");
        int principal = scanner.nextInt();

        System.out.print("Annual Interest Rate: ");
        double interest_rate = scanner.nextDouble();
        double interest_rate_percent = interest_rate / PERCENT;
        double annual_interest_rate = interest_rate_percent / MONTHS_IN_YEAR;

        System.out.print("Period(Years): ");
        int period = scanner.nextShort();
        int year_period = period * MONTHS_IN_YEAR;

        double mortgage_calculator = principal * (annual_interest_rate * Math.pow(1 + annual_interest_rate , year_period)) / (Math.pow(1 + annual_interest_rate , year_period) - 1);
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String result = currency.format(mortgage_calculator);
        System.out.println(result);
    }
}