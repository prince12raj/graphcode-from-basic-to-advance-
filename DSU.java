import java.util.*;
public class DSU {
    private class ds{
        int []parent;
        int [] size;
        int component;
        ds(int n){
            parent = new int[n+1];
            size = new int[n+1];
            this.component = n;
            for(int i = 0; i <=n; i++){
                parent[i] = i;
                size[i] = 1;
            }
        }
        int find(int x){
            if(parent[x] == x) return x;
            return parent[x] = find(parent[x]);
        }
        void unions(int x ,int y){
            int px =find(x);
            int py =find(y);
            if(px == py) return;
            if(size[px] < size[py]){
                parent[px] =py;
                size[py] += size[px];
            }
            else{
                parent[py] =px;
                size[px]+= size[py];
            }
            component--;
        }
        boolean isSameSet(int x, int y) {
            return find(x) == find(y);
        }

    }
    public static void main(String[] args) {
        DSU dsu = new DSU();
        ds d = dsu.new ds(6);
        d.unions(1, 6);
        d.unions(6, 5);
        System.out.println(d.component);
        System.out.println( d.isSameSet(3, 6));
        d.unions(1, 3);
        System.out.println(d.component);
        System.out.println(d.isSameSet(1, 3));
        // given
        // unniversal set u = {1, 2, 3, 4, 5};
        // 1 union 1 6
        // 2 union 6 5 
        // how manny component;
        // is 3 and 6 is in same set;
        // 3 union 1 3 
        // how manny component;
        // is 1 and 3 is in same set;
        
    }
}
