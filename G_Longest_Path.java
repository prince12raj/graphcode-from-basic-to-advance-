// // by using bfs and topological sort
// import java.util.*;
// public class G_Longest_Path {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int m = sc.nextInt();
//         ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
//         for (int i = 0; i <= n; i++){
//             adj.add(new ArrayList<>());
//         } 
//         int[] indegree = new int[n + 1];
//         for (int i = 0; i < m; i++) {
//             int u = sc.nextInt();
//             int v = sc.nextInt();
//             adj.get(u).add(v);
//             indegree[v]++;
//         }
//         Queue<Integer> q = new LinkedList<>();
//         for (int i = 1; i <= n; i++) {
//             if (indegree[i] == 0){
//              q.add(i);
//             }      
//         }
//         List<Integer> topo = new ArrayList<>();
//         while (!q.isEmpty()) {
//             int u = q.poll();
//             topo.add(u);
//             for (int v : adj.get(u)) {
//                 indegree[v]--;
//                 if (indegree[v] == 0){
//                      q.add(v);
//                 }
//             }
//         }
//         int[] dp = new int[n + 1];
//         for (int u : topo) {
//             for (int v : adj.get(u)) {
//                 dp[v] = Math.max(dp[v], dp[u] + 1);
//             }
//         }
//         int ans = 0;
//         for (int i = 1; i <= n; i++){
//             ans = Math.max(ans, dp[i]);
//         }
//         System.out.println(ans);
//     }
// }
// import java.util.*;
// public class G_Longest_Path {
//     static int n, m;
//     static ArrayList<ArrayList<Integer>> adj;
//     static boolean[] visited;
//     static ArrayList<Integer> topo;
//     static int[] dp;
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         n = sc.nextInt();
//         m = sc.nextInt();
//         adj = new ArrayList<>();
//         for (int i = 0; i <= n; i++) {
//             adj.add(new ArrayList<>());
//         }
//         for (int i = 0; i < m; i++) {
//             int u = sc.nextInt();
//             int v = sc.nextInt();
//             adj.get(u).add(v);
//         }
//         visited = new boolean[n + 1];
//         topo = new ArrayList<>();
//         for (int i = 1; i <= n; i++) {
//             if (!visited[i]) {
//                 dfsTopo(i);
//             }
//         }
//         Collections.reverse(topo);
//         dp = new int[n + 1];
//         for (int u : topo) {
//             for (int v : adj.get(u)) {
//                 dp[v] = Math.max(dp[v], dp[u] + 1);
//             }
//         }
//         int ans = 0;
//         for (int i = 1; i <= n; i++) {
//             ans = Math.max(ans, dp[i]);
//         }

//         System.out.println(ans);
//     }
//     static void dfsTopo(int u) {
//         visited[u] = true;
//         for (int v : adj.get(u)) {
//             if (!visited[v]) {
//                 dfsTopo(v);
//             }
//         }
//         topo.add(u);
//     }
// }

import java.util.*;
public class G_Longest_Path {
    static int n, m;
    static ArrayList<ArrayList<Integer>> adj;
    static int[] memo;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
        }
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        int longestPath = 0;
        for (int i = 1; i <= n; i++) {
            longestPath = Math.max(longestPath, dfs(i));
        }
        System.out.println(longestPath);
    }
    static int dfs(int u) {
        if (memo[u] != -1) return memo[u]; 
        int maxLen = 0;
        for (int v : adj.get(u)) {
            int len = dfs(v) + 1; // +1 for this edge
            maxLen = Math.max(maxLen, len);
        }

        memo[u] = maxLen;
        return maxLen;
    }
}