import java.util.*;
public class Bfs {
    static void bfs(int s, ArrayList<ArrayList<Integer>> adjList) {
        boolean[] vis = new boolean[adjList.size()];
        Queue<Integer> q = new LinkedList<>();
        vis[s] = true;
        q.add(s);
        while (!q.isEmpty()) {
            int u = q.poll();
            System.out.print(u + " ");

            for (int v : adjList.get(u)) {
                if (!vis[v]) {
                    vis[v] = true;
                    q.add(v);
                }
            }
        }
    }
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
        int s = sc.nextInt(); 
        bfs(s, adjList);
        sc.close();
    }
}
