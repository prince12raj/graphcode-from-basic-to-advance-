import java.util.*;
public class CTheValuesYouCanMake {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] coin = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            coin[i] = sc.nextInt();
        }
        boolean[][][] dp = new boolean[n + 1][k + 1][k + 1];
        dp[0][0][0] = true;
        for (int i = 1; i <= n; i++) {
            int c = coin[i];
            for (int j = 0; j <= k; j++) {
                for (int x = 0; x <= k; x++) {
                    if (dp[i - 1][j][x]) {
                        dp[i][j][x] = true;
                    }
                    if (j >= c && dp[i - 1][j - c][x]) {
                        dp[i][j][x] = true;
                    }
                    if (j >= c && x >= c && dp[i - 1][j - c][x - c]) {
                        dp[i][j][x] = true;
                    }
                }
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int x = 0; x <= k; x++) {
            if (dp[n][k][x]) {
                ans.add(x);
            }
        }
        System.out.println(ans.size());

        for (int v : ans) {
            System.out.print(v + " ");
        }
    }
}