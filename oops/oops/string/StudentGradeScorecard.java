import java.util.Scanner;

/**
 * Program to generate student scores, compute percentage, and grade result.
 */
public class StudentGradeScorecard {
    public static int[][] generateRandomScores(int students) {
        int[][] scores = new int[students][3];
        for (int i = 0; i < students; i++) {
            scores[i][0] = 10 + (int) (Math.random() * 90);
            scores[i][1] = 10 + (int) (Math.random() * 90);
            scores[i][2] = 10 + (int) (Math.random() * 90);
        }
        return scores;
    }

    public static String[][] computeTotalsAndGrades(int[][] scores) {
        int students = scores.length;
        String[][] report = new String[students][7];
        for (int i = 0; i < students; i++) {
            int physics = scores[i][0];
            int chemistry = scores[i][1];
            int maths = scores[i][2];
            int total = physics + chemistry + maths;
            double average = total / 3.0;
            double percentage = (total * 100.0) / 300.0;
            percentage = Math.round(percentage * 100.0) / 100.0;
            report[i][0] = String.valueOf(i + 1);
            report[i][1] = String.valueOf(physics);
            report[i][2] = String.valueOf(chemistry);
            report[i][3] = String.valueOf(maths);
            report[i][4] = String.valueOf(total);
            report[i][5] = String.valueOf(Math.round(average * 100.0) / 100.0);
            report[i][6] = getGrade(percentage);
        }
        return report;
    }

    public static String getGrade(double percentage) {
        if (percentage >= 80) {
            return "A";
        }
        if (percentage >= 70) {
            return "B";
        }
        if (percentage >= 60) {
            return "C";
        }
        if (percentage >= 50) {
            return "D";
        }
        if (percentage >= 40) {
            return "E";
        }
        return "R";
    }

    public static void displayScorecard(String[][] report) {
        System.out.printf("%-8s %-8s %-10s %-8s %-8s %-10s %s\n", "Student", "Physics", "Chemistry", "Maths", "Total", "Average", "Grade");
        System.out.println("-------------------------------------------------------------------");
        for (String[] row : report) {
            System.out.printf("%-8s %-8s %-10s %-8s %-8s %-10s %s\n", row[0], row[1], row[2], row[3], row[4], row[5], row[6]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Student Grade Scorecard Program ===");
        System.out.print("Enter number of students: ");
        int students = scanner.nextInt();
        scanner.nextLine();

        int[][] scores = generateRandomScores(students);
        String[][] report = computeTotalsAndGrades(scores);
        displayScorecard(report);
        scanner.close();
    }
}
