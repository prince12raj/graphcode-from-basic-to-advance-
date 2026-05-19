import java.util.*;
public class FDenseSpanningTree {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] degree = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            degree[u]++;
            degree[v]++;
        }
    }
}
