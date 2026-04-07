// import java.util.*;
// import java.io.*;
// class dsu{
//     int []parent;
//     int []size;
//     int connections;
//     public dsu(int n){
//         parent=new int[n+1];
//         size=new int[n+1];
//         connections=n;
    
//         for(int i=0;i<=n;i++){
//             parent[i]=i;
//             size[i]=1;
//         }
//     }
//     public int find(int u){
//         if(parent[u]==u) return u;
//         return parent[u]=find(parent[u]);
//     }
//     public boolean unions(int u,int v){
//         int pu=find(u);
//         int pv=find(v);
//         if(pu==pv) return false;
//         if(size[pu]<size[pv]){
//             parent[pu]=pv;
//             size[pv]+=size[pu];
//         }else{
//             parent[pv]=pu;
//             size[pu]+=size[pv];
//         }
//         connections--;
//         return true;
//     }
// }
// public class NetworkBreakDown{
//     static class Pair{
//         int u;
//         int v;
//         public Pair(int u,int v){
//             this.u=u;
//             this.v=v;
//         }
//     }
//     public static void main(String []args)throws Exception {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine());

//         int n = Integer.parseInt(st.nextToken());
//         int m = Integer.parseInt(st.nextToken());
//         int k=Integer.parseInt(st.nextToken());
//         List<Pair> set=new ArrayList<>();
//         List<Pair> breakdown=new ArrayList<>();
//         for(int i=0;i<m;i++){
//             st = new StringTokenizer(br.readLine());
//             int u=Integer.parseInt(st.nextToken());
//             int v=Integer.parseInt(st.nextToken());
//             set.add(new Pair(u,v));
//         }
//         for(int i=0;i<k;i++){
//             st = new StringTokenizer(br.readLine());
//             int u=Integer.parseInt(st.nextToken());
//             int v=Integer.parseInt(st.nextToken());
//             breakdown.add(new Pair(u,v));
//         }
//         for(Pair p:breakdown){
//             set.removeIf(e->(e.u==p.u && e.v==p.v) || (e.u==p.v && e.v==p.u));
//         }
//         dsu ds=new dsu(n);
        
//         for(Pair p:set){
//             ds.unions(p.u,p.v);
//         }
//         List<Integer> ans=new ArrayList<>();
//         for(int i=breakdown.size()-1;i>=0;i--){
//             ans.add(ds.connections);
//             ds.unions(breakdown.get(i).u,breakdown.get(i).v);
//         }
//         for(int i=ans.size()-1;i>=0;i--){
//             System.out.print(ans.get(i)+ " ");
//         }

//     }
// }
import java.util.*;
import java.io.*;
class DSU {
    int[] parent;
    int[] size;
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
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa == pb) return;
        if (size[pa] < size[pb]) {
            parent[pa] = pb;
            size[pb] += size[pa];
        } else {
            parent[pb] = pa;
            size[pa] += size[pb];
        }

        components--;
    }
}

public class NetworkBreakDown {
    static class Pair {
        int u, v;
        Pair(int u, int v) {
            this.u = u;
            this.v = v;
        }
    }

    static long encode(int u, int v) {
        if (u > v) {
            int temp = u;
            u = v;
            v = temp;
        }
        return ((long) u << 32) | v;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<Pair> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            edges.add(new Pair(u, v));
        }
        List<Pair> queries = new ArrayList<>();
        HashSet<Long> removed = new HashSet<>();
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            queries.add(new Pair(u, v));
            removed.add(encode(u, v));
        }
        DSU dsu = new DSU(n);
        for (Pair e : edges) {
            if (!removed.contains(encode(e.u, e.v))) {
                dsu.union(e.u, e.v);
            }
        }

        int[] ans = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            ans[i] = dsu.components;
            dsu.union(queries.get(i).u, queries.get(i).v);
        }
        StringBuilder sb = new StringBuilder();
        for (int x : ans) {
            sb.append(x).append(" ");
        }

        System.out.println(sb);
    }
}
        // use logic that first join the node which is not in brekdown 
        // then count the component
        // then add the component in reverse order 
        // if the node is joinng two different component 
        // then decrese the component count and 
        // return the component;
        // we can make set of all connection that m (u and v)
        // and add all broken connection in array
        // check the all broken connection not paresent in set 
        //than add them and prosees the further steps;