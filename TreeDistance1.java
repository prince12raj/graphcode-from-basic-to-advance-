// import java.util.*;
// public class TreeDistance1 {
//     static int n;
//     static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
//     static int[] bfs(int start) {
//         int[] dist = new int[n + 1];
//         Arrays.fill(dist, -1);
//         Queue<Integer> q = new LinkedList<>();
//         q.add(start);
//         dist[start] = 0;
//         while (!q.isEmpty()) {
//             int cur = q.poll();
//             for (int it : adj.get(cur)) {
//                 if (dist[it] == -1) {
//                     dist[it] = dist[cur] + 1;
//                     q.add(it);
//                 }
//             }
//         }
//         return dist;
//     }

//     static int maxinarr(int[] dist) {
//         int firstnode = 1;
//         for (int i = 1; i <= n; i++) {
//             if (dist[i] > dist[firstnode]) {
//                 firstnode = i;
//             }
//         }
//         return firstnode;
//     }

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         n = sc.nextInt();
//         for (int i = 0; i <= n; i++) {
//             adj.add(new ArrayList<>());
//         }
//         for (int i = 0; i < n - 1; i++) {
//             int u = sc.nextInt();
//             int v = sc.nextInt();

//             adj.get(u).add(v);
//             adj.get(v).add(u);
//         }
//         int[] d1 = bfs(1);
//         int A = maxinarr(d1);
//         int[] distA = bfs(A);
//         int B = maxinarr(distA);
//         int[] distB = bfs(B);
//         for (int i = 1; i <= n; i++) {
//             System.out.print(Math.max(distA[i], distB[i]) + " ");
//         }
//     }
// }
import java.io.*;
import java.util.*;
public class TreeDistance1 {
    static int n;
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    static int[] bfs(int start) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        dist[start] = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int it : adj.get(cur)) {
                if (dist[it] == -1) {
                    dist[it] = dist[cur] + 1;
                    q.add(it);
                }
            }
        }
        return dist;
    }
    static int maxinarr(int[] dist) {
        int firstnode = 1;

        for (int i = 1; i <= n; i++) {
            if (dist[i] > dist[firstnode]) {
                firstnode = i;
            }
        }
        return firstnode;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] d1 = bfs(1);
        int A = maxinarr(d1);
        int[] distA = bfs(A);
        int B = maxinarr(distA);
        int[] distB = bfs(B);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(Math.max(distA[i], distB[i])).append(" ");
        }
        System.out.println(sb);
    }
}
