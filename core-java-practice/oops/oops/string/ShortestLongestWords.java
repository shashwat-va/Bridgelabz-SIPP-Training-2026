import java.util.Scanner;

/**
 * Program to split text into words and find shortest and longest words.
 */
public class ShortestLongestWords {
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

    public static int[] findShortestAndLongest(String[][] wordLengths) {
        int shortestIndex = 0;
        int longestIndex = 0;
        int shortestLen = Integer.parseInt(wordLengths[0][1]);
        int longestLen = Integer.parseInt(wordLengths[0][1]);

        for (int i = 1; i < wordLengths.length; i++) {
            int length = Integer.parseInt(wordLengths[i][1]);
            if (length < shortestLen) {
                shortestLen = length;
                shortestIndex = i;
            }
            if (length > longestLen) {
                longestLen = length;
                longestIndex = i;
            }
        }
        return new int[] { shortestIndex, longestIndex };
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Shortest and Longest Words Program ===");
        System.out.print("Enter text: ");
        String text = scanner.nextLine().trim();

        String[] words = splitUsingCharAt(text);
        String[][] table = wordsWithLengths(words);
        int[] result = findShortestAndLongest(table);

        System.out.printf("%-20s %s\n", "Word", "Length");
        System.out.println("------------------------------");
        for (String[] row : table) {
            System.out.printf("%-20s %s\n", row[0], row[1]);
        }

        System.out.println("\nShortest word: " + table[result[0]][0] + " (" + table[result[0]][1] + ")");
        System.out.println("Longest word: " + table[result[1]][0] + " (" + table[result[1]][1] + ")");
        scanner.close();
    }
}
