import java.util.Scanner;

/**
 * Program to demonstrate IllegalArgumentException
 */
public class IllegalArgumentExceptionDemo {
    
    /**
     * Method to generate IllegalArgumentException
     * This will throw an exception and stop the program
     */
    public static void generateIllegalArgumentException(String text) {
        System.out.println("String: " + text);
        System.out.println("String length: " + text.length());
        System.out.println("Attempting substring(5, 2)...");
        String substring = text.substring(5, 2);  // Start > End will throw IllegalArgumentException
        System.out.println("Substring: " + substring);
    }
    
    /**
     * Method to handle IllegalArgumentException
     * This will catch and handle the exception gracefully
     */
    public static void handleIllegalArgumentException(String text) {
        try {
            System.out.println("String: " + text);
            System.out.println("String length: " + text.length());
            System.out.println("Attempting substring(5, 2)...");
            String substring = text.substring(5, 2);  // Start > End will throw IllegalArgumentException
            System.out.println("Substring: " + substring);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException caught!");
            System.out.println("Error message: " + e.getMessage());
            System.out.println("Exception type: " + e.getClass().getSimpleName());
        } catch (RuntimeException e) {
            System.out.println("RuntimeException caught!");
            System.out.println("Error message: " + e.getMessage());
            System.out.println("Exception type: " + e.getClass().getSimpleName());
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== IllegalArgumentException Demo ===\n");
        System.out.print("Enter a string (preferably at least 5 characters): ");
        String text = scanner.next();
        
        // First, demonstrate generating the exception
        System.out.println("\n--- Demonstrating IllegalArgumentException (will crash) ---");
        try {
            generateIllegalArgumentException(text);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception was not caught in generateIllegalArgumentException()");
            System.out.println("Caught in main: " + e.getClass().getSimpleName());
        }
        
        System.out.println("\n--- Demonstrating IllegalArgumentException Handling ---");
        // Now, demonstrate handling the exception
        handleIllegalArgumentException(text);
        
        System.out.println("\nProgram completed successfully!");
        scanner.close();
    }
}
