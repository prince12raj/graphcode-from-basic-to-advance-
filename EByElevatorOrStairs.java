// import java.util.*;
// public class EByElevatorOrStairs {
//     static int n, c;
//     static long[] a, b;
//     static long solve(int i, int j) {
//         if (i == 1) {
//             if (j == 0)
//                 return 0; 
//             return c;
//         }
//         if (j == 0) {
//             return Math.min(
//                     solve(i - 1, 0) + a[i - 1],
//                     solve(i - 1, 1) + a[i - 1]
//             );
//         }
//         return Math.min(
//                 solve(i - 1, 1) + b[i - 1],
//                 solve(i - 1, 0) + c + b[i - 1]
//         );
//     }
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         n = sc.nextInt();
//         c = sc.nextInt();
//         a = new long[n];
//         b = new long[n];
//         for (int i = 1; i < n; i++) {
//             a[i] = sc.nextLong();
//         }
//         for (int i = 1; i < n; i++) {
//             b[i] = sc.nextLong();
//         }
//         for (int i = 1; i <= n; i++) {
//             long ans = Math.min(
//                     solve(i, 0),
//                     solve(i, 1)
//             );
//             System.out.print(ans + " ");
//         }
//     }
// }
import java.util.*;
public class EByElevatorOrStairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        long[] a = new long[n];
        long[] b = new long[n];
        for (int i = 1; i < n; i++) {
            a[i] = sc.nextLong();
        }
        for (int i = 1; i < n; i++) {
            b[i] = sc.nextLong();
        }
        long[][] dp = new long[n + 1][2];
        dp[1][0] = 0;
        dp[1][1] = c;
        for (int i = 2; i <= n; i++) {
            dp[i][0] = Math.min(dp[i - 1][0] + a[i - 1],dp[i - 1][1] + a[i - 1]);
            dp[i][1] = Math.min(dp[i - 1][1] + b[i - 1],dp[i - 1][0] + c + b[i - 1]);
        }
        for (int i = 1; i <= n; i++) {
            long ans = Math.min(dp[i][0], dp[i][1]);
            System.out.print(ans + " ");
        }
    }
}