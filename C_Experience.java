import java.util.*;
public class C_Experience {
    static class DSU {
        int parent[];
        int size[];
        long exp[];
        DSU(int n) {
            parent = new int[n + 1];
            size = new int[n + 1];
            exp = new long[n + 1];

            for (int i = 1; i <= n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }
        int find(int x) {
            if (parent[x] == x) return x;

            int p = parent[x];
            parent[x] = find(parent[x]);
            exp[x] += exp[p]; 

            return parent[x];
        }
        void add(int x, long v) {
            int root = find(x);
            exp[root] += v;
        }
        void union(int x, int y) {
            int px = find(x);
            int py = find(y);

            if (px == py) return;
            if (size[px] < size[py]) {
                parent[px] = py;
                exp[px] -= exp[py];
                size[py] += size[px];
            } else {
                parent[py] = px;
                exp[py] -= exp[px];
                size[px] += size[py];
            }
        }
        long get(int x) {
            find(x);
            return exp[x];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        DSU dsu = new DSU(n);

        while (m-- > 0) {
            String type = sc.next();

            if (type.equals("join")) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                dsu.union(x, y);
            }
            else if (type.equals("add")) {
                int x = sc.nextInt();
                int v = sc.nextInt();
                dsu.add(x, v);
            }
            else {
                int x = sc.nextInt();
                System.out.println(dsu.get(x));
            }
        }
    }
}