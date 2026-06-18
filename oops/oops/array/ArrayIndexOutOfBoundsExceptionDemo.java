import java.util.Scanner;

/**
 * Program to demonstrate ArrayIndexOutOfBoundsException
 */
public class ArrayIndexOutOfBoundsExceptionDemo {
    
    /**
     * Method to generate ArrayIndexOutOfBoundsException
     * This will throw an exception and stop the program
     */
    public static void generateArrayIndexOutOfBoundsException(String[] names) {
        System.out.println("Array size: " + names.length);
        System.out.println("Array contents:");
        for (int i = 0; i < names.length; i++) {
            System.out.println("  [" + i + "]: " + names[i]);
        }
        System.out.println("\nAttempting to access index " + (names.length + 5) + "...");
        String name = names[names.length + 5];  // This will throw ArrayIndexOutOfBoundsException
        System.out.println("Name: " + name);
    }
    
    /**
     * Method to handle ArrayIndexOutOfBoundsException
     * This will catch and handle the exception gracefully
     */
    public static void handleArrayIndexOutOfBoundsException(String[] names) {
        try {
            System.out.println("Array size: " + names.length);
            System.out.println("Array contents:");
            for (int i = 0; i < names.length; i++) {
                System.out.println("  [" + i + "]: " + names[i]);
            }
            System.out.println("\nAttempting to access index " + (names.length + 5) + "...");
            String name = names[names.length + 5];  // This will throw ArrayIndexOutOfBoundsException
            System.out.println("Name: " + name);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException caught!");
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
        
        System.out.println("=== ArrayIndexOutOfBoundsException Demo ===\n");
        System.out.print("Enter the number of names: ");
        int n = scanner.nextInt();
        scanner.nextLine();  // Consume the newline
        
        String[] names = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            names[i] = scanner.nextLine();
        }
        
        // First, demonstrate generating the exception
        System.out.println("\n--- Demonstrating ArrayIndexOutOfBoundsException (will crash) ---");
        try {
            generateArrayIndexOutOfBoundsException(names);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception was not caught in generateArrayIndexOutOfBoundsException()");
            System.out.println("Caught in main: " + e.getClass().getSimpleName());
        }
        
        System.out.println("\n--- Demonstrating ArrayIndexOutOfBoundsException Handling ---");
        // Now, demonstrate handling the exception
        handleArrayIndexOutOfBoundsException(names);
        
        System.out.println("\nProgram completed successfully!");
        scanner.close();
    }
}
