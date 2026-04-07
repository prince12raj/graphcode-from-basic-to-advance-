// import java.util.*;
// public class ShortestRoute1 {
//     public static void main(String[] args) {

//         Scanner sc = new Scanner(System.in);

//         int n = sc.nextInt();
//         int m = sc.nextInt();

//         List<List<long[]>> adj = new ArrayList<>();

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
//         Arrays.fill(dist, Long.MAX_VALUE);
//         dist[1] = 0;
//         PriorityQueue<long[]> pq = new PriorityQueue<>(
//                 (a, b) -> Long.compare(a[0], b[0])
//         );

//         pq.add(new long[]{0, 1});
//         while (!pq.isEmpty()) {
//             long[] curr = pq.poll();
//             long currDist = curr[0];
//             int node = (int) curr[1];
//             if (currDist > dist[node]) continue;
//             for (long[] uv : adj.get(node)) {
//                 int nextNode = (int) uv[0];
//                 long weight = uv[1];
//                 if (dist[nextNode] > currDist + weight) {
//                     dist[nextNode] = currDist + weight;
//                     pq.add(new long[]{dist[nextNode], nextNode});
//                 }
//             }
//         }
//         for (int i = 1; i <= n; i++) {
//             System.out.print(dist[i] + " ");
//         }

//         sc.close();
//     }
// }
import java.io.*;
import java.util.*;
public class ShortestRoute1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<List<long[]>> adj = new ArrayList<>();
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
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1] = 0;
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        pq.add(new long[]{0, 1});
        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            long currDist = curr[0];
            int node = (int) curr[1];

            if (currDist > dist[node]) continue;

            for (long[] uv : adj.get(node)) {
                int nextNode = (int) uv[0];
                long weight = uv[1];

                if (dist[nextNode] > currDist + weight) {
                    dist[nextNode] = currDist + weight;
                    pq.add(new long[]{dist[nextNode], nextNode});
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(dist[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
}
