// import java.util.*;
// public class Subordinate {
//     static ArrayList<ArrayList<Integer>> adj;
//     static int[] sub;
//     static int dfs(int node) {
//         int size = 1;
//         for (int it : adj.get(node)) {
//             size += dfs(it);
//         }
//         sub[node] = size - 1;
//         return size;
//     }
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         adj = new ArrayList<>();
//         sub = new int[n + 1];
//         for (int i = 0; i <= n; i++) {
//             adj.add(new ArrayList<>());
//         }
//         for (int i = 2; i <= n; i++) {
//             int u = sc.nextInt();
//             adj.get(u).add(i);
//         }
//         dfs(1);
//         for (int i = 1; i <= n; i++) {
//             System.out.print(sub[i] + " ");
//         }
//     }
// }
import java.io.*;
import java.util.*;
public class Subordinate {
    static ArrayList<ArrayList<Integer>> adj;
    static int[] sub;
    static void dfs(int node) {
        for (int child : adj.get(node)) {

            dfs(child);
            sub[node] += 1 + sub[child]; 

        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        adj = new ArrayList<>();
        sub = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 2; i <= n; i++) {
            int boss = Integer.parseInt(st.nextToken());
            adj.get(boss).add(i);
        }
        dfs(1);
        for (int i = 1; i <= n; i++) {
            out.print(sub[i] + " ");
        }

        out.flush();
    }
}