import java.util.*;
public class Djikstrapractise {
//     static class pair{
//         int node;
//         int cost;
//         pair(int node ,int cost){
//             this.node = node;
//             this.cost =cost;
//         }
//     }
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int  n = sc.nextInt();
//         int m = sc.nextInt();
//         ArrayList<ArrayList<int []>> adj = new ArrayList<>();
//         for(int i = 0 ; i < n; i++){
//             adj.add(new ArrayList<>());
//         }
//         for(int i = 0; i <m; i++){
//             int a = sc.nextInt();
//             int b = sc.nextInt();
//             int w = sc.nextInt();
//             adj.get(a).add(new int[]{b,w});
//             adj.get(b).add(new int[]{a ,w});
//         }
//         PriorityQueue<pair> pq = new PriorityQueue<>((x ,y) -> x.cost -y.cost);
//         int dist[] = new int[n];
//         int parent[] = new int[n];
//         Arrays.fill(parent ,-1);
//         Arrays.fill(dist ,Integer.MAX_VALUE);
//         pq.offer(new pair(0, 0));
//         dist[0] =0;
//         while(!pq.isEmpty()){
//             pair cur =pq.poll();
//             int cost =cur.cost;
//             int  nod = cur.node;
//             if(cost > dist[nod]) continue;
//             for(int [] it : adj.get(nod)){
//                 int no = it[0];
//                 int cp = it[1];
//                 if(cost + cp < dist[no]){
//                     dist[no] =cost+cp;
//                     parent[no] =nod;
//                     pq.offer(new pair(no ,dist[no]));
//                 }
//             }
//         }
//         System.out.println(Arrays.toString(parent));
//         System.out.println(Arrays.toString(dist));
//     }
// }
    static class pair{
        int row;
        int col;
        int cost;
        pair(int row ,int col, int cost){
            this.row = row;
            this.col = col;
            this.cost = cost;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int grid[][] = new int[n][m];
        for(int i =0 ;i < n ; i++){
            for(int j =0 ; j < m; j++){
                grid[i][j] =sc.nextInt();
            }
        }
        PriorityQueue<pair> pq= new PriorityQueue<>((x,y) -> x.cost -y.cost);
        int parent[][] = new int[n][m];
        for(int a[]: parent){
            Arrays.fill(a ,-1);
        }
        int dist[][] =new int[n][m];
        for(int a[]: dist){
            Arrays.fill(a, Integer.MAX_VALUE);
        }
        pq.offer(new pair(0 ,0 ,grid[0][0]));
        dist[0][0] =grid[0][0];
        int dir[] ={-1 ,1,0,0};
        int dic[] ={0 ,0 ,-1,1};
        while(!pq.isEmpty()){
            pair cur =pq.poll();
            int r = cur.row;
            int c = cur.col;
            int cost =cur.cost;
            if(cost > dist[r][c]) continue;
            for(int i =0; i< 4 ;i++){
                int nr =r+dir[i];
                int nc =c+dic[i];
                if(nr >=0 && nc>=0 && nr <n && nc <m){
                    int ncost = cost + grid[nr][nc];
                    if(ncost < dist[nr][nc]){
                        dist[nr][nc] =ncost;
                        parent[nr][nc] = grid[r][c];
                        pq.offer(new pair(nr ,nc, ncost));
                    }
                }
            }
        }
        for(int i=0;i<n ;i++){
            System.out.println(Arrays.toString(dist[i]));
        }
        System.out.println(dist[n-1][m-1]);
        for(int i =0 ;i <n ;i++){
            System.out.println(Arrays.toString(parent[i]));
        }
    }
}

