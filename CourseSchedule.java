// import java.util.*;
// public class CourseSchedule {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int m = sc.nextInt();        
//         ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
//         for (int i = 0; i <= n; i++) {
//             adj.add(new ArrayList<>());
//         }
//         int[] indegree = new int[n + 1];
//         for (int i = 0; i < m; i++) {
//             int a = sc.nextInt();
//             int b = sc.nextInt();
//             adj.get(a).add(b);
//             indegree[b]++;
//         }
//         Queue<Integer> q = new LinkedList<>();
//         for (int i = 1; i <= n; i++) {
//             if (indegree[i] == 0) {
//                 q.add(i);
//             }
//         }
//         ArrayList<Integer> res = new ArrayList<>();
//         while (!q.isEmpty()) {
//             int u = q.poll();
//             res.add(u);
//             for (int v : adj.get(u)) {
//                 indegree[v]--;
//                 if (indegree[v] == 0) {
//                     q.add(v);
//                 }
//             }
//         }
//         if (res.size() != n) {
//             System.out.println("IMPOSSIBLE");
//             return;
//         }
//         for (int x : res) {
//             System.out.print(x + " ");
//         }
//     }
// }
import java.io.*;
import java.util.*;
public class CourseSchedule {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj.get(a).add(b);
            indegree[b]++;
        }
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) {
            int u = q.poll();
            res.add(u);
            for (int v : adj.get(u)) {
                if (--indegree[v] == 0) {
                    q.add(v);
                }
            }
        }
        if (res.size() != n) {
            System.out.println("IMPOSSIBLE");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int x : res) {
            sb.append(x).append(" ");
        }
        System.out.println(sb.toString());
    }
}
