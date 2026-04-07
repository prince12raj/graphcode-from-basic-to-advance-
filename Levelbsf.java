import java.util.*;
public class Levelbsf {
    static ArrayList<ArrayList<Integer>> adj;
    static int[] vis;
    static int[] level;
    static void bfs(int src) {
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        vis[src] = 1;
        level[src] = 0;

        while (!q.isEmpty()) {
            int v = q.poll();
            for (int it : adj.get(v)) {
                if (vis[it] == 0) {
                    vis[it] = 1;
                    level[it] = level[v] + 1;
                    q.add(it);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt();
        int e = sc.nextInt();

        adj = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            adj.add(new ArrayList<>());
        }

        vis = new int[v + 1];
        level = new int[v + 1];

        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        bfs(0);

        for (int i = 0; i < v; i++) {
            System.out.println(i + "->" + level[i]);
        }

        sc.close();
    }
}
