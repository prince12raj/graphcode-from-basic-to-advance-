// import java.util.*;
// public class DynamicRangeMinimumQueries {
//     static int arr[], seg[];
//     static int n;
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         n = sc.nextInt();
//         int q = sc.nextInt();
//         arr = new int[n];
//         for (int i = 0; i < n; i++) {
//             arr[i] = sc.nextInt();
//         }
//         seg = new int[4 * n];
//         buildTree(0, 0, n - 1);
//         while (q-- > 0) {
//             int type = sc.nextInt();

//             if (type == 1) {
//                 int pos = sc.nextInt() - 1;
//                 int val = sc.nextInt();
//                 update(0, 0, n - 1, pos, val);
//             } else {
//                 int l = sc.nextInt() - 1;
//                 int r = sc.nextInt() - 1;
//                 System.out.println(query(0, 0, n - 1, l, r));
//             }
//         }
//     }
//     static void buildTree(int idx, int l, int r) {
//         if (l == r) {
//             seg[idx] = arr[l];
//             return;
//         }
//         int mid = (l + r) / 2;
//         buildTree(2 * idx + 1, l, mid);
//         buildTree(2 * idx + 2, mid + 1, r);
//         seg[idx] = Math.min(seg[2 * idx + 1], seg[2 * idx + 2]);
//     }
//     static int query(int idx, int l, int r, int ql, int qr) {
//         if (r < ql || l > qr) return Integer.MAX_VALUE;
//         if (ql <= l && r <= qr) return seg[idx];
//         int mid = (l + r) / 2;
//         int left = query(2 * idx + 1, l, mid, ql, qr);
//         int right = query(2 * idx + 2, mid + 1, r, ql, qr);
//         return Math.min(left, right);
//     }
//     static void update(int idx, int l, int r, int pos, int val) {
//         if (l == r) {
//             seg[idx] = val;
//             return;
//         }
//         int mid = (l + r) / 2;
//         if (pos <= mid) {
//             update(2 * idx + 1, l, mid, pos, val);
//         } else {
//             update(2 * idx + 2, mid + 1, r, pos, val);
//         }
//         seg[idx] = Math.min(seg[2 * idx + 1], seg[2 * idx + 2]);
//     }
// }
import java.io.*;
import java.util.*;
public class DynamicRangeMinimumQueries {
    static int arr[], seg[];
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        arr = new int[n];
        seg = new int[4 * n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        buildTree(0, 0, n - 1);

        StringBuilder sb = new StringBuilder();

        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());

            if (type == 1) {
                int pos = Integer.parseInt(st.nextToken()) - 1;
                int val = Integer.parseInt(st.nextToken());
                update(0, 0, n - 1, pos, val);
            } else {
                int l = Integer.parseInt(st.nextToken()) - 1;
                int r = Integer.parseInt(st.nextToken()) - 1;
                sb.append(query(0, 0, n - 1, l, r)).append('\n');
            }
        }

        System.out.print(sb.toString());
    }

    static void buildTree(int idx, int l, int r) {
        if (l == r) {
            seg[idx] = arr[l];
            return;
        }
        int mid = (l + r) / 2;
        buildTree(2 * idx + 1, l, mid);
        buildTree(2 * idx + 2, mid + 1, r);
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

    static void update(int idx, int l, int r, int pos, int val) {
        if (l == r) {
            seg[idx] = val;
            return;
        }
        int mid = (l + r) / 2;

        if (pos <= mid) {
            update(2 * idx + 1, l, mid, pos, val);
        } else {
            update(2 * idx + 2, mid + 1, r, pos, val);
        }

        seg[idx] = Math.min(seg[2 * idx + 1], seg[2 * idx + 2]);
    }
}