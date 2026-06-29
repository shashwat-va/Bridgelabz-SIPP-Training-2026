import java.util.Scanner;

/**
 * Program to convert complete text to uppercase and compare results
 * Using custom charAt() method vs built-in toUpperCase()
 */
public class TextToUppercaseComparison {
    
    /**
     * Method to convert string to uppercase using charAt() method
     * ASCII value of 'a' is 97 and 'A' is 65, difference is 32
     * @param text The text to convert
     * @return Uppercase text
     */
    public static String convertToUppercaseUsingCharAt(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            // Check if character is lowercase (ASCII 97-122)
            if (ch >= 'a' && ch <= 'z') {
                // Convert to uppercase by subtracting 32
                result += (char)(ch - 32);
            } else {
                // Keep the character as is if it's not lowercase
                result += ch;
            }
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
        
        System.out.println("=== Text to Uppercase Comparison Program ===");
        System.out.print("Enter a text: ");
        String text = scanner.nextLine();
        
        System.out.println("\nOriginal text: " + text);
        
        // Convert using custom charAt() method
        String uppercaseCustom = convertToUppercaseUsingCharAt(text);
        System.out.println("Using charAt() method: " + uppercaseCustom);
        
        // Convert using built-in toUpperCase() method
        String uppercaseBuiltIn = text.toUpperCase();
        System.out.println("Using toUpperCase() method: " + uppercaseBuiltIn);
        
        // Compare the two results
        boolean result = compareStringsUsingCharAt(uppercaseCustom, uppercaseBuiltIn);
        System.out.println("\nBoth results are " + (result ? "equal" : "not equal"));
        
        scanner.close();
    }
}
