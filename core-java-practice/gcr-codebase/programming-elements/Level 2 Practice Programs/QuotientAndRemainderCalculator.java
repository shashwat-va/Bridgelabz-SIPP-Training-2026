import java.util.Scanner;

public class QuotientAndRemainderCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dividend = scanner.nextInt();
        int divisor = scanner.nextInt();

        int quotient = dividend / divisor;
        int remainder = dividend % divisor;

        System.out.println("The quotient is "
                + quotient + " and remainder is "
                + remainder + " for the numbers "
                + dividend + " and " + divisor);

        scanner.close();
    }
}
