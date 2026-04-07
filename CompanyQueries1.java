// import java.util.*;
// class CompanyQueries1 {
//     static int LOG = 20;
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int q = sc.nextInt();
//         int[][] up = new int[n + 1][LOG];
//         for (int i = 2; i <= n; i++) {
//             up[i][0] = sc.nextInt();
//         }
//         for (int j = 1; j < LOG; j++) {
//             for (int i = 1; i <= n; i++) {
//                 int parent = up[i][j - 1];
//                 if (parent != 0) {
//                     up[i][j] = up[parent][j - 1];
//                 }
//             }
//         }
//         while (q-- > 0) {
//             int x = sc.nextInt();
//             int k = sc.nextInt();
//             for (int j = 0; j < LOG; j++) {
//                 if ((k & (1 << j)) != 0) {
//                     x = up[x][j];

//                     if (x == 0)
//                         break;
//                 }
//             }
//             if (x == 0)
//                 System.out.println(-1);
//             else
//                 System.out.println(x);
//         }
//         sc.close();
//     }
// }
// import java.io.*;
// import java.util.*;
// class CompanyQueries1 {
//     static int LOG = 20;
//     public static void main(String[] args) throws Exception {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st;

//         st = new StringTokenizer(br.readLine());
//         int n = Integer.parseInt(st.nextToken());
//         int q = Integer.parseInt(st.nextToken());

//         int[][] up = new int[n + 1][LOG];
//         st = new StringTokenizer(br.readLine());
//         for (int i = 2; i <= n; i++) {
//             up[i][0] = Integer.parseInt(st.nextToken());
//         }
//         for (int j = 1; j < LOG; j++) {
//             for (int i = 1; i <= n; i++) {
//                 int parent = up[i][j - 1];
//                 if (parent != 0) {
//                     up[i][j] = up[parent][j - 1];
//                 }
//             }
//         }
//         StringBuilder sb = new StringBuilder();
//         while (q-- > 0) {
//             st = new StringTokenizer(br.readLine());
//             int x = Integer.parseInt(st.nextToken());
//             int k = Integer.parseInt(st.nextToken());
//             for (int j = 0; j < LOG; j++) {
//                 if ((k & (1 << j)) != 0) {
//                     x = up[x][j];
//                     if (x == 0) break;
//                 }
//             }
//             if (x == 0) sb.append(-1).append("\n");
//             else sb.append(x).append("\n");
//         }

//         System.out.print(sb);
//     }
// }
import java.io.*;
import java.util.*;

class CompanyQueries1 {

    static int LOG = 20;

    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c;
            while ((c = read()) <= ' ');
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            int val = c - '0';
            while ((c = read()) > ' ') {
                val = val * 10 + c - '0';
            }
            return val * sign;
        }
    }

    public static void main(String[] args) throws Exception {

        FastScanner fs = new FastScanner();

        int n = fs.nextInt();
        int q = fs.nextInt();

        int[][] up = new int[n + 1][LOG];

        for (int i = 2; i <= n; i++) {
            up[i][0] = fs.nextInt();
        }

        for (int j = 1; j < LOG; j++) {
            for (int i = 1; i <= n; i++) {
                int parent = up[i][j - 1];
                if (parent != 0) {
                    up[i][j] = up[parent][j - 1];
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        while (q-- > 0) {
            int x = fs.nextInt();
            int k = fs.nextInt();

            for (int j = 0; j < LOG; j++) {
                if ((k & (1 << j)) != 0) {
                    x = up[x][j];
                    if (x == 0) break;
                }
            }

            sb.append(x == 0 ? -1 : x).append('\n');
        }

        System.out.print(sb);
    }
}