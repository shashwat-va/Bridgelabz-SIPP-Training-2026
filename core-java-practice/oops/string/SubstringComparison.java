import java.util.Scanner;

/**
 * Program to create a substring using charAt() method
 * and compare with the built-in substring() method
 */
public class SubstringComparison {
    
    /**
     * Method to create substring using charAt() method
     * @param str The original string
     * @param startIndex Start index (inclusive)
     * @param endIndex End index (exclusive)
     * @return Substring from startIndex to endIndex
     */
    public static String createSubstringUsingCharAt(String str, int startIndex, int endIndex) {
        String result = "";
        for (int i = startIndex; i < endIndex; i++) {
            result += str.charAt(i);
        }
        return result;
    }
    
    /**
     * Method to compare two strings using charAt() method
     * @param str1 First string to compare
     * @param str2 Second string to compare
     * @return true if both strings are equal, false otherwise
     */
    public static boolean compareStringsUsingCharAt(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Substring Comparison Program ===");
        System.out.print("Enter the text: ");
        String text = scanner.next();
        
        System.out.print("Enter start index: ");
        int startIndex = scanner.nextInt();
        
        System.out.print("Enter end index: ");
        int endIndex = scanner.nextInt();
        
        // Create substring using custom charAt() method
        String substringCharAt = createSubstringUsingCharAt(text, startIndex, endIndex);
        System.out.println("\nUsing charAt() method: " + substringCharAt);
        
        // Create substring using built-in substring() method
        String substringBuiltIn = text.substring(startIndex, endIndex);
        System.out.println("Using substring() method: " + substringBuiltIn);
        
        // Compare the two substrings using custom method
        boolean result = compareStringsUsingCharAt(substringCharAt, substringBuiltIn);
        System.out.println("\nBoth substrings are " + (result ? "equal" : "not equal"));
        
        scanner.close();
    }
}
