// import java.util.*;
// public class LongestFlight {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int m = sc.nextInt();
//         ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
//         for (int i = 0; i <= n; i++) {
//             adj.add(new ArrayList<>());
//         }
//         for (int i = 0; i < m; i++) {
//             int a = sc.nextInt();
//             int b = sc.nextInt();
//             adj.get(a).add(b);
//         }
//         int [] indegree = new int[n + 1];
//         for (int i = 1; i <= n; i++) {
//             for (int v : adj.get(i)) {
//                 indegree[v]++;
//             }
//         }
//         Queue<Integer> q = new LinkedList<>();
//         for (int i = 1; i <= n; i++) {
//             if (indegree[i] == 0) {
//                 q.add(i);
//             }
//         }
//         ArrayList<Integer> res = new ArrayList<>();
//         while(!q.isEmpty()){
//             int u =q.poll();
//             res.add(u);
//             for(int it : adj.get(u)){
//                 indegree[it]--;
//                 if(indegree[it] == 0){
//                     q.add(it);
//                 }

//             }
//         }
//         int [] dp =new int[n+1];
//         int [] parentss=new int[n+1];
//         Arrays.fill(dp,Integer.MIN_VALUE);
//         dp[1]=1;
//         for(int u : res){
//             for(int v :adj.get(u)){
//                 if (dp[u] + 1 > dp[v]) {
//                     dp[v] = dp[u] + 1;
//                     parentss[v] = u;
//                 }
//             }
//         }
//         if(dp[n]<0){
//             System.out.println("IMPOSSIBLE");
//             return;
//         }
//         ArrayList<Integer> pathss = new ArrayList<>();
//         int cur = n;
//         while(cur!=0){
//             pathss.add(cur);
//             cur=parentss[cur];
//         }
//         Collections.reverse(pathss);
//         System.out.println(pathss.size());
//         for(int x:pathss){
//             System.out.print(x+" ");
//         }
//     }
// }
import java.io.*;
import java.util.*;
public class LongestFlight {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj.get(a).add(b);
        }

        int[] indegree = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int v : adj.get(i)) {
                indegree[v]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) {
            int u = q.poll();
            res.add(u);
            for (int v : adj.get(u)) {
                indegree[v]--;
                if (indegree[v] == 0) {
                    q.add(v);
                }
            }
        }
        int[] dp = new int[n + 1];
        int[] parent = new int[n + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[1] = 1;
        for (int u : res) {
            if(dp[u]==0) continue;
            for (int v : adj.get(u)) {
                if (dp[u] + 1 > dp[v]) {
                    dp[v] = dp[u] + 1;
                    parent[v] = u;
                }
            }
        }
        if (dp[n] < 0) {
            System.out.println("IMPOSSIBLE");
            return;
        }
        ArrayList<Integer> path = new ArrayList<>();
        int cur = n;
        while (cur != 0) {
            path.add(cur);
            cur = parent[cur];
        }
        Collections.reverse(path);
        StringBuilder sb = new StringBuilder();
        sb.append(path.size()).append("\n");
        for (int x : path) {
            sb.append(x).append(" ");
        }

        System.out.println(sb.toString());
    }
}
