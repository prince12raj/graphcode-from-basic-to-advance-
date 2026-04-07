import java.util.*;
public class Dijkstra {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int w = sc.nextInt();
            adj.get(a).add(new int[]{b, w});
            adj.get(b).add(new int[]{a, w});
        }
        long[] dist = new long[n + 1];
        int[] parent = new int[n + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        Arrays.fill(parent, -1);
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        dist[1] = 0;
        pq.add(new long[]{0, 1});
        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            long currDist = curr[0];
            int node = (int) curr[1];
            if (currDist > dist[node]) continue;
            for (int[] edge : adj.get(node)) {
                int next = edge[0];
                int weight = edge[1];
                if (currDist + weight < dist[next]) {
                    dist[next] = currDist + weight;
                    parent[next] = node;
                    pq.add(new long[]{dist[next], next});
                }
            }
        }
        if (dist[n] == Long.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        ArrayList<Integer> path = new ArrayList<>();
        int v = n;
        while (v != -1) {
            path.add(v);
            v = parent[v];
        }
        Collections.reverse(path);
        for (int node : path) {
            System.out.print(node + " ");
        }
    }
}
