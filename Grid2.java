import java.util.*;
public class Grid2 {
    static final int MOD = 1000000007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int grid[][] = new int[n][m];
        while (k-- > 0) {
            int i = sc.nextInt();
            int j = sc.nextInt();

            grid[i][j] = 1;
        }

        long dp[][] = new long[n][m];
        if (grid[0][0] == 0) {
            dp[0][0] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i > 0) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j]) % MOD;
                }
                if (j > 0) {
                    dp[i][j] = (dp[i][j] + dp[i][j - 1]) % MOD;
                }
            }
        }

        System.out.println(dp[n - 1][m - 1]);
    }
}