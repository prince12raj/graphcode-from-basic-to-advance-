import java.util.*;
public class JzzhuandCities {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       int m = sc.nextInt();
       ArrayList<ArrayList<int[]>> adj = new ArrayList<>(); 
         for (int i = 0; i <= n; i++) {
              adj.add(new ArrayList<>());
         }
        for(int i = 0 ;i <m ;i++){
          int a =sc.nextInt();
          int b = sc.nextInt();
          int c =sc.nextInt();
          adj.get(a).add(new int[] {b , c});
          adj.get(b).add(new int[] {a ,c});
        }
        int k = sc.nextInt();
        ArrayList<ArrayList<int[]>> adjk = new ArrayList<>();
        for(int  i = 0; i < 3; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < k; i++){
            int u = 1;
            int v = sc.nextInt();
            int kj = sc.nextInt();
            adjk.get(u).add(new int[] {v , kj});
            adjk.get(v).add(new int[] {u , kj});

        }
    }
}
