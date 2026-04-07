import java.io.*;
import java.util.*;
class RoundTrip {
    static int start = -1, end = -1;
    static int[] parent;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        visited = new boolean[n + 1];
        parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                if (dfsIterative(i, adj)) {
                    printCycle();
                    return;
                }
            }
        }

        System.out.println("IMPOSSIBLE");
    }
    private static boolean dfsIterative(int src, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> stack = new Stack<>();
        stack.push(src);
        parent[src] = -1;

        while (!stack.isEmpty()) {
            int u = stack.pop();

            if (!visited[u]) {
                visited[u] = true;

                for (int v : adj.get(u)) {
                    if (!visited[v]) {
                        parent[v] = u;
                        stack.push(v);
                    } else if (v != parent[u]) {
                        start = v;
                        end = u;
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private static void printCycle() {
        ArrayList<Integer> cycle = new ArrayList<>();
        cycle.add(start);

        int v = end;
        while (v != start) {
            cycle.add(v);
            v = parent[v];
        }
        cycle.add(start);
        Collections.reverse(cycle);
        System.out.println(cycle.size());
        for (int x : cycle) {
            System.out.print(x + " ");
        }
    }
}
