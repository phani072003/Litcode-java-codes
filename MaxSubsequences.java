import java.util.Scanner;

public class MaxSubsequences {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: original text
        System.out.print("Enter the original text: ");
        String text = scanner.next();

        // Input: pattern
        System.out.print("Enter the pattern: ");
        String pattern = scanner.next();

        // Output: Maximum number of occurrences
        long result = maximumSubsequenceCount(text, pattern);
        System.out.println("Output: " + result);

        scanner.close();
    }

    public static long maximumSubsequenceCount(String text, String pattern) {
        long result = 0, first = 0, second = 0;

        for (int i = 0; i < text.length(); ++i) {
            if (text.charAt(i) == pattern.charAt(1)) {
                result += first;
                second++;
            }

            if (text.charAt(i) == pattern.charAt(0))
                first++;
        }

        return result + Math.max(first, second);
    }
}
