import java.util.*;
public class APackingRectangles {
    static boolean fxn(long n, long w, long h, long m) {
        long a = m / w;
        long b = m / h;
        if (a == 0 || b == 0) return false;
        return a *b >= n;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long w = sc.nextLong();
        long h = sc.nextLong();
        long n = sc.nextLong();
        long l = 0;
        long r = 1;
        while (!fxn(n, w, h, r)) {
            r *= 2;
        }

        long res = r;
        while (l <= r) {
            long m = l + (r - l) / 2;

            if (fxn(n, w, h, m)) {
                res = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        System.out.println(res);
    }
}