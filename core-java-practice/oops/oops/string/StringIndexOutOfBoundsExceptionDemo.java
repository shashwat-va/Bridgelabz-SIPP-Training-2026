import java.util.Scanner;

/**
 * Program to demonstrate StringIndexOutOfBoundsException
 */
public class StringIndexOutOfBoundsExceptionDemo {
    
    /**
     * Method to generate StringIndexOutOfBoundsException
     * This will throw an exception and stop the program
     */
    public static void generateStringIndexOutOfBoundsException(String text) {
        System.out.println("String: " + text);
        System.out.println("Length: " + text.length());
        System.out.println("Attempting to access character at index " + (text.length() + 5) + "...");
        char ch = text.charAt(text.length() + 5);  // This will throw StringIndexOutOfBoundsException
        System.out.println("Character: " + ch);
    }
    
    /**
     * Method to handle StringIndexOutOfBoundsException
     * This will catch and handle the exception gracefully
     */
    public static void handleStringIndexOutOfBoundsException(String text) {
        try {
            System.out.println("String: " + text);
            System.out.println("Length: " + text.length());
            System.out.println("Attempting to access character at index " + (text.length() + 5) + "...");
            char ch = text.charAt(text.length() + 5);  // This will throw StringIndexOutOfBoundsException
            System.out.println("Character: " + ch);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("StringIndexOutOfBoundsException caught!");
            System.out.println("Error message: " + e.getMessage());
            System.out.println("Exception type: " + e.getClass().getSimpleName());
        } catch (RuntimeException e) {
            System.out.println("RuntimeException caught!");
            System.out.println("Error message: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== StringIndexOutOfBoundsException Demo ===\n");
        System.out.print("Enter a string: ");
        String text = scanner.next();
        
        // First, demonstrate generating the exception
        System.out.println("\n--- Demonstrating StringIndexOutOfBoundsException (will crash) ---");
        try {
            generateStringIndexOutOfBoundsException(text);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Exception was not caught in generateStringIndexOutOfBoundsException()");
            System.out.println("Caught in main: " + e.getClass().getSimpleName());
        }
        
        System.out.println("\n--- Demonstrating StringIndexOutOfBoundsException Handling ---");
        // Now, demonstrate handling the exception
        handleStringIndexOutOfBoundsException(text);
        
        System.out.println("\nProgram completed successfully!");
        scanner.close();
    }
}
