import java.util.*;
public class DPonTree {
    static ArrayList<ArrayList<Integer>> adj;
    static int dp[][];
    static int cost[];
    static void dfs(int node , int par){
        dp[node][0] =0;
        dp[node][1] = cost[node];
        for(int child : adj.get(node)){
            if(child != par){
                dfs(child , node);
                dp[node][0] += Math.max(dp[child][0] , dp[child][1]);
                dp[node][1] += dp[child][0];
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        adj = new ArrayList<>();
        int n  = sc.nextInt();
        dp = new int[20002][2];
        cost = new int[n+1];
        for(int i = 0; i <n; i++){
            cost[i] = sc.nextInt();
        }
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0 ; i < n -1; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        dfs(1, 0);
        System.out.println(Math.max( dp[1][0], dp[1][1]));
    }
}
