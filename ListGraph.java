import java.util.*;
public class ListGraph {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();   
        for(int i = 0; i < v; i++) {
            adjList.add(new ArrayList<>());
            for(int add : adjList.get(i)) {
                System.out.print(add + " ");
            }
        }
        for(int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int w = sc.nextInt();
            adjList.get(u).add(w);
            adjList.get(w).add(u); 
        }
        for(int i = 0; i < v; i++) {
            System.out.println( i + ": " + adjList.get(i));
        }
    }
}
