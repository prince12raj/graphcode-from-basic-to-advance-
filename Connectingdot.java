// import java.util.*;
// public class Connectingdot {
//     static class DSU {
//         int[] parent, size;
//         int components;
//         DSU(int n) {
//             parent = new int[n + 1];
//             size = new int[n + 1];
//             components = n;

//             for (int i = 1; i <= n; i++) {
//                 parent[i] = i;
//                 size[i] = 1;
//             }
//         }
//         int find(int x) {
//             if(parent[x] == x) return x;
//             return parent[x] = find(parent[x]);
            
//         }
//         void union(int a, int b) {
//             int pa = find(a);
//             int pb = find(b);
//             if (pa == pb) return;
//             if (size[pa] < size[pb]) {
//                 parent[pa] = pb;
//                 size[pb] += size[pa];
//             } else {
//                 parent[pb] = pa;
//                 size[pa] += size[pb];
//             }
//             components--;
//         }
//     }
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int t = sc.nextInt();
//         while (t-- > 0) {
//             int n = sc.nextInt();
//             int m = sc.nextInt();
//             DSU dsu = new DSU(n);
//             for (int i = 0; i < m; i++) {
//                 int a = sc.nextInt();
//                 int d = sc.nextInt();
//                 int k = sc.nextInt();
//                 for (int j = 1; j <=k; j++) {
//                     dsu.union(a, a+j*d);
//                 }
//             }
//             System.out.println(dsu.components);
//         }
//         sc.close();
//     }
// }
import java.util.*;
public class Connectingdot {
    static class DSU {
        int[] parent, size;
        int components;
        DSU(int n) {
            parent = new int[n + 1];
            size = new int[n + 1];
            components = n;

            for (int i = 1; i <= n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }
        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }
        void union(int a, int b) {
            a = find(a);
            b = find(b);
            if (a == b) return;
            if (size[a] < size[b]) {
                int temp = a;
                a = b;
                b = temp;
            }
            parent[b] = a;
            size[a] += size[b];
            components--;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] maxK = new int[n + 2][11];
            for (int i = 0; i < m; i++) {
                int a = sc.nextInt();
                int d = sc.nextInt();
                int k = sc.nextInt();
                maxK[a][d] = Math.max(maxK[a][d], k);
            }
            DSU dsu = new DSU(n);
            for (int d = 1; d <= 10; d++) {
                for (int i = 1; i <= n; i++) {
                    if (maxK[i][d] > 0 && i + d <= n) {
                        dsu.union(i, i + d);
                        maxK[i + d][d] = Math.max(maxK[i + d][d], maxK[i][d] - 1);
                    }
                }
            }

            System.out.println(dsu.components);
        }

        sc.close();
    }
}