import java.util.Scanner;

public class PrintNumbersRecursive {
    public static void printNumbers(int n) {
        if (n <= 0) {
            return;
        }
        System.out.print(n + " ");
        printNumbers(n - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter N: ");
        int n = scanner.nextInt();

        printNumbers(n);
        System.out.println();
        scanner.close();
    }
}
