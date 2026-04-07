import java.util.*;
class F_Maximum_White_Subtree {
    static int n;
    static ArrayList<ArrayList<Integer>> adj;
    static int[] val;
    static int[] dp;
    static int[] res;
    static void dfs1 (int node , int par){
        dp[node] = val[node];
        for(int it : adj.get(node)){
            if(it == par) continue;
            dfs1(it, node);
            dp[node] +=  Math.max(0, dp[it]);
        }
    }
    static void dfs2(int node, int par) {
        for (int it : adj.get(node)) {
            if (it == par) continue;
            int removecommonpart = res[node] - Math.max(0, dp[it]);
            res[it] = dp[it] + Math.max(0, removecommonpart);

            dfs2(it, node);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        val = new int[n + 1];
        dp = new int[n + 1];
        res = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int c = sc.nextInt();
            val[i] = (c == 1 ? 1 : -1);
        }
        adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        dfs1(1, 0);
        for (int i = 1; i <= n; i++) {
            res[i] = dp[i];
        }
        dfs2(1, 0);
        for (int i = 1; i <= n; i++) {
            System.out.print(res[i] + " ");
        }
    }
}