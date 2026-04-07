// import java.util.*;
// public class IceScating{
//     static int n;
//     static int[] x, y;
//     static boolean[] visited;
//     static void dfs(int v) {
//         visited[v] = true;
//         for (int i = 0; i < n; i++) {
//             if (!visited[i] && (x[v] == x[i] || y[v] == y[i])) {
//                 dfs(i);
//             }
//         }
//     }
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         n = sc.nextInt();
//         x = new int[n];
//         y = new int[n];
//         visited = new boolean[n];
//         for (int i = 0; i < n; i++) {
//             x[i] = sc.nextInt();
//             y[i] = sc.nextInt();
//         }
//         int components = 0;
//         for (int i = 0; i < n; i++) {
//             if (!visited[i]) {
//                 dfs(i);
//                 components++;
//             }
//         }
//         System.out.println(components - 1);
//     }
// }
import java.util.*;
public class IceScating {
    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static List<List<Integer>> adj;
    static boolean[] visited;
    static void dfs(int node) {
        visited[node] = true;
        for (int k : adj.get(node)) {
            if (!visited[k]) {
                dfs(k);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            points[i] = new Point(sc.nextInt(), sc.nextInt());
        }
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (points[i].x == points[j].x || points[i].y == points[j].y) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        visited = new boolean[n];
        int components = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i);
                components++;
            }
        }
        System.out.println(components - 1);
    }
}
