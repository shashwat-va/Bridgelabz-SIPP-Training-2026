import java.util.Scanner;

public class PowerCalculatorWhileLoop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int power = scanner.nextInt();

        if (number <= 0 || power < 0) {
            System.out.println("Please enter positive integers for number and power.");
            scanner.close();
            return;
        }

        long result = 1;
        int counter = 0;
        while (counter < power) {
            result *= number;
            counter++;
        }

        System.out.println(result);
        scanner.close();
    }
}
