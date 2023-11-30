import java.util.Scanner;
import java.util.Arrays;

public class SlidingSubarrayBeauty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputArray = scanner.nextLine().split(" ");
        int[] arr = Arrays.stream(inputArray).mapToInt(Integer::parseInt).toArray();
        int k = scanner.nextInt();
        int n = scanner.nextInt();
        int[] result = calculateBeauty(arr, k, n);
        for (int num : result) {
            System.out.print(num + " ");
        }
        scanner.close();
    }
    private static int[] calculateBeauty(int[] arr, int k, int n) {
        int[] beautyArray = new int[arr.length - k + 1];
        for (int i = 0; i <= arr.length - k; i++) {     
            int[] subArray = Arrays.copyOfRange(arr, i, i + k);
            Arrays.sort(subArray);
            int nthSmallest = subArray[n - 1];
            beautyArray[i] = nthSmallest;
        }
        return beautyArray;
    }
}
