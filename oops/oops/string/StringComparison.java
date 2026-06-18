import java.util.Scanner;

/**
 * Program to compare two strings using the charAt() method
 * and check the result with the built-in String equals() method
 */
public class StringComparison {
    
    /**
     * Method to compare two strings using charAt() method
     * @param str1 First string to compare
     * @param str2 Second string to compare
     * @return true if both strings are equal, false otherwise
     */
    public static boolean compareStringsUsingCharAt(String str1, String str2) {
        // If lengths are different, strings are not equal
        if (str1.length() != str2.length()) {
            return false;
        }
        
        // Compare each character using charAt()
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Take input for two strings
        System.out.println("=== String Comparison Program ===");
        System.out.print("Enter first string: ");
        String str1 = scanner.next();
        
        System.out.print("Enter second string: ");
        String str2 = scanner.next();
        
        // Compare using custom charAt() method
        boolean resultCharAt = compareStringsUsingCharAt(str1, str2);
        System.out.println("\nUsing charAt() method: Strings are " + 
            (resultCharAt ? "equal" : "not equal"));
        
        // Compare using built-in equals() method
        boolean resultEquals = str1.equals(str2);
        System.out.println("Using equals() method: Strings are " + 
            (resultEquals ? "equal" : "not equal"));
        
        // Check if both results match
        System.out.println("\nResults match: " + (resultCharAt == resultEquals));
        
        scanner.close();
    }
}
