import java.util.Scanner;

/**
 * Program to find string length without using length() method.
 */
public class StringLengthWithoutLengthMethod {
    public static int getStringLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            return count;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== String Length Without length() Method ===");
        System.out.print("Enter a string: ");
        String text = scanner.nextLine();

        int lengthWithout = getStringLength(text);
        int lengthWith = text.length();

        System.out.println("Length using custom method: " + lengthWithout);
        System.out.println("Length using built-in length(): " + lengthWith);
        System.out.println("Results match: " + (lengthWithout == lengthWith));
        scanner.close();
    }
}
