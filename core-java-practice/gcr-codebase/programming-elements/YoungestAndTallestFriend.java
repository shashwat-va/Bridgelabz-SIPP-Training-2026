import java.util.Scanner;

public class YoungestAndTallestFriend {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Amar's age and height:");
        int amarAge = scanner.nextInt();
        double amarHeight = scanner.nextDouble();

        System.out.println("Enter Akbar's age and height:");
        int akbarAge = scanner.nextInt();
        double akbarHeight = scanner.nextDouble();

        System.out.println("Enter Anthony's age and height:");
        int anthonyAge = scanner.nextInt();
        double anthonyHeight = scanner.nextDouble();

        int youngestAge = amarAge;
        String youngestName = "Amar";

        if (akbarAge < youngestAge) {
            youngestAge = akbarAge;
            youngestName = "Akbar";
        }
        if (anthonyAge < youngestAge) {
            youngestAge = anthonyAge;
            youngestName = "Anthony";
        }

        double tallestHeight = amarHeight;
        String tallestName = "Amar";

        if (akbarHeight > tallestHeight) {
            tallestHeight = akbarHeight;
            tallestName = "Akbar";
        }
        if (anthonyHeight > tallestHeight) {
            tallestHeight = anthonyHeight;
            tallestName = "Anthony";
        }

        System.out.println("Youngest friend: " + youngestName + " (age " + youngestAge + ")");
        System.out.println("Tallest friend: " + tallestName + " (height " + tallestHeight + ")");

        scanner.close();
    }
}
