import java.util.*;
public class A_Segment_Tree_for_the_Sum {
    static long[] seg;
    static long[] arr;
    static void build(int idx, int l, int r) {
        if (l == r) {
            seg[idx] = arr[l];
            return;
        }
        int mid = (l + r) / 2;
        build(2 * idx, l, mid);
        build(2 * idx + 1, mid + 1, r);
        seg[idx] = seg[2 * idx] + seg[2 * idx + 1];
    }
    static void update(int idx, int l, int r, int pos, long val) {
        if (l == r) {
            seg[idx] = val;
            return;
        }
        int mid = (l + r) / 2;
        if (pos <= mid)
            update(2 * idx, l, mid, pos, val);
        else
            update(2 * idx + 1, mid + 1, r, pos, val);

        seg[idx] = seg[2 * idx] + seg[2 * idx + 1];
    }
    static long query(int idx, int l, int r, int ql, int qr) {
        if (qr < l || r < ql)
            return 0;
        if (ql <= l && r <= qr)
            return seg[idx];

        int mid = (l + r) / 2;
        return query(2 * idx, l, mid, ql, qr)+ query(2 * idx + 1, mid + 1, r, ql, qr);
   }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        arr = new long[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextLong();
        seg = new long[4 * n];
        build(1, 0, n - 1);

        while (m-- > 0) {
            int type = sc.nextInt();

            if (type == 1) {
                int i = sc.nextInt();
                long v = sc.nextLong();
                update(1, 0, n - 1, i, v);
            } else {
                int l = sc.nextInt();
                int r = sc.nextInt();
                System.out.println(query(1, 0, n - 1, l, r - 1));
            }
        }
    }
}