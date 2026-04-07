// import java.util.*;
// public class SegmenttreeCses{
//     static class Segment {
//         static int arr[];
//         static int seg[];
//         Segment(int n) {
//             arr = new int[n];
//             seg = new int[4 * n];
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

//         static int query(int idx, int l, int r, int ql, int qr) {
//             if (r < ql || l > qr) {
//                 return 0;
//             }
//             if (ql <= l && r <= qr) {
//                 return seg[idx];
//             }

//             int mid = l + (r - l) / 2;
//             int left = query(2 * idx + 1, l, mid, ql, qr);
//             int right = query(2 * idx + 2, mid + 1, r, ql, qr);
//             return left + right;
//         }
//     }

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);

//         int n = sc.nextInt();
//         int q = sc.nextInt();

//         Segment segi = new Segment(n); 
//         for (int i = 0; i < n; i++) {
//             Segment.arr[i] = sc.nextInt();
//         }
//         Segment.segbuild(0, 0, n - 1);

//         while (q-- > 0) {
//             int a = sc.nextInt() -1;
//             int b = sc.nextInt() -1;
//             System.out.println(Segment.query(0, 0, n - 1, a, b));
//         }
//     }
// }
import java.io.*;
import java.util.*;

public class SegmenttreeCses {

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
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        Segment segi = new Segment(n);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            Segment.arr[i] = Long.parseLong(st.nextToken());
        }

        Segment.segbuild(0, 0, n - 1);

        StringBuilder sb = new StringBuilder();

        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            sb.append(Segment.query(0, 0, n - 1, a, b)).append("\n");
        }

        System.out.print(sb);
    }
}