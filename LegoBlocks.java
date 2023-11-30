import java.util.Scanner;

class Result {

    static final long MOD = 1000000007;

    public static int legoBlocks(int n, int m) {
        if (n < 2 || m < 1) return 0;
        if (m == 1) return 1;

        long[] total = new long[m + 1];
        for (int i = 0; i < total.length; i++)
            total[i] = -1;

        fillTot(total, m);

        for (int i = 0; i < total.length; i++) {
            long tmp = 1;
            for (int j = 0; j < n; j++) {
                tmp = (tmp * total[i]) % MOD;
            }
            total[i] = tmp;
        }

        long[] result = new long[m + 1];
        for (int i = 0; i < result.length; i++)
            result[i] = -1;

        getResult(total, result, m);

        return (int) (result[m] % MOD);
    }

    static long getResult(long[] total, long[] result, int i) {
        if (result[i] == -1) {
            if (i == 1) {
                result[i] = 1;
            } else {
                result[i] = total[i];
                for (int j = 1; j < i; j++) {
                    result[i] -= (getResult(total, result, j) * total[i - j]) % MOD;
                }
            }
        }
        return result[i];
    }

    static long fillTot(long[] total, int i) {
        if (i < 0) return 0;

        if (total[i] == -1) {
            if (i == 0 || i == 1)
                total[i] = 1;
            else
                total[i] = (fillTot(total, i - 1) + fillTot(total, i - 2) + fillTot(total, i - 3) + fillTot(total, i - 4)) % MOD;
        }

        return total[i];
    }
}

public class LegoBlocks {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the height 'n' of the wall:");
        int n = scanner.nextInt();

        System.out.println("Enter the width 'm' of the wall:");
        int m = scanner.nextInt();
        scanner.close();
        int result = Result.legoBlocks(n, m);
        System.out.println("Number of ways to build the wall: " + result);
    }
}
