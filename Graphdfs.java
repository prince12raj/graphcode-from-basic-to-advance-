import java.util.*;
public class Graphdfs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int w = sc.nextInt();
            adjList.get(u).add(w);
            adjList.get(w).add(u);
        }
        boolean[] visited = new boolean[v];
        Graphdfs g = new Graphdfs();

        int cnt = 0;
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                cnt++;
                System.out.print(i);
                g.dfs(adjList, i, visited);
            }
        }

        System.out.println(cnt);
    }
    public void dfs(ArrayList<ArrayList<Integer>> adjList, int i, boolean[] visited) {
        visited[i] = true;
        System.out.print(i + " ");

        for (int j : adjList.get(i)) {
            if (!visited[j]) {
                dfs(adjList, j, visited);
            }
        }
    }
}
