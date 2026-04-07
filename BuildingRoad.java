import java.io.*;
import java.util.*;
public class BuildingRoad {
    static List<List<Integer>> adj;
    static boolean[] visited;
    static int lastNode;
    static void dfs(int s) {
        visited[s] = true;
        lastNode = s;
        for (int k : adj.get(s)) {
            if (!visited[k]) {
                dfs(k);
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        visited = new boolean[n + 1];
        List<Integer> res = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i);
                res.add(lastNode);
            }
        }

        System.out.println(res.size() - 1);
        for (int i = 1; i < res.size(); i++) {
            System.out.println(res.get(i - 1) + " " + res.get(i));
        }
    }
}
