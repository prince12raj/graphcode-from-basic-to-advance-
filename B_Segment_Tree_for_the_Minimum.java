import java.util.*;

public class B_Segment_Tree_for_the_Minimum {
    static int[] seg;
    static int n;
    static void build(int idx, int l, int r, int[] arr) {
        if (l == r) {
            seg[idx] = arr[l];
            return;
        }
        int mid = (l + r) / 2;
        build(2 * idx + 1, l, mid, arr);
        build(2 * idx + 2, mid + 1, r, arr);
        seg[idx] = Math.min(seg[2 * idx + 1], seg[2 * idx + 2]);
    }
    static void update(int idx, int l, int r, int pos, int val) {
        if (l == r) {
            seg[idx] = val;
            return;
        }
        int mid = (l + r) / 2;
        if (pos <= mid)
            update(2 * idx + 1, l, mid, pos, val);
        else
            update(2 * idx + 2, mid + 1, r, pos, val);

        seg[idx] = Math.min(seg[2 * idx + 1], seg[2 * idx + 2]);
    }
    static int query(int idx, int l, int r, int ql, int qr) {
        if (r < ql || l > qr) return Integer.MAX_VALUE;
        if (ql <= l && r <= qr) return seg[idx]; 
        int mid = (l + r) / 2;
        int left = query(2 * idx + 1, l, mid, ql, qr);
        int right = query(2 * idx + 2, mid + 1, r, ql, qr);

        return Math.min(left, right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        seg = new int[4 * n];
        build(0, 0, n - 1, arr);

        while (m-- > 0) {
            int type = sc.nextInt();
            if (type == 1) {
                int i = sc.nextInt();
                int v = sc.nextInt();
                update(0, 0, n - 1, i, v);
            } else {
                int l = sc.nextInt();
                int r = sc.nextInt();
                System.out.println(query(0, 0, n - 1, l, r - 1));
            }
        }

        sc.close();
    }
}