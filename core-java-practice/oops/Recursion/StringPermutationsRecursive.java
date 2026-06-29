import java.util.Scanner;

public class StringPermutationsRecursive {
    public static void generatePermutations(String input, String current, boolean[] used) {
        if (current.length() == input.length()) {
            System.out.println(current);
            return;
        }

        for (int i = 0; i < input.length(); i++) {
            if (!used[i]) {
                used[i] = true;
                generatePermutations(input, current + input.charAt(i), used);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        generatePermutations(input, "", new boolean[input.length()]);
        scanner.close();
    }
}
