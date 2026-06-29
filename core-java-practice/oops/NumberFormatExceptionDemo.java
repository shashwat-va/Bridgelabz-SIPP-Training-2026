import java.util.Scanner;

/**
 * Program to demonstrate NumberFormatException
 */
public class NumberFormatExceptionDemo {
    
    /**
     * Method to generate NumberFormatException
     * This will throw an exception and stop the program
     */
    public static void generateNumberFormatException(String text) {
        System.out.println("Input text: " + text);
        System.out.println("Attempting to parse as integer using Integer.parseInt()...");
        int number = Integer.parseInt(text);  // This will throw NumberFormatException if text is not a number
        System.out.println("Parsed number: " + number);
    }
    
    /**
     * Method to handle NumberFormatException
     * This will catch and handle the exception gracefully
     */
    public static void handleNumberFormatException(String text) {
        try {
            System.out.println("Input text: " + text);
            System.out.println("Attempting to parse as integer using Integer.parseInt()...");
            int number = Integer.parseInt(text);  // This will throw NumberFormatException if text is not a number
            System.out.println("Parsed number: " + number);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException caught!");
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
        
        System.out.println("=== NumberFormatException Demo ===\n");
        System.out.print("Enter a value (try entering non-numeric text): ");
        String text = scanner.nextLine();
        
        // First, demonstrate generating the exception
        System.out.println("\n--- Demonstrating NumberFormatException (will crash) ---");
        try {
            generateNumberFormatException(text);
        } catch (NumberFormatException e) {
            System.out.println("Exception was not caught in generateNumberFormatException()");
            System.out.println("Caught in main: " + e.getClass().getSimpleName());
        }
        
        System.out.println("\n--- Demonstrating NumberFormatException Handling ---");
        // Now, demonstrate handling the exception
        handleNumberFormatException(text);
        
        System.out.println("\nProgram completed successfully!");
        scanner.close();
    }
}
