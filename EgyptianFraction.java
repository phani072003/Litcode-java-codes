import java.util.Scanner;

public class EgyptianFraction {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get input from the user
        System.out.println("Enter the numerator:");
        int numerator = scanner.nextInt();

        System.out.println("Enter the denominator:");
        int denominator = scanner.nextInt();
        scanner.close();
        // Validate input
        if (numerator <= 0 || denominator <= 0) {
            System.out.println("Please enter positive integers for the numerator and denominator.");
            return;
        }

        // Find Egyptian fraction representation
        findEgyptianFraction(numerator, denominator);
    }

    private static void findEgyptianFraction(int numerator, int denominator) {
        System.out.println("Egyptian fraction representation:");

        while (numerator != 0) {
            // Find the largest possible unit fraction
            int unitDenominator = (int) Math.ceil((double) denominator / numerator);

            // Print the unit fraction
            System.out.println(unitDenominator);

            // Update numerator and denominator for the next iteration
            numerator = numerator * unitDenominator - denominator;
            denominator = denominator * unitDenominator;
        }
    }
}
