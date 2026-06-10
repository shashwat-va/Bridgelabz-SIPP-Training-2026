import java.util.Scanner;

public class PowerCalculatorForLoop {
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
        for (int i = 1; i <= power; i++) {
            result *= number;
        }

        System.out.println(result);
        scanner.close();
    }
}
