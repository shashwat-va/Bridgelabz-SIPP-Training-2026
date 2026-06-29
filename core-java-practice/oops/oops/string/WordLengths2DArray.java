import java.util.Scanner;

/**
 * Program to split text into words and return words with their lengths in a 2D array.
 */
public class WordLengths2DArray {
    public static int getStringLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            return count;
        }
    }

    public static String[] splitUsingCharAt(String text) {
        int length = getStringLength(text);
        int wordCount = 0;
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                wordCount++;
            }
        }
        wordCount++;

        int[] spaceIndexes = new int[wordCount + 1];
        spaceIndexes[0] = -1;
        int index = 1;
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndexes[index++] = i;
            }
        }
        spaceIndexes[index] = length;

        String[] words = new String[wordCount];
        for (int w = 0; w < wordCount; w++) {
            int start = spaceIndexes[w] + 1;
            int end = spaceIndexes[w + 1];
            String word = "";
            for (int j = start; j < end; j++) {
                word += text.charAt(j);
            }
            words[w] = word;
        }
        return words;
    }

    public static String[][] wordsWithLengths(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(getStringLength(words[i]));
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Word Lengths 2D Array Program ===");
        System.out.print("Enter text: ");
        String text = scanner.nextLine().trim();

        String[] words = splitUsingCharAt(text);
        String[][] table = wordsWithLengths(words);

        System.out.printf("%-20s %s\n", "Word", "Length");
        System.out.println("------------------------------");
        for (String[] row : table) {
            System.out.printf("%-20s %s\n", row[0], row[1]);
        }
        scanner.close();
    }
}
