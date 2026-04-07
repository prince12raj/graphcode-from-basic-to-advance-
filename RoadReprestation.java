// import java.util.*;

// public class RoadReprestation {
//     static class DSU {
//         int[] parent;
//         int[] size;
//         int components;
//         DSU(int n) {
//             parent = new int[n + 1];
//             size = new int[n + 1];
//             components = n;

//             for (int i = 1; i <= n; i++) {
//                 parent[i] = i;
//                 size[i] = 1;
//             }
//         }
//         int find(int x) {
//             if (parent[x] == x) return x;
//             return parent[x] = find(parent[x]);
//         }
//         boolean union(int a, int b) {
//             int pa = find(a);
//             int pb = find(b);
//             if (pa == pb) return false;
//             if (size[pa] < size[pb]) {
//                 parent[pa] = pb;
//                 size[pb] += size[pa];
//             } else {
//                 parent[pb] = pa;
//                 size[pa] += size[pb];
//             }
//             components--;
//             return true;
//         }
//     }
//     static class Edge {
//         int a, b;
//         long cost;
//         Edge(int a, int b, long cost) {
//             this.a = a;
//             this.b = b;
//             this.cost = cost;
//         }
//     }

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int m = sc.nextInt();

//         List<Edge> edges = new ArrayList<>();
//         for (int i = 0; i < m; i++) {
//             int a = sc.nextInt();
//             int b = sc.nextInt();
//             long c = sc.nextLong();
//             edges.add(new Edge(a, b, c));
//         }
//         edges.sort(Comparator.comparingLong(e -> e.cost));
//         DSU dsu = new DSU(n);
//         long totalCost = 0;
//         int edgesUsed = 0;
//         for (Edge e : edges) {
//             if (dsu.union(e.a, e.b)) {
//                 totalCost += e.cost;
//                 edgesUsed++;
//             }
//         }
//         if (edgesUsed == n - 1) {
//             System.out.println(totalCost);
//         } else {
//             System.out.println("IMPOSSIBLE");
//         }
//     }
// }
import java.io.*;
import java.util.*;
public class RoadReprestation {
    static class DSU {
        int[] parent;
        int[] size;
        int components;
        DSU(int n) {
            parent = new int[n + 1];
            size = new int[n + 1];
            components = n;

            for (int i = 1; i <= n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }
        int find(int x) {
            if (parent[x] == x) return x;
            return parent[x] = find(parent[x]);
        }
        boolean union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if (pa == pb) return false;
            if (size[pa] < size[pb]) {
                parent[pa] = pb;
                size[pb] += size[pa];
            } else {
                parent[pb] = pa;
                size[pa] += size[pb];
            }
            components--;
            return true;
        }
    }
    static class Edge {
        int a, b;
        long cost;

        Edge(int a, int b, long cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            edges.add(new Edge(a, b, c));
        }

        edges.sort(Comparator.comparingLong(e -> e.cost));

        DSU dsu = new DSU(n);
        long totalCost = 0;
        int edgesUsed = 0;

        for (Edge e : edges) {
            if (dsu.union(e.a, e.b)) {
                totalCost += e.cost;
                edgesUsed++;
            }
        }

        if (edgesUsed == n - 1) {
            System.out.println(totalCost);
        } else {
            System.out.println("IMPOSSIBLE");
        }
    }
}