import java.util.Scanner;

public class StudentGrades2DArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of students:");
        int number = scanner.nextInt();

        int[][] marks = new int[number][3];
        double[] percentages = new double[number];
        String[] grades = new String[number];

        for (int i = 0; i < number; i++) {
            System.out.println("Enter marks for student " + (i + 1) + " in physics, chemistry, and maths:");
            int p = scanner.nextInt();
            int c = scanner.nextInt();
            int m = scanner.nextInt();

            if (p < 0 || c < 0 || m < 0) {
                System.out.println("Invalid marks. Enter positive values.");
                i--;
                continue;
            }

            marks[i][0] = p;
            marks[i][1] = c;
            marks[i][2] = m;
            percentages[i] = ((p + c + m) / 300.0) * 100;
            grades[i] = getGrade(percentages[i]);
        }

        for (int i = 0; i < number; i++) {
            System.out.println("Student " + (i + 1) + ": physics=" + marks[i][0] + ", chemistry=" + marks[i][1] + ", maths=" + marks[i][2] + ", percentage=" + percentages[i] + ", grade=" + grades[i]);
        }
        scanner.close();
    }

    private static String getGrade(double percentage) {
        if (percentage >= 80) {
            return "A";
        } else if (percentage >= 70) {
            return "B";
        } else if (percentage >= 60) {
            return "C";
        } else if (percentage >= 50) {
            return "D";
        } else if (percentage >= 40) {
            return "E";
        } else {
            return "R";
        }
    }
}
