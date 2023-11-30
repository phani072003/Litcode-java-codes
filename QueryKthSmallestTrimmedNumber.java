import java.util.*;
public class QueryKthSmallestTrimmedNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the numbers (separated by spaces):");
        String[] nums = scanner.nextLine().split(" ");
        System.out.println("Enter the number of queries:");
        int numQueries = scanner.nextInt();
        int[][] queries = new int[numQueries][2];
        System.out.println("Enter the queries (each query in the format: position trim):");
        for (int i = 0; i < numQueries; i++) {
            queries[i][0] = scanner.nextInt();
            queries[i][1] = scanner.nextInt();
        }
        int[] result = queryKthSmallestTrimmedNumber(nums, queries);

        System.out.println("Result:");
        for (int i : result) {
            System.out.print(i + " ");
        }
        scanner.close();
    }
    public static int[] queryKthSmallestTrimmedNumber(String[] nums, int[][] queries) {
        HashMap<Integer, Node[]> map = new HashMap<>();
        int[] res = new int[queries.length];
        int idx = 0, len = nums[0].length();
        for (int[] query : queries) {
            if (!map.containsKey(query[1])) {
                Node[] arr = new Node[nums.length];
                for (int i = 0; i < nums.length; i++) {
                    String trimmed = nums[i].substring(len - query[1]);
                    arr[i] = new Node(i, trimmed);
                }
                Arrays.sort(arr, Comparator.comparing(a -> a.val));
                map.put(query[1], arr);
            }
            res[idx++] = map.get(query[1])[query[0] - 1].index;
        }

        return res;
    }
    static class Node {
        int index;
        String val;

        Node(int i, String v) {
            this.index = i;
            this.val = v;
        }
    }
}
