// import java.util.*;
// class Reroting {
//     static int dp[];
//     static int sub[];
//     static List<ArrayList<Integer>> adj;
//     static int n;
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         n = sc.nextInt();
//         dp = new int[n + 1];
//         sub = new int[n + 1];
//         adj = new ArrayList<>();
//         for (int i = 0; i <= n; i++) {
//             adj.add(new ArrayList<>());
//         }
//         for (int i = 0; i < n - 1; i++) {
//             int a = sc.nextInt();
//             int b = sc.nextInt();
//             adj.get(a).add(b);
//             adj.get(b).add(a);
//         }
//         dfs(1, -1);
//         dfs2(1, -1);
//         for (int i = 1; i <= n; i++) {
//             System.out.print(dp[i] + " ");
//         }
//     }
//     static void dfs(int node, int parent) {
//         sub[node] = 1;
//         dp[node] = 0;
//         for (int it : adj.get(node)) {
//             if (it != parent) {
//                 dfs(it, node);
//                 sub[node] += sub[it];
//                 dp[node] += dp[it] + sub[it];
//             }
//         }
//     }
//     static void dfs2(int node, int parent) {
//         for (int it : adj.get(node)) {
//             if (it != parent) {
//                 dp[it] = dp[node] - sub[it] + (n - sub[it]);
//                 dfs2(it, node);
//             }
//         }
//     }
// }


import java.io.*;
import java.util.*;
class Reroting {
    static int dp[];
    static int sub[];
    static List<ArrayList<Integer>> adj;
    static int n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        sub = new int[n + 1];
        adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        dfsIterative();
        dfs2Iterative();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(dp[i]).append(" ");
        }
        System.out.println(sb);
    }

    static void dfsIterative() {
        Stack<int[]> st = new Stack<>();
        st.push(new int[]{1, -1, 0}); 
        while (!st.isEmpty()) {
            int[] cur = st.pop();
            int node = cur[0];
            int parent = cur[1];
            int state = cur[2];

            if (state == 0) {
                st.push(new int[]{node, parent, 1});
                for (int child : adj.get(node)) {
                    if (child != parent) {
                        st.push(new int[]{child, node, 0});
                    }
                }
            } else {
                sub[node] = 1;
                dp[node] = 0;
                for (int child : adj.get(node)) {
                    if (child != parent) {
                        sub[node] += sub[child];
                        dp[node] += dp[child] + sub[child];
                    }
                }
            }
        }
    }
    static void dfs2Iterative() {
        Stack<int[]> st = new Stack<>();
        st.push(new int[]{1, -1});

        while (!st.isEmpty()) {
            int[] cur = st.pop();
            int node = cur[0];
            int parent = cur[1];

            for (int child : adj.get(node)) {
                if (child != parent) {
                    dp[child] = dp[node] - sub[child] + (n - sub[child]);
                    st.push(new int[]{child, node});
                }
            }
        }
    }
}