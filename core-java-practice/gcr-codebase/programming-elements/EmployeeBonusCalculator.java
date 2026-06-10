import java.util.Scanner;

public class EmployeeBonusCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double salary = scanner.nextDouble();
        int yearsOfService = scanner.nextInt();

        if (salary < 0 || yearsOfService < 0) {
            System.out.println("Please enter non-negative salary and years of service.");
            scanner.close();
            return;
        }

        if (yearsOfService > 5) {
            double bonus = salary * 0.05;
            System.out.println("Bonus amount: " + bonus);
        } else {
            System.out.println("No bonus awarded.");
        }

        scanner.close();
    }
}
