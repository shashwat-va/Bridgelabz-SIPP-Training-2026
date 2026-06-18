import java.util.Scanner;

/**
 * Program to display vowel/consonant/not a letter classification for each character.
 */
public class VowelConsonantTable {
    public static String getCharacterType(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32);
        }
        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            }
            return "Consonant";
        }
        return "Not a Letter";
    }

    public static String[][] classifyCharacters(String text) {
        String[][] result = new String[text.length()][2];
        for (int i = 0; i < text.length(); i++) {
            result[i][0] = String.valueOf(text.charAt(i));
            result[i][1] = getCharacterType(text.charAt(i));
        }
        return result;
    }

    public static void displayTable(String[][] table) {
        System.out.printf("%-10s %s\n", "Character", "Type");
        System.out.println("----------------");
        for (String[] row : table) {
            System.out.printf("%-10s %s\n", row[0], row[1]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Vowel and Consonant Table Program ===");
        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        String[][] table = classifyCharacters(text);
        displayTable(table);
        scanner.close();
    }
}
