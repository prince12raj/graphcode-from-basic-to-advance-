import java.util.Scanner;
public class C_k_Tree {
    static final int MOD = 1000000007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        int k = sc.nextInt();
        int d = sc.nextInt();
        long totalWays = countWays(n, k);
        long invalidWays = countWays(n, d - 1);
        long result = (totalWays - invalidWays + MOD) % MOD;
        System.out.println(result);
    }
    private static long countWays(int target, int limit) {
        if (limit <= 0 && target > 0) return 0;
        if (target == 0) return 1;

        long[] dp = new long[target + 1];
        dp[0] = 1;

        for (int i = 1; i <= target; i++) {
            for (int w = 1; w <= limit && w <= i; w++) {
                dp[i] = (dp[i] + dp[i - w]) % MOD;
            }
        }
        return dp[target];
    }
}