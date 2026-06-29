import java.util.Scanner;

public class ReverseNumberArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int original = number;
        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int index = 0;

        while (number != 0) {
            if (index == maxDigit) {
                maxDigit += 10;
                int[] temp = new int[maxDigit];
                System.arraycopy(digits, 0, temp, 0, digits.length);
                digits = temp;
            }
            digits[index] = Math.abs(number % 10);
            number /= 10;
            index++;
        }

        int[] reversed = new int[index];
        for (int i = 0; i < index; i++) {
            reversed[i] = digits[index - 1 - i];
        }

        for (int i = 0; i < reversed.length; i++) {
            System.out.print(reversed[i]);
            if (i < reversed.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
        scanner.close();
    }
}
