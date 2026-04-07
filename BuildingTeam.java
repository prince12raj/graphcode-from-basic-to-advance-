// import java.util.*;
// public class BuildingTeam {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int m = sc.nextInt();
//         ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
//         for(int i=0; i<n ;i++){
//             adjList.add(new ArrayList<>());
//         }
//          for(int i=0; i<m ;i++){
//             int a = sc.nextInt() -1;
//             int b = sc.nextInt() -1;
//             adjList.get(a).add(b);
//             adjList.get(b).add(a);
//         }
//         int color[] =new int[n];
//         for(int i=0; i<n ;i++){
//             if(color[i] == 0){
//                 if(!dfs(i, adjList, color, 1)){
//                     System.out.println("IMPOSSIBLE");
//                     return;
//                 }
//             }
//         }        for(int i=0; i<n ;i++){
//             System.out.print(color[i] + " ");
//         }
//     }
//     public static boolean dfs(int node, ArrayList<ArrayList<Integer>> adjList, int color[], int c){
//         color[node] = c;
//         for(int adjNode : adjList.get(node)){
//             if(color[adjNode] == 0){
//                 if(!dfs(adjNode, adjList, color, 3-c)){
//                     return false;
//                 }
//             } else if(color[adjNode] == c){
//                 return false;
//             }
//         }
//         return true;
//     }
// }
import java.io.*;
import java.util.*;
public class BuildingTeam {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }
        int[] color = new int[n];
        for(int i = 0; i < n; i++){
            if(color[i] == 0){
                if(!dfs(i, adjList, color, 1)){
                    System.out.println("IMPOSSIBLE");
                    return;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            sb.append(color[i]).append(" ");
        }

        System.out.println(sb);
    }
    public static boolean dfs(int node, ArrayList<ArrayList<Integer>> adjList, int[] color, int c){
        color[node] = c;

        for(int adjNode : adjList.get(node)){
            if(color[adjNode] == 0){
                if(!dfs(adjNode, adjList, color, 3 - c)){
                    return false;
                }
            } 
            else if(color[adjNode] == c){
                return false;
            }
        }

        return true;
    }
}
