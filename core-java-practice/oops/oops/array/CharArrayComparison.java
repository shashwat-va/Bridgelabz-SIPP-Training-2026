import java.util.Scanner;

/**
 * Program to return characters in a string using user-defined method
 * Compare with the String built-in toCharArray() method
 */
public class CharArrayComparison {
    
    /**
     * Method to convert string to char array using charAt()
     * @param str The string to convert
     * @return Char array created from the string
     */
    public static char[] convertStringToCharArray(String str) {
        char[] charArray = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            charArray[i] = str.charAt(i);
        }
        return charArray;
    }
    
    /**
     * Method to compare two char arrays
     * @param arr1 First char array
     * @param arr2 Second char array
     * @return true if both arrays are equal, false otherwise
     */
    public static boolean compareCharArrays(char[] arr1, char[] arr2) {
        // If lengths are different, arrays are not equal
        if (arr1.length != arr2.length) {
            return false;
        }
        
        // Compare each character
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Method to display char array
     * @param arr The char array to display
     */
    public static void displayCharArray(char[] arr) {
        System.out.print("[ ");
        for (char c : arr) {
            System.out.print(c + " ");
        }
        System.out.println("]");
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Character Array Comparison Program ===");
        System.out.print("Enter a text: ");
        String text = scanner.next();
        
        // User-defined method to get char array
        char[] customCharArray = convertStringToCharArray(text);
        System.out.println("\nChar array using charAt() method:");
        displayCharArray(customCharArray);
        
        // Built-in toCharArray() method
        char[] builtInCharArray = text.toCharArray();
        System.out.println("Char array using toCharArray() method:");
        displayCharArray(builtInCharArray);
        
        // Compare the two arrays
        boolean result = compareCharArrays(customCharArray, builtInCharArray);
        System.out.println("\nBoth arrays are " + (result ? "equal" : "not equal"));
        
        scanner.close();
    }
}
