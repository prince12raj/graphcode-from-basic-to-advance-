import java.util.*;
public class Knapsack2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long w = sc.nextLong();
        int totalprofit = 0;
        int we[] = new int[n + 1];
        int va[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            we[i] = sc.nextInt();
            va[i] = sc.nextInt();
            totalprofit += va[i];
        }
        long dp[][] = new long[n + 1][totalprofit + 1];
        for (long a[] : dp) {
            Arrays.fill(a, (long)1e18);
        }
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int v = 0; v <= totalprofit; v++) {
                dp[i][v] = dp[i - 1][v];
                if (v >= va[i]) {
                    dp[i][v] = Math.min(dp[i][v], dp[i - 1][v - va[i]] + we[i]);
                }
            }
        }
        int ans = 0;
        for (int v = 0; v <= totalprofit; v++) {

            if (dp[n][v] <= w) {
                ans = v;
            }
        }
        System.out.println(ans);
    }
}