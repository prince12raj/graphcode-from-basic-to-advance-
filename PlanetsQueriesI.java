import java.io.*;
import java.util.*;

public class PlanetsQueriesI {
    static final int LOG = 30;
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int q = fs.nextInt();
        int[][] up = new int[n + 1][LOG];
        for (int i = 1; i <= n; i++) {
            up[i][0] = fs.nextInt();
        }

        for (int j = 1; j < LOG; j++) {
            for (int i = 1; i <= n; i++) {
                up[i][j] = up[up[i][j - 1]][j - 1];
            }
        }
        StringBuilder ans = new StringBuilder();
        while (q-- > 0) {
            int x = fs.nextInt();
            long k = fs.nextLong();

            for (int j = 0; j < LOG; j++) {
                if ((k & (1L << j)) != 0) {
                    x = up[x][j];
                }
            }
            ans.append(x).append("\n");
        }

        System.out.print(ans);
    }
    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String next() throws IOException {
            while (st == null || !st.hasMoreElements()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }
    }
}