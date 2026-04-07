import java.util.*;
public class ADisjointSetsUnioncodeforces {
    static class DSU {
        int[] parent;
        int[] size;
        DSU(int n) {
            parent = new int[n + 1];
            size = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int x) {
            if(x == parent[x]) return x;
            return parent[x] = find(parent[x]);
        }

        void unionSet(int x, int y) {
            int px = find(x);
            int py = find(y);

            if (px == py) return;

            if (size[px] < size[py]) {
                parent[px] = py;
                size[py] += size[px];
            } else {
                parent[py] = px;
                size[px] += size[py];
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        DSU dsu = new DSU(n);

        for (int i = 0; i < m; i++) {

            String query = sc.next();
            int u = sc.nextInt();
            int v = sc.nextInt();

            if (query.equals("union")) {
                dsu.unionSet(u, v);
            } 
            else if (query.equals("get")) {
                if (dsu.find(u) == dsu.find(v)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }

        sc.close();
    }
}