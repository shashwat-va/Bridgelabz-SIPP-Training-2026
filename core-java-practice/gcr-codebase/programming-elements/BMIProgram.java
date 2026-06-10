import java.util.Scanner;

public class BMIProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of persons:");
        int number = scanner.nextInt();

        double[] weights = new double[number];
        double[] heights = new double[number];
        double[] bmis = new double[number];
        String[] statuses = new String[number];

        for (int i = 0; i < number; i++) {
            System.out.println("Enter weight (kg) and height (meters) for person " + (i + 1) + ":");
            double weight = scanner.nextDouble();
            double height = scanner.nextDouble();

            if (weight <= 0 || height <= 0) {
                System.out.println("Invalid input. Please enter positive values.");
                i--;
                continue;
            }

            weights[i] = weight;
            heights[i] = height;
            bmis[i] = weight / (height * height);
            statuses[i] = getWeightStatus(bmis[i]);
        }

        for (int i = 0; i < number; i++) {
            System.out.println("Person " + (i + 1) + ": height=" + heights[i] + ", weight=" + weights[i] + ", BMI=" + bmis[i] + ", status=" + statuses[i]);
        }
        scanner.close();
    }

    private static String getWeightStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25) {
            return "Normal weight";
        } else if (bmi < 30) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }
}
