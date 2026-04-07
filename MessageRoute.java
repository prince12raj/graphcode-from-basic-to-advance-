import java.io.*;
import java.util.*;
public class MessageRoute {
    static void bfs(int src, ArrayList<ArrayList<Integer>> adjList, int n) {
        boolean[] visited = new boolean[n + 1];
        int[] parent = new int[n + 1];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(src);
        visited[src] = true;
        parent[src] = -1;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : adjList.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    parent[v] = u;
                    queue.add(v);
                }
            }
        }
        if (!visited[n]) {
            System.out.println("IMPOSSIBLE");
            return;
        }
        ArrayList<Integer> path = new ArrayList<>();
        int cur = n;
        while (cur != -1) {
            path.add(cur);
            cur = parent[cur];
        }
        Collections.reverse(path);
        System.out.println(path.size());
        for (int x : path) {
            System.out.print(x + " ");
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        bfs(1, adjList, n);
    }
}
