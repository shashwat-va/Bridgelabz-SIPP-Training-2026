import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionHandlingPractice {

    public static void checkedExceptionExample() {
        String fileName = "data.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }

    public static void uncheckedExceptionExample() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter numerator: ");
            int numerator = scanner.nextInt();
            System.out.print("Enter denominator: ");
            int denominator = scanner.nextInt();
            int result = numerator / denominator;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero");
        } catch (InputMismatchException e) {
            System.out.println("Please enter valid numeric values");
        } finally {
            scanner.nextLine();
        }
    }

    public static void customExceptionExample() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter age: ");
            int age = scanner.nextInt();
            validateAge(age);
            System.out.println("Access granted!");
        } catch (InvalidAgeException e) {
            System.out.println("Age must be 18 or above");
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid age");
        } finally {
            scanner.nextLine();
        }
    }

    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or above");
        }
    }

    public static void multipleCatchExample() {
        try {
            int[] array = {1, 2, 3, 4, 5};
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter index: ");
            int index = scanner.nextInt();
            System.out.println("Value at index " + index + ": " + array[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        }
    }

    public static void tryWithResourcesExample() {
        String fileName = "info.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String firstLine = reader.readLine();
            System.out.println(firstLine);
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }

    public static double calculateInterest(double amount, double rate, int years) throws IllegalArgumentException {
        if (amount < 0 || rate < 0) {
            throw new IllegalArgumentException("Amount and rate must be positive");
        }
        return amount * rate * years / 100.0;
    }

    public static void throwVsThrowsExample() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter amount: ");
            double amount = scanner.nextDouble();
            System.out.print("Enter rate: ");
            double rate = scanner.nextDouble();
            System.out.print("Enter years: ");
            int years = scanner.nextInt();
            double interest = calculateInterest(amount, rate, years);
            System.out.println("Calculated interest: " + interest);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input: Amount and rate must be positive");
        } catch (InputMismatchException e) {
            System.out.println("Please enter valid numeric input");
        } finally {
            scanner.nextLine();
        }
    }

    public static void finallyBlockExample() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter numerator: ");
            int numerator = scanner.nextInt();
            System.out.print("Enter denominator: ");
            int denominator = scanner.nextInt();
            int result = numerator / denominator;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero");
        } catch (InputMismatchException e) {
            System.out.println("Please enter valid numeric values");
        } finally {
            System.out.println("Operation completed");
            scanner.nextLine();
        }
    }

    public static void method1() {
        int result = 10 / 0;
        System.out.println(result);
    }

    public static void method2() {
        method1();
    }

    public static void exceptionPropagationExample() {
        try {
            method2();
        } catch (ArithmeticException e) {
            System.out.println("Handled exception in main");
        }
    }

    public static void nestedTryCatchExample() {
        int[] array = {2, 4, 6, 8, 10};
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter index: ");
            int index = scanner.nextInt();
            try {
                System.out.print("Enter divisor: ");
                int divisor = scanner.nextInt();
                int result = array[index] / divisor;
                System.out.println("Division result: " + result);
            } catch (ArithmeticException e) {
                System.out.println("Cannot divide by zero!");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid array index!");
        } finally {
            scanner.nextLine();
        }
    }

    public static void bankTransactionExample() {
        BankAccount account = new BankAccount(500.0);
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter withdrawal amount: ");
            double amount = scanner.nextDouble();
            account.withdraw(amount);
            System.out.println("Withdrawal successful, new balance: " + account.getBalance());
        } catch (InvalidAmountException e) {
            System.out.println("Invalid amount!");
        } catch (InsufficientBalanceException e) {
            System.out.println("Insufficient balance!");
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid amount");
        } finally {
            scanner.nextLine();
        }
    }

    public static void main(String[] args) {
        System.out.println("1. Checked Exception Example");
        checkedExceptionExample();
        System.out.println("\n2. Unchecked Exception Example");
        uncheckedExceptionExample();
        System.out.println("\n3. Custom Exception Example");
        customExceptionExample();
        System.out.println("\n4. Multiple Catch Example");
        multipleCatchExample();
        System.out.println("\n5. Try-with-resources Example");
        tryWithResourcesExample();
        System.out.println("\n6. throw vs throws Example");
        throwVsThrowsExample();
        System.out.println("\n7. finally Block Example");
        finallyBlockExample();
        System.out.println("\n8. Exception Propagation Example");
        exceptionPropagationExample();
        System.out.println("\n9. Nested try-catch Example");
        nestedTryCatchExample();
        System.out.println("\n10. Bank Transaction Example");
        bankTransactionExample();
    }
}

class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) throws InvalidAmountException, InsufficientBalanceException {
        if (amount < 0) {
            throw new InvalidAmountException("Amount cannot be negative");
        }
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient funds");
        }
        balance -= amount;
    }
}

class InvalidAmountException extends Exception {
    public InvalidAmountException(String message) {
        super(message);
    }
}

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}
