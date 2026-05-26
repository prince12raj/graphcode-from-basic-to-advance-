import java.util.*;
public class CHardProblem{
    static final long INF = (long) 1e18;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] cost = new long[n];
        for (int i = 0; i < n; i++) {
            cost[i] = sc.nextLong();
        }
        String[] in = new String[n];
        String[] rev = new String[n];
        for (int i = 0; i < n; i++) {
            in[i] = sc.next();

            rev[i] = new StringBuilder(in[i])
                    .reverse()
                    .toString();
        }
        long[][] dp = new long[n][2];
        for (int i = 0; i < n; i++) {
            dp[i][0] = INF;
            dp[i][1] = INF;
        }
        dp[0][0] = 0;
        dp[0][1] = cost[0];

        for (int i = 1; i < n; i++) {
            if (in[i].compareTo(in[i - 1]) >= 0) {
                dp[i][0] = Math.min(dp[i][0], dp[i - 1][0]);
            }
            if (in[i].compareTo(rev[i - 1]) >= 0) {
                dp[i][0] = Math.min(dp[i][0], dp[i - 1][1]);
            }
            if (rev[i].compareTo(in[i - 1]) >= 0) {
                dp[i][1] = Math.min(dp[i][1],dp[i - 1][0] + cost[i]);
            }
            if (rev[i].compareTo(rev[i - 1]) >= 0) {
                dp[i][1] = Math.min(dp[i][1],dp[i - 1][1] + cost[i]);
            }
        }
        long ans = Math.min(dp[n - 1][0], dp[n - 1][1]);
        if (ans >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }
}