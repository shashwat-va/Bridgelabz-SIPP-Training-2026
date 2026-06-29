/**
 * Program to demonstrate NullPointerException
 */
public class NullPointerExceptionDemo {
    
    /**
     * Method to generate NullPointerException
     * This will throw an exception and stop the program
     */
    public static void generateNullPointerException() {
        String text = null;  // Initialize to null
        System.out.println("Attempting to call length() on null string...");
        System.out.println("Length: " + text.length());  // This will throw NullPointerException
    }
    
    /**
     * Method to handle NullPointerException
     * This will catch and handle the exception gracefully
     */
    public static void handleNullPointerException() {
        try {
            String text = null;  // Initialize to null
            System.out.println("Attempting to call length() on null string...");
            System.out.println("Length: " + text.length());  // This will throw NullPointerException
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught!");
            System.out.println("Error message: " + e.getMessage());
            System.out.println("Exception type: " + e.getClass().getSimpleName());
        } catch (Exception e) {
            System.out.println("Generic Exception caught!");
            System.out.println("Error message: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== NullPointerException Demo ===\n");
        
        // First, demonstrate generating the exception
        System.out.println("--- Demonstrating NullPointerException (will crash) ---");
        try {
            generateNullPointerException();
        } catch (NullPointerException e) {
            System.out.println("Exception was not caught in generateNullPointerException()");
            System.out.println("Caught in main: " + e.getClass().getSimpleName());
        }
        
        System.out.println("\n--- Demonstrating NullPointerException Handling ---");
        // Now, demonstrate handling the exception
        handleNullPointerException();
        
        System.out.println("\nProgram completed successfully!");
    }
}
