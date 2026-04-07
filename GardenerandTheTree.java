import java.util.*;
public class GardenerandTheTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            if (n == 1) {
                sb.append(k >= 1 ? 0 : 1).append("\n");
                continue;
            }
            List<Integer>[] adj = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++)
                adj[i] = new ArrayList<>();

            int[] degree = new int[n + 1];
            for (int i = 0; i < n - 1; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                adj[u].add(v);
                adj[v].add(u);
                degree[u]++;
                degree[v]++;
            }
            Queue<Integer> queue = new LinkedList<>();
            int[] level = new int[n + 1];
            boolean[] visited = new boolean[n + 1];
            for (int i = 1; i <= n; i++) {
                if (degree[i] <= 1) {
                    queue.add(i);
                    level[i] = 1;
                }
            }

            int cnt = 0;
            while (!queue.isEmpty()) {
                int U = queue.poll();
                if (level[U] > k) continue;
                visited[U] = true;
                cnt++;
                for (int it : adj[U]) {
                    if (!visited[it]) {
                        degree[it]--;
                        if (degree[it] == 1) {
                            level[it] = level[U] + 1;
                            queue.add(it);
                        }
                    }
                }
            }
            sb.append(n - cnt).append("\n");
        }
        System.out.print(sb);
        sc.close();
    }
}
