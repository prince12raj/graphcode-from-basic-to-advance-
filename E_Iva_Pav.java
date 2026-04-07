import java.util.*;
public class E_Iva_Pav {
    static int[] seg;
    static int n;
    static void build(int[] arr, int idx, int l, int r) {
        if (l == r) {
            seg[idx] = arr[l];
            return;
        }
        int mid = (l + r) / 2;
        build(arr, 2 * idx, l, mid);
        build(arr, 2 * idx + 1, mid + 1, r);
        seg[idx] = seg[2 * idx] & seg[2 * idx + 1];
    }
    static int query(int idx, int l, int r, int ql, int qr) {
    if (qr < l || r < ql) return Integer.MAX_VALUE;
    if (ql <= l && r <= qr) return seg[idx];
    int mid = (l + r) / 2;
    return query(2 * idx, l, mid, ql, qr) & 
           query(2 * idx + 1, mid + 1, r, ql, qr);
}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            seg = new int[4 * n];
            build(arr, 1, 0, n - 1);
            int q = sc.nextInt();
            while (q-- > 0) {
                int ql = sc.nextInt() - 1;
                int k = sc.nextInt();
                int low = ql, high = n - 1;
                int ans = -1;
                while (low <= high) {
                    int mid = (low + high) / 2;
                    int val = query(1, 0, n - 1, ql, mid);
                    if (val >= k) {
                        ans = mid;
                        low = mid + 1; 
                    } else {
                        high = mid - 1;
                    }
                }
                if (ans == -1) System.out.print("-1 ");
                else System.out.print((ans + 1) + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}