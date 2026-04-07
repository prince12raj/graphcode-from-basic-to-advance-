// import java.util.*;
// public class PolynomialQueries {
//     static class Node {
//         long a, d;
//         Node() {
//             a = 0;
//             d = 0;
//         }
//     }
//     static int n;
//     static long[] arr;
//     static long[] seg;
//     static Node[] lazy;

//     static void build(int idx, int l, int r) {
//         if (l == r) {
//             seg[idx] = arr[l];
//             return;
//         }
//         int mid = (l + r) / 2;
//         build(2 * idx, l, mid);
//         build(2 * idx + 1, mid + 1, r);
//         seg[idx] = seg[2 * idx] + seg[2 * idx + 1];
//     }
//     static void push(int idx, int l, int r) {
//         if (lazy[idx].a == 0 && lazy[idx].d == 0) return;

//         int len = r - l + 1;
//         seg[idx] += (len * (2 * lazy[idx].a + (len - 1) * lazy[idx].d)) / 2;

//         if (l != r) {
//             int mid = (l + r) / 2;
//             lazy[2 * idx].a += lazy[idx].a;
//             lazy[2 * idx].d += lazy[idx].d;
//             long nextA = lazy[idx].a + (mid - l + 1) * lazy[idx].d;
//             lazy[2 * idx + 1].a += nextA;
//             lazy[2 * idx + 1].d += lazy[idx].d;
//         }

//         lazy[idx].a = 0;
//         lazy[idx].d = 0;
//     }
//     static void update(int idx, int l, int r, int ql, int qr) {
//         push(idx, l, r);

//         if (r < ql || l > qr) return;

//         if (ql <= l && r <= qr) {
//             long startVal = l - ql + 1;
//             lazy[idx].a += startVal;
//             lazy[idx].d += 1;
//             push(idx, l, r);
//             return;
//         }

//         int mid = (l + r) / 2;

//         update(2 * idx, l, mid, ql, qr);
//         update(2 * idx + 1, mid + 1, r, ql, qr);

//         seg[idx] = seg[2 * idx] + seg[2 * idx + 1];
//     }

//     static long query(int idx, int l, int r, int ql, int qr) {
//         push(idx, l, r);

//         if (r < ql || l > qr) return 0;

//         if (ql <= l && r <= qr) {
//             return seg[idx];
//         }

//         int mid = (l + r) / 2;

//         return query(2 * idx, l, mid, ql, qr)
//              + query(2 * idx + 1, mid + 1, r, ql, qr);
//     }

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);

//         n = sc.nextInt();
//         int q = sc.nextInt();

//         arr = new long[n + 1];
//         for (int i = 1; i <= n; i++) {
//             arr[i] = sc.nextLong();
//         }

//         seg = new long[4 * n];
//         lazy = new Node[4 * n];
//         for (int i = 0; i < 4 * n; i++) {
//             lazy[i] = new Node();
//         }

//         build(1, 1, n);

//         while (q-- > 0) {
//             int type = sc.nextInt();
//             int a = sc.nextInt();
//             int b = sc.nextInt();

//             if (type == 1) {
//                 update(1, 1, n, a, b);
//             } else {
//                 System.out.println(query(1, 1, n, a, b));
//             }
//         }

//         sc.close();
//     }
// }
// import java.io.*;
// import java.util.*;

// public class PolynomialQueries {

//     static class Node {
//         long a, d;
//         Node() {
//             a = 0;
//             d = 0;
//         }
//     }
//     static int n;
//     static long[] arr;
//     static long[] seg;
//     static Node[] lazy;
//     static void build(int idx, int l, int r) {
//         if (l == r) {
//             seg[idx] = arr[l];
//             return;
//         }
//         int mid = (l + r) / 2;
//         build(2 * idx, l, mid);
//         build(2 * idx + 1, mid + 1, r);
//         seg[idx] = seg[2 * idx] + seg[2 * idx + 1];
//     }
//     static void push(int idx, int l, int r) {
//         if (lazy[idx].a == 0 && lazy[idx].d == 0) return;

//         int len = r - l + 1;

//         seg[idx] += (len * (2 * lazy[idx].a + (len - 1) * lazy[idx].d)) / 2;

//         if (l != r) {
//             int mid = (l + r) / 2;
//             lazy[2 * idx].a += lazy[idx].a;
//             lazy[2 * idx].d += lazy[idx].d;
//             long nextA = lazy[idx].a + (mid - l + 1) * lazy[idx].d;
//             lazy[2 * idx + 1].a += nextA;
//             lazy[2 * idx + 1].d += lazy[idx].d;
//         }

//         lazy[idx].a = 0;
//         lazy[idx].d = 0;
//     }
//     static void update(int idx, int l, int r, int ql, int qr) {
//         push(idx, l, r);

//         if (r < ql || l > qr) return;

//         if (ql <= l && r <= qr) {
//             long startVal = l - ql + 1;
//             lazy[idx].a += startVal;
//             lazy[idx].d += 1;
//             push(idx, l, r);
//             return;
//         }

//         int mid = (l + r) / 2;

//         update(2 * idx, l, mid, ql, qr);
//         update(2 * idx + 1, mid + 1, r, ql, qr);

//         seg[idx] = seg[2 * idx] + seg[2 * idx + 1];
//     }
//     static long query(int idx, int l, int r, int ql, int qr) {
//         push(idx, l, r);

//         if (r < ql || l > qr) return 0;

//         if (ql <= l && r <= qr) {
//             return seg[idx];
//         }

//         int mid = (l + r) / 2;

//         return query(2 * idx, l, mid, ql, qr)
//              + query(2 * idx + 1, mid + 1, r, ql, qr);
//     }

//     public static void main(String[] args) throws Exception {

//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st;

//         st = new StringTokenizer(br.readLine());
//         n = Integer.parseInt(st.nextToken());
//         int q = Integer.parseInt(st.nextToken());

//         arr = new long[n + 1];

//         st = new StringTokenizer(br.readLine());
//         for (int i = 1; i <= n; i++) {
//             arr[i] = Long.parseLong(st.nextToken());
//         }

//         seg = new long[4 * n];
//         lazy = new Node[4 * n];
//         for (int i = 0; i < 4 * n; i++) {
//             lazy[i] = new Node();
//         }

//         build(1, 1, n);

//         StringBuilder sb = new StringBuilder();

//         while (q-- > 0) {
//             st = new StringTokenizer(br.readLine());
//             int type = Integer.parseInt(st.nextToken());
//             int a = Integer.parseInt(st.nextToken());
//             int b = Integer.parseInt(st.nextToken());

//             if (type == 1) {
//                 update(1, 1, n, a, b);
//             } else {
//                 sb.append(query(1, 1, n, a, b)).append('\n');
//             }
//         }

//         System.out.print(sb.toString());
//     }
// }
import java.util.*;
import java.io.*;

public class PolynomialQueries {
    static long[] seg;
    static long[] lazyA;
    static long[] lazyD;
    static int[] arr;

    static void lazyUpdate(int idx, int l, int r) {
        if(lazyA[idx] == 0 && lazyD[idx] == 0) return;

        int len = r - l + 1;
        seg[idx] += (len * (2 * lazyA[idx] + (len - 1) * lazyD[idx])) / 2;

        if(l != r){
            int m = (l + r) >> 1;
            lazyA[2*idx+1] += lazyA[idx];
            lazyD[2*idx+1] += lazyD[idx];
            lazyA[2*idx+2] += lazyA[idx] + (m - l + 1) * lazyD[idx];
            lazyD[2*idx+2] += lazyD[idx];
        }

        lazyA[idx] = 0;
        lazyD[idx] = 0;
    }

    static void build(int idx, int l, int r) {
        if (l == r) {
            seg[idx] = arr[l];
            return;
        }
        int mid = (l + r) >> 1;
        build(2*idx+1, l, mid);
        build(2*idx+2, mid+1, r);
        seg[idx] = seg[2*idx+1] + seg[2*idx+2];
    }

    static long query(int idx, int l, int r, int ql, int qr) {
        lazyUpdate(idx, l, r);
        if (r < ql || l > qr) return 0;
        if (l >= ql && r <= qr) return seg[idx];
        int mid = (l + r) >> 1;
        return query(2*idx+1, l, mid, ql, qr)
             + query(2*idx+2, mid+1, r, ql, qr);
    }

    static void update(int idx, int l, int r, int ql, int qr) {
        lazyUpdate(idx, l, r);
        if (r < ql || l > qr) return;
        if(l >= ql && r <= qr) {
            lazyA[idx] += (l - ql + 1);
            lazyD[idx] += 1;
            lazyUpdate(idx, l, r);
            return;
        }
        int mid = (l + r) >> 1;
        update(2*idx+1, l, mid, ql, qr);
        update(2*idx+2, mid+1, r, ql, qr);
        seg[idx] = seg[2*idx+1] + seg[2*idx+2];
    }

    public static void main(String[] args) throws Exception{
        IO io = new IO();
        int n = io.nextInt();
        int q = io.nextInt();
        arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = io.nextInt();

        seg = new long[4*n];
        lazyA = new long[4*n];
        lazyD = new long[4*n];

        build(0, 0, n-1);

        StringBuilder sb = new StringBuilder();
        while(q-- > 0) {
            int t = io.nextInt();
            if (t == 1) {
                int l = io.nextInt();
                int r = io.nextInt();
                update(0, 0, n-1, l-1, r-1);
            } else {
                int l = io.nextInt();
                int r = io.nextInt();
                sb.append(query(0, 0, n-1, l-1, r-1)).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}

class IO extends PrintWriter {
    private InputStream in;
    private byte[] buf = new byte[1 << 16];
    private int head = 0, tail = 0;

    public IO() {
        super(new BufferedOutputStream(System.out));
        in = System.in;
    }

    private int read() {
        if (head >= tail) {
            head = 0;
            try {
                tail = in.read(buf);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (tail <= 0) return -1;
        }
        return buf[head++];
    }

    public int nextInt() {
        int c = read();
        while (c <= 32) {
            if (c == -1) return -1;
            c = read();
        }
        boolean neg = false;
        if (c == '-') {
            neg = true;
            c = read();
        }
        int res = 0;
        while (c > 32) {
            res = res * 10 + c - '0';
            c = read();
        }
        return neg ? -res : res;
    }
}