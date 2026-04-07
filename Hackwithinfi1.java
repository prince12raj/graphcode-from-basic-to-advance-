import java.util.*;

public class Hackwithinfi1 {
    static class Node {
        long a, d;
        Node() {
            a = 0;
            d = 0;
        }
    }
    static int n, q;
    static long[] seg;
    static Node[] lazy;
    static long MOD = 1000000007;
    static void build(int idx, int l, int r, long[] arr) {
        if (l == r) {
            seg[idx] = arr[l] % MOD;
            return;
        }
        int mid = (l + r) / 2;
        build(2 * idx, l, mid, arr);
        build(2 * idx + 1, mid + 1, r, arr);
        seg[idx] = (seg[2 * idx] + seg[2 * idx + 1]) % MOD;
    }
    static void push(int idx, int l, int r) {
        if (lazy[idx].a == 0 && lazy[idx].d == 0) return;

        int len = r - l + 1;

        long sum = (len * (2 * lazy[idx].a % MOD + (len - 1) * lazy[idx].d % MOD) % MOD) % MOD;
        sum = (sum * modInverse(2)) % MOD;

        seg[idx] = sum;

        if (l != r) {
            int mid = (l + r) / 2;
            lazy[2 * idx].a = lazy[idx].a;
            lazy[2 * idx].d = lazy[idx].d;
            long nextA = (lazy[idx].a + (mid - l + 1) * lazy[idx].d) % MOD;
            lazy[2 * idx + 1].a = nextA;
            lazy[2 * idx + 1].d = lazy[idx].d;
        }

        lazy[idx].a = 0;
        lazy[idx].d = 0;
    }
    static void update(int idx, int l, int r, int ql, int qr, long base) {
        push(idx, l, r);

        if (r < ql || l > qr) return;

        if (ql <= l && r <= qr) {
            long startVal = (l - ql + 1) % MOD;

            lazy[idx].a = (startVal * base) % MOD;
            lazy[idx].d = base % MOD;

            push(idx, l, r);
            return;
        }

        int mid = (l + r) / 2;
        update(2 * idx, l, mid, ql, qr, base);
        update(2 * idx + 1, mid + 1, r, ql, qr, base);

        seg[idx] = (seg[2 * idx] + seg[2 * idx + 1]) % MOD;
    }
    static long query(int idx, int l, int r, int ql, int qr) {
        push(idx, l, r);

        if (r < ql || l > qr) return 0;

        if (ql <= l && r <= qr) return seg[idx];

        int mid = (l + r) / 2;

        return (query(2 * idx, l, mid, ql, qr)
              + query(2 * idx + 1, mid + 1, r, ql, qr)) % MOD;
    }
    static long power(long a, long b) {
        long res = 1;
        a %= MOD;
        while (b > 0) {
            if ((b & 1) == 1) res = (res * a) % MOD;
            a = (a * a) % MOD;
            b >>= 1;
        }
        return res;
    }
    static long modInverse(long x) {
        return power(x, MOD - 2);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        seg = new long[4 * n];
        lazy = new Node[4 * n];
        for (int i = 0; i < 4 * n; i++) lazy[i] = new Node();

        build(1, 0, n - 1, arr);

        q = sc.nextInt();

        long answer = 0;

        while (q-- > 0) {
            int type = sc.nextInt();
            int l = sc.nextInt();
            int r = sc.nextInt();

            if (type == 1) {
                long base = query(1, 0, n - 1, l, l); // A[l]
                update(1, 0, n - 1, l, r, base);
            } else {
                long res = query(1, 0, n - 1, l, r);
                answer = (answer + res) % MOD;
            }
        }
        System.out.println(answer);
        sc.close();
    }
}