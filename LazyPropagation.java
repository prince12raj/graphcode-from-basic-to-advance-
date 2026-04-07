import java.util.*;
public class LazyPropagation {
    static int arr[], seg[], lazy[];
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        seg = new int[4 * n];
        lazy = new int[4 * n];
        buildTree(0, 0, n - 1);
        int q = sc.nextInt();
        while (q-- > 0) {
            int type = sc.nextInt();
            if (type == 1) {
                int l = sc.nextInt();
                int r = sc.nextInt();
                int val = sc.nextInt();
                update(0, 0, n - 1, l, r, val);
            } else {
                int l = sc.nextInt();
                int r = sc.nextInt();
                System.out.println(query(0, 0, n - 1, l, r));
            }
        }
            for(int a : seg){
            System.out.print(a + " ");
        }
        System.out.println();
        for(int a : lazy){
            System.out.print(a + " ");
        }
    }
    static void buildTree(int idx, int l, int r) {
        if (l == r) {
            seg[idx] = arr[l];
            return;
        }
        int mid = l + (r - l) / 2;
        buildTree(2 * idx + 1, l, mid);
        buildTree(2 * idx + 2, mid + 1, r);
        seg[idx] = seg[2 * idx + 1] + seg[2 * idx + 2];
    }
    static void update(int idx, int l, int r, int ql, int qr, int val) {
        if (lazy[idx] != 0) {
            seg[idx] += (r - l + 1) * lazy[idx];
            if (l != r) {
                lazy[2 * idx + 1] += lazy[idx];
                lazy[2 * idx + 2] += lazy[idx];
            }
            lazy[idx] = 0;
        }
        //outside
        if (r < ql || l > qr) return;
        //inside
        if (ql <= l && r <= qr) {
            seg[idx] += (r - l + 1) * val;
            if (l != r) {
                lazy[2 * idx + 1] += val;
                lazy[2 * idx + 2] += val;
            }
            return;
        }
        //overlap
        int mid = l + (r - l) / 2;
        update(2 * idx + 1, l, mid, ql, qr, val);
        update(2 * idx + 2, mid + 1, r, ql, qr, val);
        seg[idx] = seg[2 * idx + 1] + seg[2 * idx + 2];
    }
    static int query(int idx, int l, int r, int ql, int qr) {
        if (lazy[idx] != 0) {
            seg[idx] += (r - l + 1) * lazy[idx];
            if (l != r) {
                lazy[2 * idx + 1] += lazy[idx];
                lazy[2 * idx + 2] += lazy[idx];
            }
            lazy[idx] = 0;
        }
        //outside
        if (r < ql || l > qr) return 0;
        //inside
        if (ql <= l && r <= qr) return seg[idx];
        //overlap
        int mid = l + (r - l) / 2;
        int left = query(2 * idx + 1, l, mid, ql, qr);
        int right = query(2 * idx + 2, mid + 1, r, ql, qr);
        return left + right;
    }
}
