import java.util.Scanner;

/**
 * Program to trim leading and trailing spaces using charAt().
 */
public class TrimUsingCharAt {
    public static int[] getTrimIndexes(String text) {
        int start = 0;
        int end = text.length() - 1;

        while (start <= end && text.charAt(start) == ' ') {
            start++;
        }
        while (end >= start && text.charAt(end) == ' ') {
            end--;
        }

        return new int[] { start, end + 1 };
    }

    public static String substringUsingCharAt(String text, int start, int end) {
        String result = "";
        for (int i = start; i < end; i++) {
            result += text.charAt(i);
        }
        return result;
    }

    public static boolean compareStringsUsingCharAt(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Trim Using CharAt Program ===");
        System.out.print("Enter text with leading/trailing spaces: ");
        String text = scanner.nextLine();

        int[] indexes = getTrimIndexes(text);
        String trimmedCustom = substringUsingCharAt(text, indexes[0], indexes[1]);
        String trimmedBuiltIn = text.trim();

        System.out.println("Trimmed using custom method: '" + trimmedCustom + "'");
        System.out.println("Trimmed using built-in trim(): '" + trimmedBuiltIn + "'");
        System.out.println("Results match: " + compareStringsUsingCharAt(trimmedCustom, trimmedBuiltIn));
        scanner.close();
    }
}
