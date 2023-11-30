import java.util.*;

public class ArrayManipulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the array size:");
        int arraySize = scanner.nextInt();
        int[] array = new int[arraySize];

        System.out.println("Enter the number of queries:");
        int numQueries = scanner.nextInt();

        System.out.println("Enter the queries (each query in the format: start end value):");
        for (int i = 0; i < numQueries; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            int value = scanner.nextInt();
            performOperation(array, start, end, value);
        }
        scanner.close();
        int result = findMaxValue(array);
        System.out.println("Maximum value in the array after operations: " + result);
    }

    public static void performOperation(int[] array, int start, int end, int value) {
        array[start - 1] += value;
        if (end < array.length) {
            array[end] -= value;
        }
    }

    public static int findMaxValue(int[] array) {
        int max = 0;
        int sum = 0;
        for (int i : array) {
            sum += i;
            max = Math.max(max, sum);
        }
        return max;
    }
}
