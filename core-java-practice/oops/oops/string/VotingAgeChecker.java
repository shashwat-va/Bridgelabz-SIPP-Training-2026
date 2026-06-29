import java.util.Scanner;

/**
 * Program to generate random student ages and check voting eligibility.
 */
public class VotingAgeChecker {
    public static int[] generateRandomAges(int numberOfStudents) {
        int[] ages = new int[numberOfStudents];
        for (int i = 0; i < numberOfStudents; i++) {
            ages[i] = 10 + (int) (Math.random() * 90); // random 2-digit age from 10 to 99
        }
        return ages;
    }

    public static String[][] buildVotingTable(int[] ages) {
        String[][] table = new String[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            table[i][0] = String.valueOf(ages[i]);
            boolean canVote = ages[i] >= 18;
            table[i][1] = String.valueOf(canVote);
        }
        return table;
    }

    public static void displayTable(String[][] table) {
        System.out.printf("%-10s %s\n", "Age", "Can Vote");
        System.out.println("----------------");
        for (String[] row : table) {
            System.out.printf("%-10s %s\n", row[0], row[1]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Voting Age Checker Program ===");
        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        int[] ages = generateRandomAges(n);
        String[][] table = buildVotingTable(ages);
        displayTable(table);
        scanner.close();
    }
}
