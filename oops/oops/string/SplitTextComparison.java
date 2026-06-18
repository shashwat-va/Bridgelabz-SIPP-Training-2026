import java.util.Scanner;

/**
 * Program to split text into words without split() and compare with built-in split().
 */
public class SplitTextComparison {
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
        wordCount = wordCount + 1;

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

    public static boolean compareStringArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Split Text Comparison Program ===");
        System.out.print("Enter text: ");
        String text = scanner.nextLine().trim();

        String[] builtInWords = text.split(" ");
        String[] customWords = splitUsingCharAt(text);

        System.out.println("\nBuilt-in split() result:");
        for (String word : builtInWords) {
            System.out.println(word);
        }

        System.out.println("\nCustom splitUsingCharAt() result:");
        for (String word : customWords) {
            System.out.println(word);
        }

        System.out.println("\nResults match: " + compareStringArrays(customWords, builtInWords));
        scanner.close();
    }
}
