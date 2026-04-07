import java.io.*;
import java.util.*;
public class RoadConnection {
    static class DSU {
        int[] parent;
        int[] size;
        int components;
        int maxSize;
        DSU(int n) {
            parent = new int[n + 1];
            size = new int[n + 1];
            components = n;
            maxSize = 1;

            for (int i = 1; i <= n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }
        int find(int x) {
            if (parent[x] == x)
                return x;
            return parent[x] = find(parent[x]);
        }
        void union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if (pa == pb)
                return;
            if (size[pa] < size[pb]) {
                int temp = pa;
                pa = pb;
                pb = temp;
            }
            parent[pb] = pa;
            size[pa] += size[pb];
            maxSize = Math.max(maxSize, size[pa]);
            components--;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] firstLine = br.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int m = Integer.parseInt(firstLine[1]);
        DSU dsu = new DSU(n);
        for (int i = 0; i < m; i++) {
            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            dsu.union(a, b);
            sb.append(dsu.components).append(" ")
              .append(dsu.maxSize).append("\n");
        }
        System.out.print(sb);
    }
}