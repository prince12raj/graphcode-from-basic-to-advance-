import java.util.*;
public class A_People_are_leaving {
    static class DSU{
        int [] parent;
        int [] size;
        DSU(int n){
            parent =  new int[n+1];
            size =  new int[n+1];
            for(int i = 0 ; i < n ; i++){
                parent[i] = i;
                size[i] = 1;
            }
        }
        int find(int x){
            if(x== parent[x]) return x;
            return parent[x] = find(parent[x]);
        }
        void union(int x ,int y){
            int px = find(x);
            int py = find(y);
            if(px == py) return;
            if(size[px] < size[py]){
                parent[px] =py;
                size[py] += size[px];
            }else{
                parent[py] =px;
                size[px] += size[py];
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new  Scanner(System.in);
        int n =  sc.nextInt();
        int m =  sc.nextInt();
        DSU dsu = new DSU(n);
        while(m --> 0) {
            String s = sc.next();
            if(s.equals("-")){
                int x = sc.nextInt();
            }
            if(s.equals("?")){
                int x = sc.nextInt();
                
            }
        }
    }
}
