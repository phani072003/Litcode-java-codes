import java.util.Scanner;

public class ClumsyFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.close();
        System.out.println("Enter a positive integer (N):");
        int N = scanner.nextInt();

        int result = clumsy(N);

        System.out.println("Clumsy Factorial of " + N + " is: " + result);
    }

    public static int clumsy(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;
        if (N == 2) return 2;
        if (N == 3) return 6;
        return N * (N - 1) / (N - 2) + helper(N - 3);
    }

    public static int helper(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;
        if (N == 2) return 1;
        if (N == 3) return 1;
        return N - (N - 1) * (N - 2) / (N - 3) + helper(N - 4);
    }
}
