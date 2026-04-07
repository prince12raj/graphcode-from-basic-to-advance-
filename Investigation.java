// import java.util.*;
// public class Investigation {
//     static class Pair {
//         int node;
//         long dist;
//         Pair(int node, long dist) {
//             this.node = node;
//             this.dist = dist;
//         }
//     }
//     static final long INF = Long.MAX_VALUE;
//     static final int MOD = 1_000_000_007;
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int m = sc.nextInt();
//         ArrayList<ArrayList<long[]>> adj = new ArrayList<>();
//         for (int i = 0; i <= n; i++) {
//             adj.add(new ArrayList<>());
//         }
//         for (int i = 0; i < m; i++) {
//             int a = sc.nextInt();
//             int b = sc.nextInt();
//             long c = sc.nextLong();
//             adj.get(a).add(new long[]{b, c});
//         }
//         long[] dist = new long[n + 1];
//         long[] ways = new long[n + 1];
//         int[] minFlight = new int[n + 1];
//         int[] maxFlight = new int[n + 1];
//         Arrays.fill(dist, INF);
//         PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.dist, b.dist));

//         dist[1] = 0;
//         ways[1] = 1;
//         minFlight[1] = 0;
//         maxFlight[1] = 0;
//         pq.add(new Pair(1, 0));
//         while (!pq.isEmpty()) {
//             Pair curr = pq.poll();
//             int u = curr.node;
//             long d = curr.dist;
//             if (d > dist[u]) continue;
//             for (long[] edge : adj.get(u)) {
//                 int v = (int) edge[0];
//                 long weight = edge[1];
//                 long newDist = d + weight;
//                 if (newDist < dist[v]) {
//                     dist[v] = newDist;
//                     ways[v] = ways[u];
//                     minFlight[v] = minFlight[u] + 1;
//                     maxFlight[v] = maxFlight[u] + 1;
//                     pq.add(new Pair(v, newDist));
//                 }
//                 else if (newDist == dist[v]) {
//                     ways[v] = (ways[v] + ways[u]) % MOD;
//                     minFlight[v] = Math.min(minFlight[v], minFlight[u] + 1);
//                     maxFlight[v] = Math.max(maxFlight[v], maxFlight[u] + 1);
//                 }
//             }
//         }
//         System.out.println(dist[n] + " " +ways[n] + " " +minFlight[n] + " " +maxFlight[n]);
//     }
// }
import java.io.*;
import java.util.*;
public class Investigation {
    static class Pair {
        int node;
        long dist;
        Pair(int node, long dist) {
            this.node = node;
            this.dist = dist;
        }
    }
    static final long INF = Long.MAX_VALUE;
    static final int MOD = 1_000_000_007;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<long[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            adj.get(a).add(new long[]{b, c});
        }
        long[] dist = new long[n + 1];
        long[] ways = new long[n + 1];
        int[] minFlight = new int[n + 1];
        int[] maxFlight = new int[n + 1];
        Arrays.fill(dist, INF);
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.dist, b.dist));
        dist[1] = 0;
        ways[1] = 1;
        minFlight[1] = 0;
        maxFlight[1] = 0;
        pq.add(new Pair(1, 0));
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int u = curr.node;
            long d = curr.dist;
            if (d > dist[u]) continue;
            for (long[] edge : adj.get(u)) {
                int v = (int) edge[0];
                long weight = edge[1];
                long newDist = d + weight;
                if (newDist < dist[v]) {
                    dist[v] = newDist;
                    ways[v] = ways[u];
                    minFlight[v] = minFlight[u] + 1;
                    maxFlight[v] = maxFlight[u] + 1;
                    pq.add(new Pair(v, newDist));
                }
                else if (newDist == dist[v]) {
                    ways[v] = (ways[v] + ways[u]) % MOD;
                    minFlight[v] = Math.min(minFlight[v], minFlight[u] + 1);
                    maxFlight[v] = Math.max(maxFlight[v], maxFlight[u] + 1);
                }
            }
        }
        System.out.println(dist[n] + " " + ways[n] + " " + minFlight[n] + " " + maxFlight[n]);
    }
}
