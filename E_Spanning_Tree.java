import java.util.*;
class E_Spanning_Tree {
    static class DSU{
        int parent[];
        int size[];
        int component;
        DSU(int n){
            parent = new int[n+1];
            size = new int[n+1];
            this.component =n;
            for(int i = 1 ; i<= n ; i++){
                parent[i] = i ;
                size[i] =1;
            }
        }
        int find(int x){
            if(x == parent[x]) return x;
            return parent[x] = find(parent[x]);
        }
        // boolean union(int x , int y){
        //     if(find(x) == find(y)) return false;
        //     if(size[find(x)] < size[find(y)]){
        //         parent[find(x)] = find(y);
        //         size[find(y)] += size[find(x)];
        //     }else{
        //         parent[find(y)] = find(x);
        //         size[find(x)] += size[find(y)];
        //     }
        //     component --;
        //     return true;
        // }
        boolean union(int x , int y){
            int px = find(x);
            int py = find(y);

            if(px == py) return false;

            if(size[px] < size[py]){
                parent[px] = py;
                size[py] += size[px];
            }else{
                parent[py] = px;
                size[px] += size[py];
            }
            component--;
            return true;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =  sc.nextInt();
        int m =  sc.nextInt();
        ArrayList<int[]> edges = new ArrayList<>();

        for(int i = 0 ; i < m ; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            edges.add(new int[]{a,b,c});
        }

        edges.sort((x,y) -> x[2] - y[2]);

        int sum = 0;
        DSU dsu = new DSU(n);

        for(int[] ab : edges){
            int u = ab[0];
            int v = ab[1];
            int c = ab[2];

            if(dsu.union(u,v)){
                sum += c;
            }
        }
        System.out.println(sum);

    }
}