import java.util.Scanner;

public class SpringSeasonChecker {
    public static boolean isSpringSeason(int month, int day) {
        return (month == 3 && day >= 20) || (month > 3 && month < 6) || (month == 6 && day <= 20);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter month: ");
        int month = scanner.nextInt();
        System.out.print("Enter day: ");
        int day = scanner.nextInt();

        boolean result = isSpringSeason(month, day);
        if (result) {
            System.out.println("Its a Spring Season");
        } else {
            System.out.println("Not a Spring Season");
        }
        scanner.close();
    }
}
