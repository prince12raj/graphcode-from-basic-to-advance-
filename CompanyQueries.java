// import java.util.*;
// public class CompanyQueries {
//     static int LOG = 20;
//     static ArrayList<ArrayList<Integer>> adj;
//     static int[][] up;
//     static int[] depth;
//     static void dfs(int node, int parent){
//         up[node][0] = parent;
//         for(int j = 1; j < LOG; j++){
//             up[node][j] = up[ up[node][j-1] ][j-1];
//         }
//         for(int child : adj.get(node)){
//             if(child != parent){
//                 depth[child] = depth[node] + 1;
//                 dfs(child , node);
//             }
//         }
//     }
//     static int LCA(int a , int b){
//         if(depth[a] < depth[b]){
//             int temp = a;
//             a = b;
//             b = temp;
//         }
//         int diff = depth[a] - depth[b];
//         for(int j = 0 ; j < LOG ; j++){
//             if((diff & (1 << j)) != 0){
//                 a = up[a][j];
//             }
//         }
//         if(a == b) return a;
//         for(int j = LOG-1 ; j >= 0 ; j--){
//             if(up[a][j] != up[b][j]){
//                 a = up[a][j];
//                 b = up[b][j];
//             }
//         }
//         return up[a][0];
//     }
//     public static void main(String[] args){
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int q = sc.nextInt();
//         adj = new ArrayList<>();
//         for(int i = 0; i <= n; i++){
//             adj.add(new ArrayList<>());
//         }
//         up = new int[n+1][LOG];
//         depth = new int[n+1];
//         for(int i = 2; i <= n; i++){
//             int boss = sc.nextInt();
//             adj.get(boss).add(i);
//             adj.get(i).add(boss);
//         }
//         dfs(1,0);
//         while(q-- > 0){
//             int a = sc.nextInt();
//             int b = sc.nextInt();
//             System.out.println(LCA(a,b));
//         }
//     }
// }
// import java.io.*;
// import java.util.*;
// public class CompanyQueries {
//     static int LOG = 20;
//     static ArrayList<ArrayList<Integer>> adj;
//     static int[][] up;
//     static int[] depth;
//     static void dfs(int node, int parent){
//         up[node][0] = parent;
//         for(int j = 1; j < LOG; j++){
//             up[node][j] = up[ up[node][j-1] ][j-1];
//         }
//         for(int child : adj.get(node)){
//             if(child != parent){
//                 depth[child] = depth[node] + 1;
//                 dfs(child , node);
//             }
//         }
//     }
//     static int LCA(int a , int b){
//         if(depth[a] < depth[b]){
//             int temp = a;
//             a = b;
//             b = temp;
//         }
//         int diff = depth[a] - depth[b];
//         for(int j = 0 ; j < LOG ; j++){
//             if((diff & (1 << j)) != 0){
//                 a = up[a][j];
//             }
//         }
//         if(a == b) return a;
//         for(int j = LOG-1 ; j >= 0 ; j--){
//             if(up[a][j] != up[b][j]){
//                 a = up[a][j];
//                 b = up[b][j];
//             }
//         }
//         return up[a][0];
//     }
//     public static void main(String[] args) throws Exception {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine());
//         int n = Integer.parseInt(st.nextToken());
//         int q = Integer.parseInt(st.nextToken());
//         adj = new ArrayList<>();
//         for(int i = 0; i <= n; i++){
//             adj.add(new ArrayList<>());
//         }
//         up = new int[n+1][LOG];
//         depth = new int[n+1];
//         st = new StringTokenizer(br.readLine());
//         for(int i = 2; i <= n; i++){
//             int boss = Integer.parseInt(st.nextToken());
//             adj.get(boss).add(i);
//             adj.get(i).add(boss);
//         }
//         dfs(1,0);
//         StringBuilder sb = new StringBuilder();
//         while(q-- > 0){
//             st = new StringTokenizer(br.readLine());
//             int a = Integer.parseInt(st.nextToken());
//             int b = Integer.parseInt(st.nextToken());
//             sb.append(LCA(a,b)).append("\n");
//         }
//         System.out.print(sb);
//     }
// }
import java.io.*;
import java.util.*;
public class CompanyQueries {
    static int LOG = 20;
    static ArrayList<ArrayList<Integer>> adj;
    static int[][] up;
    static int[] depth;
    static void dfs(int node, int parent){
        up[node][0] = parent;
        for(int j = 1; j < LOG; j++){
            up[node][j] = up[ up[node][j-1] ][j-1];
        }
        for(int child : adj.get(node)){
            if(child != parent){
                depth[child] = depth[node] + 1;
                dfs(child , node);
            }
        }
    }
    static int LCA(int a , int b){
        if(depth[a] < depth[b]){
            int temp = a;
            a = b;
            b = temp;
        }
        int diff = depth[a] - depth[b];
        for(int j = 0 ; j < LOG ; j++){
            if((diff & (1 << j)) != 0){
                a = up[a][j];
            }
        }
        if(a == b) return a;
        for(int j = LOG-1 ; j >= 0 ; j--){
            if(up[a][j] != up[b][j]){
                a = up[a][j];
                b = up[b][j];
            }
        }

        return up[a][0];
    }
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int q = fs.nextInt();
        adj = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }
        up = new int[n+1][LOG];
        depth = new int[n+1];
        for(int i = 2; i <= n; i++){
            int boss = fs.nextInt();
            adj.get(boss).add(i);
            adj.get(i).add(boss);
        }
        dfs(1,0);
        StringBuilder sb = new StringBuilder();
        while(q-- > 0){
            int a = fs.nextInt();
            int b = fs.nextInt();
            sb.append(LCA(a,b)).append("\n");
        }
        System.out.print(sb);
    }
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
            while ((c = read()) <= ' ') {
                if (c == -1) return -1;
            }
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
}