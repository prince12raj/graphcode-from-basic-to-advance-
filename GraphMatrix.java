import java.util.Scanner;
public class GraphMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();  
        int e = sc.nextInt();
        int[][] mat = new int[v][v];
        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int w = sc.nextInt();
            mat[u][w] = 1;
            mat[w][u] = 1; 
        }
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
