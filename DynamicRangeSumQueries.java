// import java.util.*;
// public class DynamicRangeSumQueries {
//     static class Segment {
//         static long arr[];
//         static long seg[];
//         Segment(int n) {
//             arr = new long[n];
//             seg = new long[4 * n];
//         }
//         static void segbuild(int idx, int l, int r) {
//             if (l == r) {
//                 seg[idx] = arr[l];
//                 return;
//             }
//             int mid = l + (r - l) / 2;
//             segbuild(2 * idx + 1, l, mid);
//             segbuild(2 * idx + 2, mid + 1, r);
//             seg[idx] = seg[2 * idx + 1] + seg[2 * idx + 2];
//         }
//         static long query(int idx, int l, int r, int ql, int qr) {
//             if (r < ql || l > qr) return 0;

//             if (ql <= l && r <= qr) return seg[idx];

//             int mid = l + (r - l) / 2;
//             long left = query(2 * idx + 1, l, mid, ql, qr);
//             long right = query(2 * idx + 2, mid + 1, r, ql, qr);

//             return left + right;
//         }
//         static void update(int idx, int l, int r, int i, long val) {
//             if (l == r) {
//                 seg[idx] = val;
//                 return;
//             }
//             int mid = l + (r - l) / 2;
//             if (i <= mid) {
//                 update(2 * idx + 1, l, mid, i, val);
//             } else {
//                 update(2 * idx + 2, mid + 1, r, i, val);
//             }
//             seg[idx] = seg[2 * idx + 1] + seg[2 * idx + 2];
//         }
//     }

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int q = sc.nextInt();
//         Segment segm = new Segment(n);
//         for (int i = 0; i < n; i++) {
//             Segment.arr[i] = sc.nextLong();
//         }
//         Segment.segbuild(0, 0, n - 1);
//         while (q-- > 0) {
//             int type = sc.nextInt();
//             if (type == 1) {
//                 int k = sc.nextInt();
//                 long u = sc.nextLong();
//                 k--;
//                 Segment.update(0, 0, n - 1, k, u);
//             } else {
//                 int a = sc.nextInt();
//                 int b = sc.nextInt();
//                 a--; b--;
//                 long ans = Segment.query(0, 0, n - 1, a, b);
//                 System.out.println(ans);
//             }
//         }
//     }
// }
import java.io.*;
import java.util.*;
public class DynamicRangeSumQueries {
    static class Segment {
        static long arr[];
        static long seg[];
        Segment(int n) {
            arr = new long[n];
            seg = new long[4 * n];
        }
        static void segbuild(int idx, int l, int r) {
            if (l == r) {
                seg[idx] = arr[l];
                return;
            }
            int mid = l + (r - l) / 2;
            segbuild(2 * idx + 1, l, mid);
            segbuild(2 * idx + 2, mid + 1, r);
            seg[idx] = seg[2 * idx + 1] + seg[2 * idx + 2];
        }
        static long query(int idx, int l, int r, int ql, int qr) {
            if (r < ql || l > qr) return 0;
            if (ql <= l && r <= qr) return seg[idx];
            int mid = l + (r - l) / 2;
            long left = query(2 * idx + 1, l, mid, ql, qr);
            long right = query(2 * idx + 2, mid + 1, r, ql, qr);
            return left + right;
        }
        static void update(int idx, int l, int r, int i, long val) {
            if (l == r) {
                seg[idx] = val;
                return;
            }
            int mid = l + (r - l) / 2;
            if (i <= mid) {
                update(2 * idx + 1, l, mid, i, val);
            } else {
                update(2 * idx + 2, mid + 1, r, i, val);
            }
            seg[idx] = seg[2 * idx + 1] + seg[2 * idx + 2];
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        Segment segm = new Segment(n);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            Segment.arr[i] = Long.parseLong(st.nextToken());
        }

        Segment.segbuild(0, 0, n - 1);

        StringBuilder sb = new StringBuilder();

        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());

            int type = Integer.parseInt(st.nextToken());

            if (type == 1) {
                int k = Integer.parseInt(st.nextToken()) - 1;
                long u = Long.parseLong(st.nextToken());
                Segment.update(0, 0, n - 1, k, u);
            } else {
                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;
                sb.append(Segment.query(0, 0, n - 1, a, b)).append("\n");
            }
        }

        System.out.print(sb);
    }
}