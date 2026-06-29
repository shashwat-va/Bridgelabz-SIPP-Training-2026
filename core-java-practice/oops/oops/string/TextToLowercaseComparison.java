import java.util.Scanner;

/**
 * Program to convert complete text to lowercase and compare results
 * Using custom charAt() method vs built-in toLowerCase()
 */
public class TextToLowercaseComparison {
    
    /**
     * Method to convert string to lowercase using charAt() method
     * ASCII value of 'A' is 65 and 'a' is 97, difference is 32
     * @param text The text to convert
     * @return Lowercase text
     */
    public static String convertToLowercaseUsingCharAt(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            // Check if character is uppercase (ASCII 65-90)
            if (ch >= 'A' && ch <= 'Z') {
                // Convert to lowercase by adding 32
                result += (char)(ch + 32);
            } else {
                // Keep the character as is if it's not uppercase
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
        
        System.out.println("=== Text to Lowercase Comparison Program ===");
        System.out.print("Enter a text: ");
        String text = scanner.nextLine();
        
        System.out.println("\nOriginal text: " + text);
        
        // Convert using custom charAt() method
        String lowercaseCustom = convertToLowercaseUsingCharAt(text);
        System.out.println("Using charAt() method: " + lowercaseCustom);
        
        // Convert using built-in toLowerCase() method
        String lowercaseBuiltIn = text.toLowerCase();
        System.out.println("Using toLowerCase() method: " + lowercaseBuiltIn);
        
        // Compare the two results
        boolean result = compareStringsUsingCharAt(lowercaseCustom, lowercaseBuiltIn);
        System.out.println("\nBoth results are " + (result ? "equal" : "not equal"));
        
        scanner.close();
    }
}
