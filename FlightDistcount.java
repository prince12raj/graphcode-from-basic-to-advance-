// import java.util.*;
// public class FlightDistcount {
//     static class State {
//         int node;
//         int used;
//         long cost;
//         State(int node, int used, long cost) {
//             this.node = node;
//             this.used = used;
//             this.cost = cost;
//         }
//     }
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int m = sc.nextInt();
//         List<List<int[]>> adj = new ArrayList<>();
//         for (int i = 0; i <= n; i++) {
//             adj.add(new ArrayList<>());
//         }
//         for (int i = 0; i < m; i++) {
//             int a = sc.nextInt();
//             int b = sc.nextInt();
//             int c = sc.nextInt();
//             adj.get(a).add(new int[]{b, c});
//         }
//         long[][] dist = new long[n + 1][2];
//         for (int i = 1; i <= n; i++) {
//             Arrays.fill(dist[i], Long.MAX_VALUE);
//         }
//         PriorityQueue<State> pq =new PriorityQueue<>((a, b) -> Long.compare(a.cost, b.cost));
//         dist[1][0] = 0;
//         pq.add(new State(1, 0, 0));
//         while (!pq.isEmpty()) {
//             State curr = pq.poll();
//             if (curr.cost > dist[curr.node][curr.used]) continue;
//             for (int[] it : adj.get(curr.node)) {
//                 int next = it[0];
//                 int weight = it[1];
//                 if (curr.cost + weight < dist[next][curr.used]) {
//                     dist[next][curr.used] = curr.cost + weight;
//                     pq.add(new State(next, curr.used, dist[next][curr.used]));
//                 }
//                 if (curr.used == 0) {
//                     long dis = curr.cost + weight / 2;
//                     if (dis < dist[next][1]) {
//                         dist[next][1] = dis;
//                         pq.add(new State(next, 1, dis));
// //                     }if (curr.cost + weight < dist[next][0]) {
//                     dist[next][0] = curr.cost + weight;
//                     pq.add(new State(next, 0, dist[next][0]));
// }
//                 }
//             }
//         }
//         System.out.println(dist[n][1]);
//     }
// }
import java.io.*;
import java.util.*;
public class FlightDistcount {
    static class State {
        int node;
        int used;
        long cost;
        State(int node, int used, long cost) {
            this.node = node;
            this.used = used;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj.get(a).add(new int[]{b, c});
        }
        long[][] dist = new long[n + 1][2];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], Long.MAX_VALUE);
        }
        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> Long.compare(a.cost, b.cost));
        dist[1][0] = 0;
        pq.add(new State(1, 0, 0));
        while (!pq.isEmpty()) {
            State curr = pq.poll();
            if (curr.cost > dist[curr.node][curr.used]) continue;
            for (int[] it : adj.get(curr.node)) {
                int next = it[0];
                int weight = it[1];
                if (curr.cost + weight < dist[next][curr.used]) {
                    dist[next][curr.used] = curr.cost + weight;
                    pq.add(new State(next, curr.used, dist[next][curr.used]));
                }
                if (curr.used == 0) {
                    long discountedCost = curr.cost + weight / 2;
                    if (discountedCost < dist[next][1]) {
                        dist[next][1] = discountedCost;
                        pq.add(new State(next, 1, discountedCost));
                    }
                    if (curr.cost + weight < dist[next][0]) {
                    dist[next][0] = curr.cost + weight;
                    pq.add(new State(next, 0, dist[next][0]));
                }
                }
            }
        }

        System.out.println(dist[n][1]);
    }
}
