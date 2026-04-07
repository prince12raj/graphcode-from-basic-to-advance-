import java.util.*;
public class TreeDistancesII {
    static List<ArrayList<Integer>> adj;
    static int totaldist;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        int[] res = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            totaldist = 0;
            dfs(i, -1, 0);
            res[i] = totaldist;
        }
        for (int i = 1; i <= n; i++) {
            System.out.print(res[i] + " ");
        }
    }
    static void dfs(int s ,int parent, int dist){
        totaldist += dist;
        for(int it : adj.get(s)){
            if(it != parent){
                dfs(it, s, dist+1);
            }
        }
    }
}