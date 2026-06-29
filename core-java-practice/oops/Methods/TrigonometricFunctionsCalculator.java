import java.util.Scanner;

public class TrigonometricFunctionsCalculator {
    public static double[] calculateTrigonometricFunctions(double angle) {
        double radians = Math.toRadians(angle);
        return new double[]{Math.sin(radians), Math.cos(radians), Math.tan(radians)};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter angle in degrees: ");
        double angle = scanner.nextDouble();

        double[] result = calculateTrigonometricFunctions(angle);
        System.out.printf("Sin: %.4f%nCos: %.4f%nTan: %.4f%n", result[0], result[1], result[2]);
        scanner.close();
    }
}
