// import java.util.*;
// public class StaticRangeMinimumQueries {
//     static class SEGMENT {
//         int[] arr;
//         int[] seg;
//         SEGMENT(int n) {
//             arr = new int[n];
//             seg = new int[4 * n];
//         }
//         void build(int idx, int l, int r) {
//             if (l == r) {
//                 seg[idx] = arr[l];
//                 return;
//             }

//             int mid = l + (r - l) / 2;
//             build(2 * idx + 1, l, mid);
//             build(2 * idx + 2, mid + 1, r);

//             seg[idx] = Math.min(seg[2 * idx + 1], seg[2 * idx + 2]);
//         }

//         int query(int idx, int l, int r, int ql, int qr) {
//             if (r < ql || l > qr) return Integer.MAX_VALUE;
//             if (ql <= l && r <= qr) return seg[idx];

//             int mid = l + (r - l) / 2;

//             int left = query(2 * idx + 1, l, mid, ql, qr);
//             int right = query(2 * idx + 2, mid + 1, r, ql, qr);

//             return Math.min(left, right);
//         }
//     }

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);

//         int n = sc.nextInt();
//         int q = sc.nextInt();

//         SEGMENT segTree = new SEGMENT(n);
//         for (int i = 0; i < n; i++) {
//             segTree.arr[i] = sc.nextInt();
//         }
//         segTree.build(0, 0, n - 1);
//         while (q-- > 0) {
//             int a = sc.nextInt() - 1; 
//             int b = sc.nextInt() - 1; 

//             System.out.println(segTree.query(0, 0, n - 1, a, b));
//         }

//         sc.close();
//     }
// }
import java.io.*;
import java.util.*;
public class StaticRangeMinimumQueries {
    static class SEGMENT {
        int[] arr;
        int[] seg;
        SEGMENT(int n) {
            arr = new int[n];
            seg = new int[4 * n];
        }
        void build(int idx, int l, int r) {
            if (l == r) {
                seg[idx] = arr[l];
                return;
            }

            int mid = l + (r - l) / 2;
            build(2 * idx + 1, l, mid);
            build(2 * idx + 2, mid + 1, r);

            seg[idx] = Math.min(seg[2 * idx + 1], seg[2 * idx + 2]);
        }
        int query(int idx, int l, int r, int ql, int qr) {
            if (r < ql || l > qr) return Integer.MAX_VALUE;

            if (ql <= l && r <= qr) return seg[idx];

            int mid = l + (r - l) / 2;

            int left = query(2 * idx + 1, l, mid, ql, qr);
            int right = query(2 * idx + 2, mid + 1, r, ql, qr);

            return Math.min(left, right);
        }
    }
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        SEGMENT segTree = new SEGMENT(n);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            segTree.arr[i] = Integer.parseInt(st.nextToken());
        }

        segTree.build(0, 0, n - 1);
        StringBuilder sb = new StringBuilder();
        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            sb.append(segTree.query(0, 0, n - 1, a, b)).append("\n");
        }

        System.out.print(sb);
    }
}