import java.util.Scanner;

public class EmployeeBonuses10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] salaries = new double[10];
        double[] years = new double[10];
        double[] bonuses = new double[10];
        double[] newSalaries = new double[10];

        for (int i = 0; i < 10; i++) {
            System.out.println("Enter salary and years of service for employee " + (i + 1) + ":");
            double salary = scanner.nextDouble();
            double service = scanner.nextDouble();

            if (salary <= 0 || service < 0) {
                System.out.println("Invalid salary or years of service. Enter again.");
                i--;
                continue;
            }

            salaries[i] = salary;
            years[i] = service;
        }

        double totalBonus = 0;
        double totalOldSalary = 0;
        double totalNewSalary = 0;

        for (int i = 0; i < 10; i++) {
            double bonusRate = years[i] > 5 ? 0.05 : 0.02;
            double bonus = salaries[i] * bonusRate;
            double newSalary = salaries[i] + bonus;

            bonuses[i] = bonus;
            newSalaries[i] = newSalary;
            totalBonus += bonus;
            totalOldSalary += salaries[i];
            totalNewSalary += newSalary;
        }

        System.out.println("Total bonus payout: " + totalBonus);
        System.out.println("Total old salary: " + totalOldSalary);
        System.out.println("Total new salary: " + totalNewSalary);
        scanner.close();
    }
}
