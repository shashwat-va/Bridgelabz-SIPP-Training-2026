import java.util.Scanner;

public class BasicCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        float firstNumber = scanner.nextFloat();
        float secondNumber = scanner.nextFloat();

        float sum = firstNumber + secondNumber;
        float difference = firstNumber - secondNumber;
        float product = firstNumber * secondNumber;
        float quotient = firstNumber / secondNumber;

        System.out.println("The addition, subtraction, multiplication, and division value of "
                + firstNumber + " and " + secondNumber + " is "
                + sum + ", " + difference + ", " + product + ", and " + quotient);

        scanner.close();
    }
}
