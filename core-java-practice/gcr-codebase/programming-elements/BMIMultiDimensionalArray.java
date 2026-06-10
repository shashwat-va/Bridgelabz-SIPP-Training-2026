import java.util.Scanner;

public class BMIMultiDimensionalArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of persons:");
        int number = scanner.nextInt();

        double[][] personData = new double[number][3];
        String[] weightStatus = new String[number];

        for (int i = 0; i < number; i++) {
            System.out.println("Enter weight (kg) and height (meters) for person " + (i + 1) + ":");
            double weight = scanner.nextDouble();
            double height = scanner.nextDouble();

            if (weight <= 0 || height <= 0) {
                System.out.println("Invalid input. Please enter positive values.");
                i--;
                continue;
            }

            double bmi = weight / (height * height);
            personData[i][0] = weight;
            personData[i][1] = height;
            personData[i][2] = bmi;
            weightStatus[i] = getWeightStatus(bmi);
        }

        for (int i = 0; i < number; i++) {
            System.out.println("Person " + (i + 1) + ": height=" + personData[i][1] + ", weight=" + personData[i][0] + ", BMI=" + personData[i][2] + ", status=" + weightStatus[i]);
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
