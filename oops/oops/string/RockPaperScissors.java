import java.util.Scanner;

/**
 * Program to play Rock-Paper-Scissors and show stats.
 */
public class RockPaperScissors {
    public static String getComputerChoice() {
        int choice = (int) (Math.random() * 3);
        switch (choice) {
            case 0:
                return "rock";
            case 1:
                return "paper";
            default:
                return "scissors";
        }
    }

    public static String findWinner(String userChoice, String computerChoice) {
        if (userChoice.equals(computerChoice)) {
            return "Draw";
        }
        if (userChoice.equals("rock") && computerChoice.equals("scissors")) {
            return "User";
        }
        if (userChoice.equals("paper") && computerChoice.equals("rock")) {
            return "User";
        }
        if (userChoice.equals("scissors") && computerChoice.equals("paper")) {
            return "User";
        }
        return "Computer";
    }

    public static String[][] buildResultTable(String[] userChoices, String[] computerChoices, String[] winners) {
        String[][] table = new String[userChoices.length + 1][4];
        for (int i = 0; i < userChoices.length; i++) {
            table[i][0] = String.valueOf(i + 1);
            table[i][1] = userChoices[i];
            table[i][2] = computerChoices[i];
            table[i][3] = winners[i];
        }
        int userWins = 0;
        int computerWins = 0;
        int draws = 0;
        for (String winner : winners) {
            if (winner.equals("User")) {
                userWins++;
            } else if (winner.equals("Computer")) {
                computerWins++;
            } else {
                draws++;
            }
        }
        table[userChoices.length][0] = "Total";
        table[userChoices.length][1] = "User " + userWins;
        table[userChoices.length][2] = "Comp " + computerWins;
        table[userChoices.length][3] = "Draws " + draws;
        return table;
    }

    public static void displayResults(String[][] table) {
        System.out.printf("%-6s %-10s %-12s %s\n", "Game", "User", "Computer", "Winner");
        System.out.println("------------------------------------");
        for (int i = 0; i < table.length - 1; i++) {
            System.out.printf("%-6s %-10s %-12s %s\n", table[i][0], table[i][1], table[i][2], table[i][3]);
        }
        System.out.println("------------------------------------");
        System.out.printf("%-6s %-10s %-12s %s\n", table[table.length - 1][0], table[table.length - 1][1], table[table.length - 1][2], table[table.length - 1][3]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Rock-Paper-Scissors Game ===");
        System.out.print("Enter number of games: ");
        int games = scanner.nextInt();
        scanner.nextLine();

        String[] userChoices = new String[games];
        String[] computerChoices = new String[games];
        String[] winners = new String[games];
        int userWins = 0;
        int computerWins = 0;

        for (int i = 0; i < games; i++) {
            System.out.print("Enter choice for game " + (i + 1) + " (rock/paper/scissors): ");
            String userChoice = scanner.nextLine().trim().toLowerCase();
            if (!userChoice.equals("rock") && !userChoice.equals("paper") && !userChoice.equals("scissors")) {
                System.out.println("Invalid choice. Defaulting to rock.");
                userChoice = "rock";
            }
            String computerChoice = getComputerChoice();
            String winner = findWinner(userChoice, computerChoice);
            if (winner.equals("User")) {
                userWins++;
            } else if (winner.equals("Computer")) {
                computerWins++;
            }
            userChoices[i] = userChoice;
            computerChoices[i] = computerChoice;
            winners[i] = winner;
        }

        String[][] table = buildResultTable(userChoices, computerChoices, winners);
        displayResults(table);
        double userPercentage = games == 0 ? 0 : (userWins * 100.0 / games);
        double computerPercentage = games == 0 ? 0 : (computerWins * 100.0 / games);

        System.out.printf("\nUser win percentage: %.2f%%\n", userPercentage);
        System.out.printf("Computer win percentage: %.2f%%\n", computerPercentage);
        scanner.close();
    }
}
