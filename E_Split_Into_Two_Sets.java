import java.util.*;
public class E_Split_Into_Two_Sets {
    static class DSU {
        int parent[];
        int size[];
        DSU(int n) {
            parent = new int[n + 1];
            size = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }
        int find(int x) {
            if (x == parent[x]) return x;
            return parent[x] = find(parent[x]);
        }
        boolean union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px == py) return false;
            if (size[px] < size[py]) {
                parent[px] = py;
                size[py] += size[px];
            } else {
                parent[py] = px;
                size[px] += size[py];
            }
            return true;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int t = sc.nextInt();
        while (t-->0) {
            int n = sc.nextInt();
                int m = sc.nextInt();
                int k = sc.nextInt();
                for (int i = 0; i < m; i++) {
                    sc.nextInt();
                    sc.nextInt();
                }
                for (int i = 0; i < k; i++) {
                    sc.nextInt();
                    sc.nextInt();
                }
                System.out.println("YES");  
        }
    }
}