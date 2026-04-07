// import java.util.*;
// class D_Cutting_a_graph {
//     static class DSU{
//         int parent[] ;
//         int size [];
//         DSU(int n){
//             parent = new int[n+1];
//             size = new int[n+1];
//             for(int i = 0 ; i < n ; i ++){
//                 parent[i] = i;
//                 size[i] =1;
//             }
//         }
//         int find(int x){
//             if(x == parent[x]) return x;
//             return parent[x] = find(parent[x]);
//         }
//         boolean union(int x , int y){
//             int px =  find(x);
//             int py = find(y);
//             if(px == py) return false;
//             if (size[px] < size[py]) {
//                 parent[px] = py;
//                 size[py] += size[px];
//             } else {
//                 parent[py] = px;
//                 size[px] += size[py];
//             }
//             return true;
//         }
//         boolean isask(int x ,int y){
//             if(find(x) == find(y)) return true;
//             return false;
//         }
//         int cut(int x , int y){
//             if(union(x,y)){
                
//             }

//         }

//     }
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int m =  sc.nextInt();
//         int k =  sc.nextInt();
//         DSU dsu = new DSU(n);
//         for(int i = 0 ; i < m ; i++){
//             int u =  sc.nextInt();
//             int v =  sc.nextInt();
//             dsu.union(u,v);
//         }
//         while(k --> 0){
//             String t = sc.next();
//             if(t.equals("ask")){
//                 int u = sc.nextInt();
//                 int v = sc.nextInt();
//                 if(dsu.isask(u,v)){
//                     System.out.println("YES");
//                 }else{
//                     System.out.println("NO");
//                 }
//             }
//             if(t.equals("cut")){
//                 int u = sc.nextInt();
//                 int v = sc.nextInt();
//                 if(dsu.union(u,v)){
//                     dsu.cut(u,v);
//                 }
//             }
//         }
//     }
// }
import java.util.*;
public class D_Cutting_a_graph {
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

        boolean isask(int x, int y) {
            return find(x) == find(y);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        DSU dsu = new DSU(n);
        for (int i = 0; i < m; i++) {
            sc.nextInt();
            sc.nextInt();
        }
        String type[] = new String[k];
        int u[] = new int[k];
        int v[] = new int[k];
        for (int i = 0; i < k; i++) {
            type[i] = sc.next();
            u[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }
        ArrayList<String> ans = new ArrayList<>();
        for (int i = k - 1; i >= 0; i--) {
            if (type[i].equals("ask")) {
                if (dsu.isask(u[i], v[i]))
                    ans.add("YES");
                else
                    ans.add("NO");
            } else {
                dsu.union(u[i], v[i]);
            }
        }
        Collections.reverse(ans);
        for (String s : ans)
            System.out.println(s);
    }
}