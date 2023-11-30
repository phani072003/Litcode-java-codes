import java.util.Scanner;

class SumOfNumbersWithUnitsDigitK {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter num:");
        int num = scanner.nextInt();

        System.out.println("Enter k:");
        int k = scanner.nextInt();
        scanner.close();
        int result = minimumNumbers(num, k);

        System.out.println("Output: " + result);
    }

    public static int minimumNumbers(int num, int k) {
        if (num == 0)
            return 0;
        if (k == 0)
            return (num % 10 == 0) ? 1 : -1;

        for (int i = 1; i <= num / k; i++) {
            if (num % 10 == ((i * k) % 10)) {
                return i;
            }
        }

        return -1;
    }
}
