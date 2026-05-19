// import java.util.*;
// public class Grid1 {
//     static final int MOD = 1000000007;
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int m = sc.nextInt();

//         char[][] grid = new char[n][m];
//         for (int i = 0; i < n; i++) {
//             String s = sc.next();
//             for (int j = 0; j < m; j++) {
//                 grid[i][j] = s.charAt(j);
//             }
//         }
//         System.out.println(solve(0, 0, grid));
//     }
//     static int solve(int i, int j, char[][] grid) {
//         if (i >= grid.length || j >= grid[0].length) {
//             return 0;
//         }
//         if (grid[i][j] == '#') {
//             return 0;
//         }
//         if (i == grid.length - 1 && j == grid[0].length - 1) {
//             return 1;
//         }
//         int down = solve(i + 1, j, grid);
//         int right = solve(i, j + 1, grid);
//         return (down%MOD + right%MOD) % MOD;
//     }
// }
import java.util.*;
public class Grid1 {
    static final int MOD = 1000000007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < m; j++) {
                grid[i][j] = s.charAt(j);
            }
        }
        long[][] dp = new long[n][m];
        if (grid[0][0] == '.') {
            dp[0][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '#') {
                    dp[i][j] = 0;
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