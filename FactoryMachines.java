import java.util.*;
public class FactoryMachines {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long t = sc.nextLong();
        long[] k = new long[n];
        long mint = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            k[i] = sc.nextLong();
            mint = Math.min(mint, k[i]);
        }
        long l = 1;
        long r = mint * t;
        long ans = r;
        while (l <= r) {
            long m = l + (r - l) / 2;
            long total = 0;
            for (int i = 0; i < n; i++) {
                total += m / k[i];
                if (total >= t) break;
            }
            if (total >= t) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        System.out.println(ans);
    }
}